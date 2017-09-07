package com.itstyle.doc.web;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.itstyle.doc.common.constans.Constans;
import com.itstyle.doc.common.constans.Option;
import com.itstyle.doc.common.utils.MD5Util;
import com.itstyle.doc.common.utils.Result;
import com.itstyle.doc.model.Books;
import com.itstyle.doc.model.Member;
import com.itstyle.doc.repository.BooksRepository;
import com.itstyle.doc.repository.MemberRepository;
import com.itstyle.doc.repository.OptionsRepository;
@Controller
@RequestMapping(value = "")
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private OptionsRepository optionsRepository;
	@Autowired
	private BooksRepository booksRepository;
	@Autowired
	MemberRepository memberRepository;
	@Autowired  
	private DefaultKaptcha defaultKaptcha;
	
	@RequestMapping(value="index",method=RequestMethod.GET)
    public String  index(ModelMap map) {
		 logger.info("首页");
		 map.addAttribute("SITE_NAME", Constans.mapOptions.get(Option.SITE_NAME.getCode()));
		 List<Books> bookList =  booksRepository.findAll();
		 map.addAttribute("bookList",bookList);
		 return "home/index";
    }
	@RequestMapping(value="login",method=RequestMethod.GET)
    public String  login(ModelMap map) {
		 logger.info("用户登陆 ");
		 map.addAttribute("SITE_NAME", Constans.mapOptions.get(Option.SITE_NAME.getCode()));
		 map.addAttribute("ENABLED_REGISTER", Constans.mapOptions.get(Option.ENABLED_REGISTER.getCode()));
		 map.addAttribute("ENABLED_CAPTCHA", Constans.mapOptions.get(Option.ENABLED_CAPTCHA.getCode()));
		 return "account/login";
    }
	@RequestMapping(value="login",method=RequestMethod.POST)
    public @ResponseBody Result  login(Member member, String code,HttpServletRequest request) {
		 Result result = new Result();
		 logger.info("用户登陆 ");
		 Member user = memberRepository.findByAccount(member.getAccount());
		 String vrifyCode =  (String) request.getSession().getAttribute("vrifyCode");
		 if(vrifyCode.equalsIgnoreCase(code)){
			 if(user!=null){
				 if(user.getPassword().equals(MD5Util.MD5(member.getPassword()))){
					 request.getSession().setAttribute(Constans.CURRENT_USER, user);
					 result.setCode(Constans.SUCCESS);
				 }else{
					 result.setCode(Constans.ERROR);
					 result.setMsg("密码错误");
				 }
			 }else{
				 result.setCode(Constans.ERROR);
				 result.setMsg("账号不存在");
			 }
		 }else{
			 result.setCode(Constans.ERROR);
			 result.setMsg("验证码错误");
		 }
		 return result;
    }
	@RequestMapping("/defaultKaptcha")  
    public void defaultKaptcha(HttpServletRequest httpServletRequest,HttpServletResponse httpServletResponse) throws Exception{  
	     byte[] captchaChallengeAsJpeg = null;    
	     ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();    
	     try {    
	     String createText = defaultKaptcha.createText();  
	     httpServletRequest.getSession().setAttribute("vrifyCode", createText);  
	     BufferedImage challenge = defaultKaptcha.createImage(createText);  
	     ImageIO.write(challenge, "jpg", jpegOutputStream);  
	     } catch (IllegalArgumentException e) {    
	         httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);    
	         return;    
	     }   
	     captchaChallengeAsJpeg = jpegOutputStream.toByteArray();    
	     httpServletResponse.setHeader("Cache-Control", "no-store");    
	     httpServletResponse.setHeader("Pragma", "no-cache");    
	     httpServletResponse.setDateHeader("Expires", 0);    
	     httpServletResponse.setContentType("image/jpeg");    
	     ServletOutputStream responseOutputStream =    
	             httpServletResponse.getOutputStream();    
	     responseOutputStream.write(captchaChallengeAsJpeg);    
	     responseOutputStream.flush();    
	     responseOutputStream.close();    
    }  
}
