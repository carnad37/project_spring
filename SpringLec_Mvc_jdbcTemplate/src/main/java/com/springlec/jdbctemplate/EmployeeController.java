package com.springlec.jdbctemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeSvc;

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
}
