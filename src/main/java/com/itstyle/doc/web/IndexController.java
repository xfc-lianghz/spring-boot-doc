package com.itstyle.doc.web;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itstyle.doc.common.constans.Option;
import com.itstyle.doc.model.Books;
import com.itstyle.doc.model.Options;
import com.itstyle.doc.repository.BooksRepository;
import com.itstyle.doc.repository.OptionsRepository;
@Controller
@RequestMapping(value = "")
public class IndexController {
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private OptionsRepository optionsRepository;
	@Autowired
	private BooksRepository booksRepository;
	
	@RequestMapping(value="index",method=RequestMethod.GET)
    public String  index(ModelMap map) {
		logger.info("首页");
		//网站名称
		Options option =  optionsRepository.findByOptionName(Option.SITE_NAME.getCode());
		map.addAttribute("siteName", option.getOptionValue());
		//获取项目
		List<Books> bookList =  booksRepository.findAll();
		map.addAttribute("bookList",bookList);
		return "home/index";
    }
	
}
