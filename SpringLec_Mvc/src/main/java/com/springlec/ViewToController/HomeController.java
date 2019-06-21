package com.springlec.ViewToController;



import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public String home() {
		System.out.println("login");
//		return "/ViewToController/login";
		return "login";
	}
	/*@RequestMapping(value = "/checkId", method = RequestMethod.GET)
	public String checkId(HttpServletRequest httpServletRequest, Model model) {
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "checkId";
	}
	
	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
	public String checkId(String id, String pw, Model model) {
		
		System.out.println(id+", "+pw);
		model.addAttribute("id", id );
		model.addAttribute("pw", pw );
		return "checkId";
	}
	
	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		
		System.out.println(id+", "+pw);
		model.addAttribute("id", id );
		model.addAttribute("pw", pw );
		return "checkId";
	}

	
	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
	public String checkId(Member member, Model model) {
		
		String id=member.getId();
		String pw=member.getPw();
		model.addAttribute("id", id );
		model.addAttribute("pw",pw );
		return "checkId";
	}
	*/	
	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
	public String checkId(@ModelAttribute Member member) {

		return "modelAttribute_checkId";
	}
	/*
	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
	public String shot(@ModelAttribute("m")	 Member member) {
		System.out.println(member.getId());
		System.out.println(member.getPw());
		return "shot";
	}
	


	@RequestMapping(value = "/checkId/{num}", method = RequestMethod.GET)
	public String checkId(@PathVariable String num, Model model) {
		model.addAttribute("num", num );
		return "pathVariable_check";
	}
	
	
	// ModelAndView
	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
	public String checkId(String id, String pw) {
		

		ModelAndView mv = new ModelAndView();
		
		mv.addObject("id", id );
		mv.addObject("pw", pw );
		mv.setViewName("checkId");
		
		return "mv";
	}
	*/
}
