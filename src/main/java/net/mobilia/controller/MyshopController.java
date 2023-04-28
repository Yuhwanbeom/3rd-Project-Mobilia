package net.mobilia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyshopController {

	@RequestMapping("/myshop_main")
	public ModelAndView myshop() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("myshop/myshop");
		
		return mv;
	}
	
}
