package net.mobilia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	@RequestMapping("/mobilia")
	public ModelAndView mobilia(){
		
		
		return new ModelAndView("index");
	}
}
