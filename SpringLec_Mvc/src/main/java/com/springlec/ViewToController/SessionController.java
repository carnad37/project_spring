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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springlec.dto.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/session")
@SessionAttributes("member")
public class SessionController {
	
	private static final Logger logger = LoggerFactory.getLogger(SessionController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	SessionController()
	{
		getMemberObj();
	}
	@ModelAttribute("member")
	public Member getMemberObj() {
	    return new Member();
	}
	
	@RequestMapping(value = "/changePwFrom", method = RequestMethod.GET)
	public String changePwFomr(@ModelAttribute Member member) {
		System.out.println("changePwFomr");
		
		member.setId("apple");
		member.setPw("orange");
		return "changePw";
	}
	
	@RequestMapping(value = "/changePw", method = RequestMethod.GET)
	public String changePw(@ModelAttribute Member member) {
		System.out.println("changePw");
		System.out.println(member.getId());
		System.out.println(member.getPw());
		return "login";
	}
	
}
