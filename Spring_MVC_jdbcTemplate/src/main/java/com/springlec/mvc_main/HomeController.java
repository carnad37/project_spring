package com.springlec.mvc_main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springlec.dto.Employee;
import com.springlec.service.EmployServiceImpl;

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
	
//	@RequestMapping(value = "/")
//	public String home() {
//				
//		return "result";
//	}
//	

	@Autowired
    private EmployServiceImpl employeeSvc;

    @RequestMapping("/")
    public String showInput()
    {
    	return "employeeFrom";
    }
    
    @RequestMapping(value = "/employee",method=RequestMethod.GET)
    public String saveEmployee(Employee employee)
 
    {
    	System.out.println("saveEmployee");    	
    	System.out.println(employee.getId() + ", " + employee.getName()+", "+employee.getAge()+", "+employee.getDept());
        employeeSvc.saveEmployee(employee);        
        return "redirect:/employees";
    }
   
    @RequestMapping(value = "/employees")
    public String listEmployees(Model model)
    {
		System.out.println("listEmployees");
		if (employeeSvc == null) {
			System.out.println("employeeSvc is null");
		} else {
			System.out.println("employeeSvc is not null");
		}
		System.out.println();
		List<Employee> employeeList = employeeSvc.getAllEmployees();
		System.out.println(employeeList);
		model.addAttribute("employeeList", employeeList);      
	
        return "listEmployees";
    }
	
}
