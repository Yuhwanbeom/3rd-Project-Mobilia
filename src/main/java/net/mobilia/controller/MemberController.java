package net.mobilia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.mobilia.service.MemberServiceDAO;

@Controller
public class MemberController {

	@Autowired
	private MemberServiceDAO memberService;
	
	@RequestMapping("/member_join")
	public ModelAndView member_join() {
		
		return new ModelAndView("member/join");
	}

}
