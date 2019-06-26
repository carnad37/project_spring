package com.mylec.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mylec.dto.BookData;
import com.mylec.service.BookService;

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
	private BookService bookService; 

	@RequestMapping("/")
	public String viewFrontPage() {
		return "main";
	}
	
	@RequestMapping(value="/search_checkOuted", method=RequestMethod.GET)
	public String getDataByCheckOuted(String checkOuted, Model model) {
		checkOuted = checkOuted.toLowerCase();
		boolean check = false;
		if (checkOuted.equals("true")) {
			check = true;
		} else if(!checkOuted.equals("false")) {
			model.addAttribute("result", "error_word");
			return "error";
		}
		List<BookData> bookList = bookService.getDataByCheckOuted(check);
		if (bookList == null) {
			model.addAttribute("result", "error_data");
			return "error";
		}
		model.addAttribute("list", bookList);
		model.addAttribute("result", "getDataByCheckOuted");
		return "result";
	}
	
	@RequestMapping(value="/search_price", method=RequestMethod.GET)
	public String getNameByPrice(String price, Model model) {
		List<String> nameList = null;
		try {
			nameList = bookService.getNameByPriceOver(Integer.parseInt(price));
		} catch (NumberFormatException e) {
			model.addAttribute("result", "error_number");
			return "error";
		}
		if (nameList == null) {
			model.addAttribute("result", "error_data");
			return "error";
		}
		model.addAttribute("list", nameList);
		model.addAttribute("result", "getPublisherByAuthor");
		return "result";
	}
	
	@RequestMapping(value="/search_author", method=RequestMethod.GET)
	public String getPublisherByAuthor(String author, Model model) {
		List<String> publisherList = bookService.getPublisherByAuthor(author);
		if (publisherList == null) {
			model.addAttribute("result", "error_data");
			return "error";
		}
		model.addAttribute("list", publisherList);
		model.addAttribute("result", "getPublisherByAuthor");
		return "result";
	}
	
	@RequestMapping(value="/search_bookNum", method=RequestMethod.GET)
	public String getNameANDCheckOutedByBookNum(String bookNum, Model model) {
		List<BookData> bookNumList = bookService.getNameANDCheckOutedByBookNum(bookNum);
		if (bookNumList == null) {
			model.addAttribute("result", "error_data");
			return "error";
		}
		model.addAttribute("list", bookNumList);
		model.addAttribute("result", "getNameANDCheckOutedByBookNum");
		return "result";
	}
}
