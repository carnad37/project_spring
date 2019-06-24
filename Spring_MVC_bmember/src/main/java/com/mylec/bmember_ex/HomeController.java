package com.mylec.bmember_ex;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mylec.dto.Bmember;
import com.mylec.service.BmemberServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private BmemberServiceImpl bmemberService;
	
    @RequestMapping("/")
    public String showInput() {
    	return "home";
    }
    
    @RequestMapping("/go_home")
    public String goHome() {
    	return "home";
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
    	System.out.println("test");
    	Bmember bmember = bmemberService.getDataById(id);
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
    	
    	List<Bmember> memberList = bmemberService.getDataByName(name);
    	if (memberList.isEmpty()) {
	    	model.addAttribute("result", "no_data");
		} else {
	    	model.addAttribute("result", "getDataByName");
		}
    	model.addAttribute("list", memberList);
    	return "result";
    }
	
}
