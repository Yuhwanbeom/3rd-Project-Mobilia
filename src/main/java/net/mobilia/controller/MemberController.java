package net.mobilia.controller;


import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("/member_login")
	public ModelAndView member_login(){
		return new ModelAndView("member/login");
	}
	
	@RequestMapping("/member_login_ok")
	public ModelAndView login_ok( HttpServletResponse response,
			HttpSession session,
			@RequestParam("m_id") String m_id,
			@RequestParam("m_pwd") String m_pwd
			) {
		
		return null;
	}

	@RequestMapping("/modify")
	public ModelAndView modify(HttpSession session, HttpServletResponse response) 
			throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    String m_id = (String)session.getAttribute("m_id");
	    
	    if(m_id == null) {
	    	out.println("<script>");
	    	out.println("alert('다시 로그인 하세요!');");
	    	out.println("location='login.net';");
	    	out.println("</script>");
	    }else {
	    	
	    	String[] phone = {"010", "011", "016", "017", "018", "019"};
			String[] email = {"naver.com", "daum.net", "gmail.com", "nate.com", "직접 입력"};
			
			ModelAndView mv = new ModelAndView();
			
			mv.addObject("phone", phone);
			mv.addObject("email", email);
			
			mv.setViewName("member/modify");
			
			return mv;
	    }
	    
	    return null;
	}
}
