package com.itstyle.doc.web;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itstyle.doc.common.constans.Constans;
import com.itstyle.doc.common.constans.Option;
import com.itstyle.doc.model.Books;
import com.itstyle.doc.repository.BooksRepository;
import com.itstyle.doc.repository.MemberRepository;
@Controller
@RequestMapping(value = "")
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	private BooksRepository booksRepository;
	@Value("${server.path}")
	private String serverPath;
	
	@RequestMapping(value="book",method=RequestMethod.GET)
    public String  book(ModelMap map) {
		 logger.info("查看项目");
		 map.addAttribute("SITE_NAME", Constans.mapOptions.get(Option.SITE_NAME.getCode()));
		 List<Books> bookList =  booksRepository.findAll();
		 map.addAttribute("bookList",bookList);
		 map.addAttribute("serverPath",serverPath);
		 return "book/index";
    }
	
}
