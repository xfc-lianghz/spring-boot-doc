package com.itstyle.doc.web;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itstyle.doc.common.constans.Constans;
import com.itstyle.doc.common.utils.MD5Util;
import com.itstyle.doc.common.utils.Result;
import com.itstyle.doc.model.Member;
import com.itstyle.doc.repository.MemberRepository;
@Controller
@RequestMapping(value = "setting")
public class SettingController {
	private static final Logger logger = LoggerFactory.getLogger(SettingController.class);
	
	@Autowired
	MemberRepository memberRepository;
	
	@RequestMapping(value="",method=RequestMethod.GET)
    public String  setting() {
		 logger.info("用户中心 ");
		 return "setting/index";
    }
	@RequestMapping(value="password",method=RequestMethod.GET)
    public String  password() {
		 logger.info("修改密码 ");
		 return "setting/password";
    }
	@RequestMapping(value="password",method=RequestMethod.POST)
    public @ResponseBody Result password(String password,String newPassword,HttpServletRequest request) {
		 logger.info("用户登陆 ");
		 Member member = (Member) request.getSession().getAttribute(Constans.CURRENT_USER);
		 Result result = new Result();
		 if(member.getPassword().equals(MD5Util.MD5(password))){
			 member.setPassword( MD5Util.MD5(newPassword));
			 memberRepository.save(member);
			 result.setCode(Constans.SUCCESS);
		 }else{
			 result.setCode(Constans.ERROR);
			 result.setMsg("原始密码错误");
		 }
		 return result;
    }
	@RequestMapping(value="modfiyUser",method=RequestMethod.POST)
    public @ResponseBody Result modfiyUser(String email,String phone,String description,HttpServletRequest request) {
		 logger.info("修改用户信息 ");
		 Member member = (Member) request.getSession().getAttribute(Constans.CURRENT_USER);
		 Result result = new Result();
		 member.setEmail(email);
		 member.setPhone(phone);
		 member.setDescription(description);
		 memberRepository.save(member);
		 result.setCode(Constans.SUCCESS);
		 return result;
    }
}
