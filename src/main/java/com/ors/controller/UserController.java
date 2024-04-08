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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ors.model.Block;
import com.ors.model.Jobapllications;
import com.ors.model.Jobs;
import com.ors.model.Recruiter;
import com.ors.model.ResumeDetails;
import com.ors.model.User;
import com.ors.service.BlockService;
import com.ors.service.JobapllicationsService;
import com.ors.service.jobsService;
import com.ors.service.resumedetailsService;
import com.ors.service.userService;

@Controller
public class UserController {
	@Autowired
	userService userservice;
	
	@Autowired
	resumedetailsService resumedetailsservice;
	
	@Autowired
	jobsService jobsservice;

	@Autowired
	JobapllicationsService jobapllicationsService;
	
	@Autowired
	HttpSession httpsession;
	
	@Autowired
	BlockService blockService;


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
	
	@GetMapping("search")
	public String search1(@RequestParam String jobtitle,Model m) {
		m.addAttribute("jobs", jobsservice.getByTitle(jobtitle));
		return "Search";
	}
	
	@GetMapping("apply")
	public String apply_for_job(@RequestParam Integer no, HttpSession s, ModelMap m) {
		Optional<Jobs> j =  jobsservice.getjobsby(no);
		Jobs job = j.get();
		User user=(User) s.getAttribute("id");
	    Optional<Block> b =	blockService.getbyId(user.getSlno());
	    System.out.println(b);
	    if(b.isEmpty()) {
	    	Recruiter recruiter = job.getRecruiter();
		    Jobapllications J = new Jobapllications();
		    J.setUser(user);
		    J.setJobs(job);
		    J.setRecruiter(recruiter);
		    jobapllicationsService.saveJobs(J);
		    m.addAttribute("jobs", jobsservice.getByTitle(job.getJobtitle()));
			m.put("msg", "Apllied successfully");
	    }else {
	    	m.put("msg", "You have already offered more than 3 offers so you have been blocked from apllying the job");
	    }
		
		return "Search";
	}
	

	@GetMapping("loglout")
	public String logout(HttpSession s) {
		s.invalidate();
		return "home";
	}
	
	@GetMapping("back")
	public String uback() {
		return "user";
	}
	
	
	
	
}