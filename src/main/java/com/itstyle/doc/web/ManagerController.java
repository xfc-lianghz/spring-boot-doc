package com.itstyle.doc.web;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itstyle.doc.repository.MemberRepository;
@Controller
@RequestMapping(value = "")
public class ManagerController {
	private static final Logger logger = LoggerFactory.getLogger(ManagerController.class);
	
	@Autowired
	MemberRepository memberRepository;
	
}
