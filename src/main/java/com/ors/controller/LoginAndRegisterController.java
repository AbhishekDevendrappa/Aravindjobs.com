package com.ors.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ors.model.Jobapllications;
import com.ors.model.OfferlettterDetails;
import com.ors.model.PasswordReset;
import com.ors.model.Recruiter;
import com.ors.model.User;
import com.ors.service.JobapllicationsService;
import com.ors.service.OfferletterDetailsService;
import com.ors.service.RecuiterService;
import com.ors.service.userService; 

@Controller
public class LoginAndRegisterController {
	
	@Autowired
	userService userservice;
	
	@Autowired
	HttpSession httpsession;
	
	
	@Autowired
	RecuiterService recuiterService;
	
	@Autowired
	JobapllicationsService jobapllicationsService;
	
	@Autowired
	OfferletterDetailsService offerletterDetailsService;
	
	@GetMapping
	public String home()
	{
		return "home";
	}
	
	@GetMapping("register")
	public String showregister()
	{
		return "UserRegister";
	}
	
	@GetMapping("alogin")
	public String show_admin_login()
	{
		return "AdminLogin";
	}
	
	@GetMapping("ulogin")
	public String show_user_login()
	{
		return "Userlogin";
	}
	
	@GetMapping("rlogin")
	public String show_recuiter_login() {
		return "RecruiterLogin";
	}
	
	@GetMapping("forpass")
	public String Forgotpassword() {
		return "Fpassword";
	}
	
	@GetMapping("gohome")
	public String  gohome() {
		return "home";
	}
	
	@GetMapping("afterregister")
	public String afterregister() {
		return "Userlogin";
	}
	
	@GetMapping("requietrregister")
	public String recuiterregister() {
		return "RecruiterRegister";
	}
	
	@PostMapping("adminlogin")
	public String Admin_Login(ModelMap model, @RequestParam String Adminname, @RequestParam String Password) {
		if(Adminname.equals("admin") && Password.equals("123"))
		{		
		List<OfferlettterDetails> offers =	offerletterDetailsService.getall();
		System.out.println(offers);
		model.addAttribute("offers", offers);
				return "Adminmain";
		}else{
			model.put("errorMsg", "Invalid username or password");
			return "AdminLogin";
		}
	}
	
	@PostMapping("add")
	public String register_user(@ModelAttribute("u") User u,ModelMap model) {
		userservice.saveUser(u);
			model.put("registerMsg", "User registered successfully");
		return "Afterregister";
	}
	
	@PostMapping("addreciuter")
	public String register_recuiter(@ModelAttribute("r") Recruiter r,ModelMap model) {
		recuiterService.saveRecuiter(r);
			model.put("registerMsg", "User registered successfully");
		return "RecruiterLogin";
	}
	
	@PostMapping("/login")
	public String Mainpage(ModelMap model, @RequestParam String email, @RequestParam String Password,HttpSession s) {
		User user = userservice.getUser(email, Password);
		
		if(user==null) {	
			model.put("errorMsg", "Invalid username or password");
			return "Userlogin";
			
		}else{
			String a = user.getUsername();
			model.put("um", a);
			s.setAttribute("id", user);
				return "user";
		}
	}
	
	@PostMapping("/recuiterlogin")
	public String Recuiter_Mainpage(ModelMap model, @RequestParam String email, @RequestParam String password,HttpSession s) {
		System.out.println(email+" "+password);
		Recruiter r = recuiterService.getrecuiter(email, password);
		if(r!=null) {		
			String a = r.getName();
			model.put("um", a);
			s.setAttribute("id", r);
		    List<Jobapllications> j = jobapllicationsService.getjobapplied(r);
		    model.addAttribute("aplliedjobs", j);
		        
				return "RecruiterMain";
		}else{
			model.put("errorMsg", "Invalid username or password");
			return "RecruiterLogin";
		}
	}
	
	@PostMapping("change")
	public ModelAndView changePass(PasswordReset password) {
	System.out.println("change"+password.getUsername());
	User details=userservice.findByname(password.getUsername());
	ModelAndView  mv=new ModelAndView();
	if(details!=null) {
	details.setPassword(password.getNewpassword());
	userservice.saveUser(details);
	mv.addObject("msg","Password Updated Successfully");
	mv.setViewName("home");
	return mv;
	}
	else {
	mv.addObject("msg","User Not Found");
	mv.setViewName("Fpassword");
	return mv;
	}
	}
	


}
