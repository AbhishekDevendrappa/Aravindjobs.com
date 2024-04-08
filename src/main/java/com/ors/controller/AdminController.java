package com.ors.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ors.model.Block;
import com.ors.model.OfferlettterDetails;
import com.ors.service.BlockService;
import com.ors.service.OfferletterDetailsService;
import com.ors.service.userService;

@Controller
public class AdminController {

	@Autowired
	BlockService blockService;
	
	@Autowired
	userService userService;
	
	@Autowired
	OfferletterDetailsService offerletterDetailsService;

	@GetMapping("block")
	public String Block_User(@RequestParam Integer no, Model model) {

		System.out.println(no);
		Optional<Block> block = blockService.getbyId(no);
		System.out.println(block.isEmpty()+" is emplty");
		if (block.isEmpty()) {
			Block b = new Block();
			b.setUser(userService.getUserById(no));
			blockService.save(b);
			model.addAttribute("message",b.getUser().getUsername()+" Blocked from apllying job");
			List<OfferlettterDetails> offers =	offerletterDetailsService.getall();
			model.addAttribute("offers", offers);
		}else {
			model.addAttribute("message", "User already Blocked from apllying job");
			List<OfferlettterDetails> offers =	offerletterDetailsService.getall();
			model.addAttribute("offers", offers);
		}
		return "Adminmain";
	}
	
	@GetMapping("Aloglout")
	public String logout(HttpSession s) {
		s.invalidate();
		return "home";
	}
}
