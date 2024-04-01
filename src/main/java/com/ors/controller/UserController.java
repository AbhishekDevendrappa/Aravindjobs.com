package com.ors.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.ors.model.Jobs;
import com.ors.model.PasswordReset;
import com.ors.model.Recruiter;
import com.ors.model.ResumeDetails;
import com.ors.model.User;
import com.ors.service.MailSenderService;
import com.ors.service.RecuiterService;
import com.ors.service.jobsService;
import com.ors.service.resumedetailsService;
import com.ors.service.userService;

@Controller
public class MainController {
	@Autowired
	userService userservice;
	
	@Autowired
	resumedetailsService resumedetailsservice;
	
	@Autowired
	jobsService jobsservice;
	
	@Autowired
	RecuiterService recuiterService;
	
	@Autowired
	HttpSession httpsession;
	
	@Autowired
	MailSenderService mailSenderService;

	
	@GetMapping("fill1")
	public String fillDetails(HttpSession s) {
		User id=(User) s.getAttribute("id");

		if(id==null) {
			return "errorpage";
		}
			return "UserMainpage";
	}
	
	
	
	@PostMapping("fill2")
	public String fillDetails2(@ModelAttribute ("m") ResumeDetails r,HttpSession s,Model m) {

	User id=(User) s.getAttribute("id");
    User u=userservice.getUserById(id.getSlno());
	r.setUser(u);
	String msg=resumedetailsservice.saveUser(r);
	if(msg==null)
	m.addAttribute("msg", true);

		return "user";
	}
	
	@PostMapping("savejob")
	public String savejob(Jobs jobs, HttpSession s, ModelMap m) {
		Recruiter id = (Recruiter) s.getAttribute("id");
		Recruiter r =recuiterService.getRecruiterById(id.getSlno());
		jobs.setRecruiter(r);
		jobsservice.saveJobs(jobs);
		m.put("Msg", "Job successfully posted");
		return "RecruiterMain";
	}
	
	@GetMapping("/view")
	public String viewDetails(Model model, HttpSession s) {
		User id=(User) s.getAttribute("id");

		if(id==null) {
			return "errorpage";
		}
    ResumeDetails r2=resumedetailsservice.getbyId(id.getSlno());	
    model.addAttribute("model", r2);
    List<Jobs> jobs = jobsservice.getAllJobs();
      model.addAttribute("jobs", jobs);
    return "UserViewpage";
	}
	
	@GetMapping("update")
	public ModelAndView update(@RequestParam("no") Integer slno) {
		System.out.println("slno "+slno);
	Optional<ResumeDetails> resumeDetails= resumedetailsservice.getbyIdd(slno);
	ResumeDetails details=resumeDetails.get();
	ModelAndView mv=new ModelAndView();
	mv.addObject("r",details);
	mv.setViewName("UserUpdatepage");
	return mv;
	}
	
	@PostMapping("updatepage")
	public ModelAndView main(ResumeDetails details) {
		ResumeDetails details2=resumedetailsservice.update(details);
		ModelAndView mv=new ModelAndView();
		mv.addObject("msg",details.getFirstname()+" updated successfully");
		ResumeDetails r2=resumedetailsservice.findResume((User)httpsession.getAttribute("id"));
		mv.addObject("model", r2);
		List<Jobs> job = jobsservice.getAllJob();
		mv.addObject("jobs", job);
		mv.setViewName("UserViewpage");
		return mv;
	}
	
	@GetMapping("/delete")
	public String deleteuserdetails(@RequestParam Integer no,ModelMap model) {
		System.out.println(no);
		if(no==null) {
			System.out.println("nono");
			model.put("del","there is nothing to delete");
			return "UserViewpage";
		}
		else {
			resumedetailsservice.Deleteuser(no);
			return "user";
		}
	}
	
	@GetMapping("jobs")
	public String jobs() {
		return "jobs";
	}
	
	@PostMapping("addJobDetails")
	public String addjobs(@ModelAttribute("u") Jobs u) {
		jobsservice.saveJobs(u);
		return "jobs";
	}
	

	@GetMapping("loglout")
	public String logout(HttpSession s) {
		s.invalidate();
		return "home";
	}
	
	@GetMapping("back")
	public String back() {
		return "user";
	}
	
	@GetMapping("search")
	public String search1(@RequestParam String jobtitle,Model m) {
		System.out.println("----------"+jobtitle);
		System.out.println(jobsservice.getByTitle(jobtitle));
		System.out.println("----------");
		m.addAttribute("jobs", jobsservice.getByTitle(jobtitle));
		return "Search";
	}
	
	@GetMapping("back1")
	public String back1() {
		return "user";
	}
		@GetMapping("back3")
	public String back3() {
		return "user";
	}
}