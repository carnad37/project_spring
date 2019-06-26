package com.mylec.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mylec.dto.Bmember;
import com.mylec.service.BmemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home(Locale locale, Model model) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
//		
//		return "home";
//	}
	
	@Autowired
	private BmemberService bmemberService;
	
	@RequestMapping("/")
	public String mainPage() {
		return "main";
	}
	
	@RequestMapping("/go_main")
	public String goMain() {
		return "main";
	}
	
    @RequestMapping(value = "getPwById",method=RequestMethod.GET)
    public String getPwById(String id, Model model) {
    	String pw = bmemberService.getPwById(id);
    	if (pw == null) {
        	model.addAttribute("result", "no_data");
		} else {
	    	model.addAttribute("result", "getPwById");
	    	model.addAttribute("pw", pw);
		}
    	return "result";
    }
    
    @RequestMapping(value = "/getDataById",method=RequestMethod.GET)
    public String getDataById(String id, Model model) {
    	Bmember bmember = bmemberService.getPwAndNameById(id);
    	if (bmember == null) {
        	model.addAttribute("result", "no_data");
		} else {
	    	model.addAttribute("result", "getDataById");
	    	model.addAttribute("pw", bmember.getPw());
	    	model.addAttribute("name", bmember.getName());
		}

    	return "result";
    }
    
    @RequestMapping(value = "/getIdByName",method=RequestMethod.GET)
    public String getIdByName(String name, Model model) {    	
    	List<String> idList = bmemberService.getIdByName(name);
    	System.out.println("idList : " + idList.size());
    	if (idList.isEmpty()) {
	    	model.addAttribute("result", "no_data");
		} else {
	    	model.addAttribute("result", "getIdByName");
	    	model.addAttribute("list", idList);
		}

    	return "result";
    }
    
    @RequestMapping(value = "/getDataByName",method=RequestMethod.GET)
    public String getDataByName(String name, Model model) {
    	
    	List<Bmember> memberList = bmemberService.getIdAndPwByName(name);
    	System.out.println("memberList : " + memberList.size());

    	if (memberList.isEmpty()) {
	    	model.addAttribute("result", "no_data");
		} else {
	    	model.addAttribute("result", "getDataByName");
		}
    	model.addAttribute("list", memberList);
    	return "result";
    }
	
}
