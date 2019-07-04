package com.plz.mok_test;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.plz.dao.CmemberDao;
import com.plz.dto.Cmember;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private CmemberDao dao;	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/rowCount")
	public String test(Model model) {
		int data = dao.getCountRecord();
		model.addAttribute("row", data);
		return "result";
	}
	
	@RequestMapping("/getPwOfId")
	public String getPwOfId(String id, Model model) {
		List<String> data = dao.getPwOfId(id);
		model.addAttribute("pw", data);
		return "result";
	}
	

	@RequestMapping("/getIdOfcNum")
	public String getIdOfcNum(String cNum ,Model model) {	
		List<String> data = dao.getIdOfcNum(Integer.parseInt(cNum));
		model.addAttribute("cNum", data);
		return "result";
	}
	
	@RequestMapping("/setRecord")
	public String setRecord(@ModelAttribute Cmember cmember, Model model) {
		int res = dao.setRecord_unit(cmember);
		model.addAttribute("result", res);
		return "result";
	}
	
	@RequestMapping("/delRecordByName")
	public String delRecordByName(String name, Model model) {
		int res = dao.delRecordByName(name);
		model.addAttribute("result", res);
		return "result";
	}
	
	@RequestMapping("/updateRecordById")
	public String updateRecordById(String id, String nPw, Model model) {
		int res = dao.updateRecordById(id, nPw);
		System.out.println(res);
		model.addAttribute("result", res);
		return "result";
	}
	
	@RequestMapping("/getRecordByNameAndCNum")
	public String getRecordByNameAndCNum(String id, String cNum, Model model) {
		List<Cmember> memeberList = dao.getRecordByNameAndCNum(id, Integer.parseInt(cNum));
		model.addAttribute("result", memeberList);
		return "result";
	}

}
