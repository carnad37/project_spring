package com.springlec.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
    private EmployeeService employeeSvc;

    @RequestMapping("/")
    public String showInput()
    {
    	System.out.println("showInput");
    	return "employeeFrom";
    }
    
    @RequestMapping(value ="/employee",method=RequestMethod.GET)
    public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee)
    {
    	System.out.println("saveEmployee");
    	System.out.println(employee.getId()+", "+employee.getName()+", "+employee.getAge()+", "+employee.getDept());
        employeeSvc.saveEmployee(employee);
        return new ModelAndView("redirect:/employees");
    }
   
    @RequestMapping(value ="/employees")
    public ModelAndView listEmployees(@ModelAttribute("employee") Employee employee)
    {
		System.out.println("listEmployees");
		ModelAndView model = new ModelAndView("listEmployees");
		List<Employee> employeeList = employeeSvc.getAllEmployees();
		System.out.println(employeeList);
		model.addObject("employeeList", employeeList);        
        return model;
    }
	
}
