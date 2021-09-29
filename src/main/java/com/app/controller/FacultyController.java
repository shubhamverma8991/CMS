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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.CourseTable;
import com.app.pojos.StudentNotice;
//import com.app.dao.IUserDao;
import com.app.pojos.User;
import com.app.pojos.UserRole;
import com.app.service.IStudentService;
import com.app.service.IUserService;

@Controller // mandatory
@RequestMapping("/faculty") // optional
public class FacultyController {
	// dependency : service layer i/f
	@Autowired
	private IUserService userService;
	// private IUserDao userDao;
	@Autowired
	private IStudentService studentService;

	public FacultyController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// add req handling method (to service GET) : to show login form
	@GetMapping("/login")
	// In HandlerMapping bean :
	// key : /user/login+method=GET
	// value : com.app.controller.UserController.showLoginForm
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/faculty/login";// Handler(UserController) --> LVN --> D.S
		// V.R : AVN : /WEB-INF/views/user/login.jsp
	}

	// add req handling method(to service POST) : to process the form
	@PostMapping("/login")
	// In HandlerMapping bean :
	// key : /user/login+method=POST
	// value : com.app.controller.UserController.processLoginForm
	// Which req params will be sent from the clnt ? email n pwd
	public String processLoginForm(@RequestParam String email, @RequestParam(name = "password") String pwd, Model map,
			HttpSession session)
	// SC : String email=request.getParameter("email");
	// String pwd=request.getParameter("password");
	// RECO : Match req param names with method arg names!
	{
		System.out.println("in process login form " + email + " " + pwd);
		try {
			// invoke service layer method for user validation
			User user = userService.validateUser(email, pwd);
			// => valid login
			// add validated user details under model map , as model attribute --so that D.S
			// will store it auto
			// under request scope.
			session.setAttribute("user_details", user);
			// role checking
			if (user.getRole().equals(UserRole.FACULTY))
				return "/faculty/welcome";// AVN : /WEB-INF/views/admin/add_tut_form.jsp
			// return "/customer/topics";// LVN : /customer/topics
			return "redirect:/customer/topics";
			// UserController ---> redirect view name --> D.S -->
			// response.sendRedirect(response.encodeRedirectURL("customer/topics")
			// WC --sends temp redirect resp SC 302 | Header : location :
			// customer/topics;jsessionId=fhgsf453624
			// Clnt browser sends next req :
			// http://host:port/day16_spring_boot_mvc/customer/topics

		} catch (RuntimeException e) {
			System.out.println("err in faculty controller " + e);
			map.addAttribute("message", "Invalid Login , Please retry !!!!!!");
			return "/faculty/login";// Actual View Name(AVN) : /WEB-INF/views/user/login.jsp
		}

	}

	@GetMapping("/register")
	public String showRegisterForm(Model model) {
		return "/faculty/register";
	}

	@PostMapping(path = "/register", consumes = "application/x-www-form-urlencoded")
	public String saveFaculty(final User u,Model map) {
		// userDao.registerUser(u);
		userService.saveFaculty(u);
		map.addAttribute("message", "Succesfully Registered");
		return "/faculty/register";
	}

	@GetMapping("/managestudent")
	// In HandlerMapping bean :
	// key : /user/login+method=GET
	// value : com.app.controller.UserController.showLoginForm
	public String managestudent(Model map) {
		System.out.println("in manage student");
		map.addAttribute("student", userService.listStudent());
		return "/admin/managestudent";// Handler(UserController) --> LVN --> D.S
		// V.R : AVN : /WEB-INF/views/user/login.jsp
	}

	// add req handling method to show update form
	@GetMapping("/updatestudent")
	public String showStudentUpdateForm(@RequestParam int id, Model map) {
		System.out.println("in show update form " + id + " " + map);
		// invoke service layer method , get detached POJO from service layer n bind it
		// to form data
		map.addAttribute("student", studentService.getStudentDetails(id));
		return "/admin/updatestudent";
	}

	@GetMapping("/managecourse")
	// In HandlerMapping bean :
	// key : /user/login+method=GET
	// value : com.app.controller.UserController.showLoginForm
	public String managecourse(Model map) {
		System.out.println("in manage student");
		map.addAttribute("course", studentService.listAll());
		return "/faculty/managecourse";// Handler(UserController) --> LVN --> D.S
		// V.R : AVN : /WEB-INF/views/user/login.jsp
	}

	// add req handling method to show update form
	@GetMapping("/updatecourse")
	public String showCourseUpdateForm(@RequestParam int vid, Model map) {
		System.out.println("in show update form " + vid + " " + map);
		// invoke service layer method , get detached POJO from service layer n bind it
		// to form data
		map.addAttribute("course", studentService.getCourseDetails(vid));
		return "/faculty/updatecourse";
	}

	// add req handling method for processing update form
	@PostMapping("/updatecourse")
	public String processCourseUpdateForm(CourseTable user, RedirectAttributes flashMap) {
		System.out.println("process update form " + user);// vendor : DETACHED POJO containing updated state
		flashMap.addFlashAttribute("message", studentService.updateCourseDetails(user));
		return "redirect:/faculty/managecourse";
	}

	// add req handling method to delete vendor details
	@GetMapping("/deletecourse")
	public String deleteCourseDetails(@RequestParam int vid, RedirectAttributes flashMap) {
		System.out.println("in del vendor dtls " + vid + " " + flashMap);
		// invoke service layer method , get the result(mesg) n add it under flash scope
		flashMap.addFlashAttribute("message", studentService.deleteCourseDetails(vid));
		return "redirect:/faculty/managecourse";

	}
	
	@GetMapping("/courseadd")
	public String showCourseForm(Model model) {
		return "/faculty/courseadd";
	}

	@PostMapping(path = "/courseadd", consumes = "application/x-www-form-urlencoded")
	public String saveFaculty(final CourseTable u) {
		// userDao.registerUser(u);
		userService.saveCourse(u);
		return "/faculty/courseadd";
	}

	@GetMapping("/welcome")
	// In HandlerMapping bean :
	// key : /user/login+method=GET
	// value : com.app.controller.UserController.showLoginForm
	public String showWelcomeForm() {
		System.out.println("in show login form");
		return "/faculty/welcome";// Handler(UserController) --> LVN --> D.S
		// V.R : AVN : /WEB-INF/views/user/login.jsp
	}
	
	@GetMapping("/addnoticestudent")
	public String showStudentNoticeForm(Model model) {
		return "/faculty/addnoticestudent";
	}

	@PostMapping(path = "/addnoticestudent", consumes = "application/x-www-form-urlencoded")
	public String saveStudentNotice(final StudentNotice u) {
		// userDao.registerUser(u);
		userService.saveNoticestudent(u);
		return "/faculty/addnoticestudent";
	}
	
	@GetMapping("/viewnotice")
	public String showNotice(Model map) {
		System.out.println("in show course list");
		map.addAttribute("facultynotice", userService.listnotice());
		System.out.println(userService.listnotice());
		return "/faculty/viewnotice";
	}
	
	@GetMapping("/viewschedule")
	public String showSchedule(Model map) {
		System.out.println("in show course list");
		map.addAttribute("schedule", userService.listschedule());
		System.out.println(userService.listschedule());
		return "/faculty/viewschedule";
	}
	
	// add request handling method to log out user
	@GetMapping("/logout")
	public String logOut(HttpSession session, Model map, HttpServletResponse resp, HttpServletRequest request) {
		System.out.println("in user logout");
		// retrieve user details from session n add it under request scope(=model
		// attribute)
		map.addAttribute("user_dtls", session.getAttribute("user_details"));
		// How to navigate the clnt auto to the next pager after some dly ?
		// set resp header : refresh value : 10;url=home page
		resp.setHeader("refresh", "5;url=" + request.getContextPath());// : /day16_spring_boot_mvc
		// invalidate session
		session.invalidate();
		return "/faculty/logout";// AVN : /WEB-INF/views/user/logout.jsp
	}
}
