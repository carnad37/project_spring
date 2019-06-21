package com.springlec.mvc_view_controller;


import java.util.Locale;

//import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springlec.dto.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "login";
	}
	
//	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
//	public String checkId(HttpServletRequest httpServletRequest, Model model) {
//		String id = httpServletRequest.getParameter("id");
//		String pw = httpServletRequest.getParameter("pw");
//		model.addAttribute("id", id);
//		model.addAttribute("pw", pw);		
//		return "print_login";
//	}
	
//	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
//	public String checkId(String id, String pw, Model model) {
//		model.addAttribute("id", id);
//		model.addAttribute("pw", pw);		
//		return "print_login";
//	}
	
//	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
//	public String checkId(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
//		model.addAttribute("id", id);
//		model.addAttribute("pw", pw);		
//		return "print_login";
//	}

//	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
//	public String checkId(Member member, Model model) {
//		if (member == null) {
//			System.out.println("member is null");
//		} else {
//			System.out.println("member is fill");
//			System.out.println(member.getClass());
//		}
//		model.addAttribute("id", member.getId());
//		model.addAttribute("pw", member.getPw());		
//		return "print_login";
//	}
	
//	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
//	public String checkId(@ModelAttribute Member member) {
//		return "print_login";
//	}
	
	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
	public String checkId(@ModelAttribute("m") Member member) {
		return "print_login";
	}

}
