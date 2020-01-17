package mvcemp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EmpController {
	@Autowired
	EmpDao dao;
	@RequestMapping(value="/addemp", method=RequestMethod.GET)
	public String ShowAddCustomerForm(){
		return "AddCustomer";
	}
	@RequestMapping(value="/addemp", method=RequestMethod.POST)
	public ModelAndView addCustomer(@ModelAttribute("employee") Employee emp){
		ModelAndView mav = new ModelAndView();
		dao.addEmployee(emp);
		mav.setViewName("redirect:viewemployee");
		return mav;
	}
	@RequestMapping(value="/viewemployee")
	public ModelAndView getEmployee(){
		ModelAndView mav = new ModelAndView();
		List<Employee> list = dao.getEmployee();
		mav.addObject("employees", list);
		mav.setViewName("ViewEmployees");
		return mav;
	}
	@RequestMapping(value="/updateemp", method=RequestMethod.GET)
	public ModelAndView updateEmployeeForm(int code){
		Employee employee = dao.getEmployee(code);
		ModelAndView mav = new ModelAndView();
		mav.addObject("emp", employee);
		mav.setViewName("Updateemployee");
		return mav;
	}
	@RequestMapping(value="/updateemp", method=RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("employee") Employee emp){
		ModelAndView mav = new ModelAndView();
		dao.updateEmployee(emp);
		mav.setViewName("redirect:viewemployee");
		return mav;
	}
	@RequestMapping(value="/deleteemp", method=RequestMethod.GET)
	public ModelAndView deleteEmployee(int id){
		Employee employee = dao.getEmployee(id);
		ModelAndView mav = new ModelAndView();
		dao.deleteEmployee(employee);
		mav.setViewName("redirect:viewemployee");
		return mav;
	}
	
	
	/*
        List<Employee> list=new ArrayList<Employee>();  
        list.add(new Employee(1,"rahul",35000f,"S.Engineer"));  
        list.add(new Employee(2,"aditya",25000f,"IT Manager"));  
        list.add(new Employee(3,"sachin",55000f,"Care Taker"));  
          
        return new ModelAndView("viewemp","list",list);  */
    }  


