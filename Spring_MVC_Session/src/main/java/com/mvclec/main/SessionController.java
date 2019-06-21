package com.mvclec.main;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.test.dto.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/board")
//@SessionAttributes("member")
public class SessionController {
	
	private static final Logger logger = LoggerFactory.getLogger(SessionController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	SessionController() {
//		getMemberObj();
//	}
//	
//	@ModelAttribute("member")
//	public Member getMemberObj() {
//		return new Member();
//	}
//	
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String home(@ModelAttribute Member member) {
		System.out.println("data");
		System.out.println(member.getId());
		System.out.println(member.getPw());
		return "/board/view";
	}


	
}
