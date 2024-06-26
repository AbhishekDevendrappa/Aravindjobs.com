package com.ors.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ors.model.Jobapllications;
import com.ors.model.Jobs;
import com.ors.model.OfferlettterDetails;
import com.ors.model.Recruiter;
import com.ors.model.ResumeDetails;
import com.ors.model.User;
import com.ors.service.JobapllicationsService;
import com.ors.service.OfferletterDetailsService;
import com.ors.service.RecuiterService;
import com.ors.service.jobsService;
import com.ors.service.resumedetailsService;
import com.ors.service.userService;

@Controller
public class RecruiterController {
	
	@Autowired
	JobapllicationsService jobapllicationsService;
	
	@Autowired
	resumedetailsService resumedetailsservice;
	
	@Autowired
	jobsService jobsservice;
	
	@Autowired
	RecuiterService recuiterService;
	
	@Autowired
	userService userService;
	
	@Autowired
	OfferletterDetailsService offerletterDetailsService;

	@GetMapping("/viewJobApplications")
	public ModelAndView job_applications(HttpSession s) {
	    
	    Recruiter r = (Recruiter) s.getAttribute("id");
	    List<Jobapllications> j = jobapllicationsService.getjobapplied(r);
	    
	    ModelAndView mav = new ModelAndView("RecruiterMain");
	    mav.addObject("aplliedjobs", j);
	    return mav;
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
	
	@GetMapping("showresume")
	public String View_Resume(@RequestParam Integer no, Model model) {
		ResumeDetails resume=resumedetailsservice.getbyId(no);
		model.addAttribute("resume", resume);
		return "RecruiterViewResume";
	}
	
	@GetMapping("reject")
	public String Deleteapplication(@RequestParam Integer no, HttpSession s, Model m) {
		jobapllicationsService.deletebyid(no);
		
		Recruiter r = (Recruiter) s.getAttribute("id");
		List<Jobapllications> j = jobapllicationsService.getjobapplied(r);
	    m.addAttribute("aplliedjobs", j);
		return "RecruiterMain";
	}
	
	@GetMapping("offerletter")
	public String Releaseoffer(@RequestParam Integer no, ModelMap m, HttpSession s) {
		User u = userService.getUserById(no);
		OfferlettterDetails o = new OfferlettterDetails();
		OfferlettterDetails find = (OfferlettterDetails) offerletterDetailsService.getByslno(no);
		
		if(find != null) {
			find.setOfferletterofffered(find.getOfferletterofffered()+1);
			offerletterDetailsService.save(find);
		}else {
			o.setUser(u);
			o.setOfferletterofffered(1);
			offerletterDetailsService.save(o);
		}
		
		m.put("offer", "Offer Letter Successfully Released to "+u.getUsername());
		Recruiter r = (Recruiter) s.getAttribute("id");
		List<Jobapllications> j = jobapllicationsService.getjobapplied(r);
	    m.addAttribute("aplliedjobs", j);
		return "RecruiterMain";
	}

	@GetMapping("interview")
	public String Interview(@RequestParam String no, ModelMap m, HttpSession s) {
		m.put("offer", "Interview Successfully Scheduled with "+no);
		Recruiter r = (Recruiter) s.getAttribute("id");
		List<Jobapllications> j = jobapllicationsService.getjobapplied(r);
	    m.addAttribute("aplliedjobs", j);
		return "RecruiterMain";
	}

	
	@GetMapping("rback")
	public String rback(HttpSession s, Model model) {
		Recruiter r = (Recruiter) s.getAttribute("id");
		List<Jobapllications> j = jobapllicationsService.getjobapplied(r);
	    model.addAttribute("aplliedjobs", j);
		return "RecruiterMain";
	}
}
