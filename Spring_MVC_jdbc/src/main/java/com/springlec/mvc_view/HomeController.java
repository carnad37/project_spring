package com.springlec.mvc_view;


import java.util.List;
import java.util.Locale;

//import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springlec.dto.Employee;
import com.springlec.service.EmployService;
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
	@RequestMapping(value = "/")
	public String home() {
				
		return "result";
	}
	
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
    	
    	System.out.println(employee.getId()+", "+employee.getName()+", "+employee.getAge()+", "+employee.getDept());
        employeeSvc.saveEmployee(employee);
        
        return "redirect:/employees";
    }
   
    @RequestMapping(value = "/employees")
    public String listEmployees(Model model)
    {
		System.out.println("listEmployees");
		List<Employee> employeeList = employeeSvc.getAllEmployees();
		System.out.println(employeeList);
		model.addAttribute("employeeList", employeeList);      
	
        return "listEmployees";
    }
	
//
//	@RequestMapping(value = "/checkId", method = RequestMethod.GET)
//	public String checkId(@ModelAttribute("m") Employee member) {
//		return "print_login";
//	}

}
