package net.mobilia.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.mobilia.service.MemberService;
import net.mobilia.vo.MemberVO;

@Controller
public class MyshopController {

	@Autowired
	private MemberService memberService;

	@RequestMapping("/myshop_main")
	public ModelAndView myshop(HttpSession session, HttpServletResponse response) 
			throws Exception{

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String m_id = (String)session.getAttribute("id");

		if(m_id == null) {
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!');");
			out.println("location='member_login';");
			out.println("</script>");
		}else {
			MemberVO mvo = memberService.getMemData(m_id);
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("mvo", mvo);
			mv.setViewName("myshop/myshop");
			return mv;
		}
		return null;
	}

	
	@RequestMapping("/myshop_heart")
	public ModelAndView myshop_heart(HttpSession session, HttpServletResponse response) 
			throws Exception{
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("myshop/heart");
		return mv;
	}
}
	

