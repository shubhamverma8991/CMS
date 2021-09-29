package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Student;
import com.app.service.IStudentService;
import com.app.service.IUserService;

@Controller // mandatory
@RequestMapping("/student") // optional
public class StudentController {
	// dependency : service layer i/f
	@Autowired
	private IStudentService studentService;
	@Autowired
	private IUserService userService;
	

	public StudentController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// add req handling method (to service GET) : to show login form
	@GetMapping("/login")
	// In HandlerMapping bean :
	// key : /user/login+method=GET
	// value : com.app.controller.UserController.showLoginForm
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/student/login";// Handler(UserController) --> LVN --> D.S
		// V.R : AVN : /WEB-INF/views/user/login.jsp
	}

	// add req handling method(to service POST) : to process the form
	@PostMapping("/login")
	// In HandlerMapping bean :
	// key : /user/login+method=POST
	// value : com.app.controller.UserController.processLoginForm
	// Which req params will be sent from the clnt ? email n pwd
	public String processLoginForm(@RequestParam String email, 
			@RequestParam(name = "password") String pwd, Model map,HttpSession session)
	// SC : String email=request.getParameter("email");
	// String pwd=request.getParameter("password");
	// RECO : Match req param names with method arg names!
	{
		System.out.println("in process login form " + email + " " + pwd);
		try {
			// invoke service layer method for user validation
			Student user = studentService.validateUser(email, pwd);
			// => valid login
			//add validated user details under model map , as model attribute --so that D.S will store it auto 
			//under request scope.
			session.setAttribute("user_details", user);
			// role checking
//			if (user.getRole().equals(UserRole.ADMIN))
//				return "/student/welcome";//AVN : /WEB-INF/views/admin/add_tut_form.jsp
		//	return "/customer/topics";// LVN : /customer/topics
			return "/student/welcome";
			//UserController ---> redirect view name --> D.S -->
			//response.sendRedirect(response.encodeRedirectURL("customer/topics")
			//WC --sends temp redirect resp SC 302 | Header : location : customer/topics;jsessionId=fhgsf453624
			//Clnt browser sends next req : http://host:port/day16_spring_boot_mvc/customer/topics 

		} catch (RuntimeException e) {
			System.out.println("err in student controller " + e);
			map.addAttribute("message", "Invalid Login , Please retry !!!!!!");
			return "/student/login";// Actual View Name(AVN) : /WEB-INF/views/user/login.jsp
		}

	}
	
	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		return "/student/register";
	}

	
	@PostMapping(path = "/register", consumes = "application/x-www-form-urlencoded")
    public String saveFaculty(final Student u,Model map) {
		//userDao.registerUser(u);
		studentService.saveFaculty(u);
		map.addAttribute("message", "Succesfully Registered");
        return "/student/register";
    }
	
	@GetMapping("/viewcourse")
	public String showCourse(Model map) {
		System.out.println("in show course list");
		map.addAttribute("course", studentService.listAll());
		System.out.println(studentService.listAll());
		return "/student/viewcourse";
	}
	
	@GetMapping("/viewnotice")
	public String showNotice(Model map) {
		System.out.println("in show course list");
		map.addAttribute("studentnotice", studentService.listnotice());
		System.out.println(studentService.listnotice());
		return "/student/viewnotice";
	}
	

	@GetMapping("/dac")
	// In HandlerMapping bean :
	// key : /user/login+method=GET
	// value : com.app.controller.UserController.showLoginForm
	public String showdac(Model map) {
		System.out.println("in manage student");
		map.addAttribute("dac", studentService.listDAC());
		return "/student/dac";// Handler(UserController) --> LVN --> D.S
		// V.R : AVN : /WEB-INF/views/user/login.jsp
	}
	
	@GetMapping("/dbda")
	// In HandlerMapping bean :
	// key : /user/login+method=GET
	// value : com.app.controller.UserController.showLoginForm
	public String showdbda(Model map) {
		System.out.println("in manage student");
		map.addAttribute("dbda", studentService.listDBDA());
		return "/student/dbda";// Handler(UserController) --> LVN --> D.S
		// V.R : AVN : /WEB-INF/views/user/login.jsp
	}
	@GetMapping("/dtiss")
	// In HandlerMapping bean :
	// key : /user/login+method=GET
	// value : com.app.controller.UserController.showLoginForm
	public String showdtiss(Model map) {
		System.out.println("in manage student");
		map.addAttribute("dtiss", studentService.listDTISS());
		return "/student/dtiss";// Handler(UserController) --> LVN --> D.S
		// V.R : AVN : /WEB-INF/views/user/login.jsp
	}
	
	@GetMapping("/welcome")
	// In HandlerMapping bean :
	// key : /user/login+method=GET
	// value : com.app.controller.UserController.showLoginForm
	public String showWelcomeForm() {
		System.out.println("in show login form");
		return "/student/welcome";// Handler(UserController) --> LVN --> D.S
		// V.R : AVN : /WEB-INF/views/user/login.jsp
	}
	
	

	@GetMapping("/viewschedule")
	public String showSchedule(Model map) {
		System.out.println("in show course list");
		map.addAttribute("schedule", userService.listschedule());
		System.out.println(userService.listschedule());
		return "/student/viewschedule";
	}
	//add request handling method to log out user
	@GetMapping("/logout")
	public String logOut(HttpSession session,Model map,HttpServletResponse resp,HttpServletRequest request)
	{
		System.out.println("in user logout");
		//retrieve user details from session n add it under request scope(=model attribute)
		map.addAttribute("user_dtls", session.getAttribute("user_details"));
		//How to navigate the clnt auto to the next pager after some dly ?
		//set resp header : refresh value : 10;url=home page
		resp.setHeader("refresh", "5;url="+request.getContextPath());// : /day16_spring_boot_mvc
		//invalidate session
		session.invalidate();
		return "/student/logout";//AVN : /WEB-INF/views/user/logout.jsp
	}
}
