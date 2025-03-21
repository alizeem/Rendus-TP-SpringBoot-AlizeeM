package com.example.unc.miage;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import org.springframework.stereotype.Controller;

@Controller
public class InviteController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
    }
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute Invite invite) {
		ModelAndView modelAndView = new ModelAndView();
		// Initialiser la date de création
		invite.setDate(new Date());
		modelAndView.setViewName("invite-data");
		modelAndView.addObject("invite", invite);
		return modelAndView;
	}
    
}


