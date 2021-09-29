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
import com.app.pojos.FacultyNotice;
import com.app.pojos.Schedule;
import com.app.pojos.Student;
import com.app.pojos.StudentNotice;
import com.app.pojos.User;
import com.app.pojos.UserRole;
import com.app.service.IStudentService;
import com.app.service.IUserService;

@Controller // mandatory
@RequestMapping("/admin") // optional
public class AdminController {
	// dependency : service layer i/f
	@Autowired
	private IUserService userService;
	@Autowired
	private IStudentService studentService;

	public AdminController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// add req handling method (to service GET) : to show login form
	@GetMapping("/login")
	// In HandlerMapping bean :
	// key : /user/login+method=GET
	// value : com.app.controller.UserController.showLoginForm
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/admin/login";// Handler(UserController) --> LVN --> D.S
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
			if (user.getRole().equals(UserRole.ADMIN))
				return "/admin/welcome";// AVN : /WEB-INF/views/admin/add_tut_form.jsp
			return "/admin/login";// LVN : /customer/topics
			// return "redirect:/customer/topics";
			// UserController ---> redirect view name --> D.S -->
			// response.sendRedirect(response.encodeRedirectURL("customer/topics")
			// WC --sends temp redirect resp SC 302 | Header : location :
			// customer/topics;jsessionId=fhgsf453624
			// Clnt browser sends next req :
			// http://host:port/day16_spring_boot_mvc/customer/topics

		} catch (RuntimeException e) {
			System.out.println("err in admin controller " + e);
			map.addAttribute("message", "Invalid Login , Please retry !!!!!!");
			return "/admin/login";// Actual View Name(AVN) : /WEB-INF/views/user/login.jsp
		}

	}

	@GetMapping("/managefaculty")
	// In HandlerMapping bean :
	// key : /user/login+method=GET
	// value : com.app.controller.UserController.showLoginForm
	public String managefaculty(Model map) {
		System.out.println("in manage faculty");
		map.addAttribute("faculty", userService.listFaculty());
		return "/admin/managefaculty";// Handler(UserController) --> LVN --> D.S
		// V.R : AVN : /WEB-INF/views/user/login.jsp
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

	@GetMapping("/managecourse")
	// In HandlerMapping bean :
	// key : /user/login+method=GET
	// value : com.app.controller.UserController.showLoginForm
	public String managecourse(Model map) {
		System.out.println("in manage student");
		map.addAttribute("course", studentService.listAll());
		return "/admin/managecourse";// Handler(UserController) --> LVN --> D.S
		// V.R : AVN : /WEB-INF/views/user/login.jsp
	}

	// add req handling method to show update form
	@GetMapping("/updatecourse")
	public String showCourseUpdateForm(@RequestParam int vid, Model map) {
		System.out.println("in show update form " + vid + " " + map);
		// invoke service layer method , get detached POJO from service layer n bind it
		// to form data
		map.addAttribute("course", studentService.getCourseDetails(vid));
		return "/admin/updatecourse";
	}

	// add req handling method for processing update form
	@PostMapping("/updatecourse")
	public String processCourseUpdateForm(CourseTable user, RedirectAttributes flashMap) {
		System.out.println("process update form " + user);// vendor : DETACHED POJO containing updated state
		flashMap.addFlashAttribute("message", studentService.updateCourseDetails(user));
		return "redirect:/admin/managecourse";
	}

	// add req handling method to delete vendor details
	@GetMapping("/deletecourse")
	public String deleteCourseDetails(@RequestParam int vid, RedirectAttributes flashMap) {
		System.out.println("in del vendor dtls " + vid + " " + flashMap);
		// invoke service layer method , get the result(mesg) n add it under flash scope
		flashMap.addFlashAttribute("message", studentService.deleteCourseDetails(vid));
		return "redirect:/admin/managecourse";

	}

	// add req handling method to show update form
	@GetMapping("/updatefaculty")
	public String showFacultyUpdateForm(@RequestParam int vid, Model map) {
		System.out.println("in show update form " + vid + " " + map);
		// invoke service layer method , get detached POJO from service layer n bind it
		// to form data
		map.addAttribute("user", userService.getFacultyDetails(vid));
		return "/admin/updatefaculty";
	}

	// add req handling method for processing update form
	@PostMapping("/updatefaculty")
	public String processFacultyUpdateForm(User user, RedirectAttributes flashMap) {
		System.out.println("process update form " + user);// vendor : DETACHED POJO containing updated state
		flashMap.addFlashAttribute("message", userService.updateFacultyDetails(user));
		return "redirect:/admin/managefaculty";
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

	// add req handling method for processing update form
	@PostMapping("/updatestudent")
	public String processStudentUpdateForm(Student student, RedirectAttributes flashMap) {
		System.out.println("process update form " + student);// vendor : DETACHED POJO containing updated state
		flashMap.addFlashAttribute("message", studentService.updateStudentDetails(student));
		return "redirect:/admin/managestudent";
	}

	// add req handling method to delete vendor details
	@GetMapping("/deletefaculty")
	public String deleteFacultyDetails(@RequestParam int vid, RedirectAttributes flashMap) {
		System.out.println("in del vendor dtls " + vid + " " + flashMap);
		// invoke service layer method , get the result(mesg) n add it under flash scope
		flashMap.addFlashAttribute("message", userService.deleteFacultyDetails(vid));
		return "redirect:/admin/managefaculty";

	}

	// add req handling method to delete vendor details
	@GetMapping("/deletestudent")
	public String deleteStudentDetails(@RequestParam int vid, RedirectAttributes flashMap) {
		System.out.println("in del vendor dtls " + vid + " " + flashMap);
		// invoke service layer method , get the result(mesg) n add it under flash scope
		flashMap.addFlashAttribute("message", studentService.deleteStudentDetails(vid));
		return "redirect:/admin/managestudent";

	}

	@GetMapping("/courseadd")
	public String showRegisterForm(Model model) {
		return "/admin/courseadd";
	}

	@PostMapping(path = "/courseadd", consumes = "application/x-www-form-urlencoded")
	public String saveFaculty(final CourseTable u) {
		// userDao.registerUser(u);
		userService.saveCourse(u);
		return "/admin/courseadd";
	}
	
	// add req handling method (to service GET) : to show login form
		@GetMapping("/welcome")
		// In HandlerMapping bean :
		// key : /user/login+method=GET
		// value : com.app.controller.UserController.showLoginForm
		public String showWelcomeForm() {
			System.out.println("in show login form");
			return "/admin/welcome";// Handler(UserController) --> LVN --> D.S
			// V.R : AVN : /WEB-INF/views/user/login.jsp
		}

		@GetMapping("/addnotice")
		public String showNoticeForm(Model model) {
			return "/admin/addnotice";
		}

		@PostMapping(path = "/addnotice", consumes = "application/x-www-form-urlencoded")
		public String saveNotice(final FacultyNotice u) {
			// userDao.registerUser(u);
			userService.saveNotice(u);
			return "/admin/addnotice";
		}
		
		@GetMapping("/addnoticestudent")
		public String showStudentNoticeForm(Model model) {
			return "/admin/addnoticestudent";
		}

		@PostMapping(path = "/addnoticestudent", consumes = "application/x-www-form-urlencoded")
		public String saveStudentNotice(final StudentNotice u) {
			// userDao.registerUser(u);
			userService.saveNoticestudent(u);
			return "/admin/addnoticestudent";
		}
		
		@GetMapping("/addschedule")
		public String showScheduleForm(Model model) {
			return "/admin/addschedule";
		}

		@PostMapping(path = "/addschedule", consumes = "application/x-www-form-urlencoded")
		public String saveFaculty(final Schedule u) {
			// userDao.registerUser(u);
			userService.saveSchedule(u);
			return "/admin/addschedule";
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
		return "/admin/logout";// AVN : /WEB-INF/views/user/logout.jsp
	}
}
