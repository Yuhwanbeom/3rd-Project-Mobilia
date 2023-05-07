package net.mobilia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	//관리자 로그인
	@RequestMapping("/admin_login")
	public ModelAndView admin_login() {
		
		ModelAndView am=new ModelAndView();
		am.setViewName("admin/admin_login");
		return am;
	}
	
	//관리자 메인
	@RequestMapping("/admin_main")
	public ModelAndView admin_main() {
		
		ModelAndView am=new ModelAndView();
		am.setViewName("admin/admin_main");
		return am;
	}
}
