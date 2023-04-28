package net.mobilia.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.mobilia.service.MemberService;
import net.mobilia.vo.MemberVO;


@Controller
public class MemberController {


	@Autowired
	private MemberService memberService;
	
	@RequestMapping("/member_join")
	public ModelAndView member_join(HttpServletRequest request) throws Exception {
		
		String[] phone= {"010","011","016"};
		String[] email= {"naver.com","daum.net","gmail.com","nate.com","직접 입력"};
		
		request.setAttribute("phone", phone);
		request.setAttribute("email", email);
		
		return new ModelAndView("member/join");
	}
	
	@RequestMapping("/member_join_ok")
	public ModelAndView member_join_ok(MemberVO m,HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		
		
		String m_id=request.getParameter("m_id");
		String m_pwd=request.getParameter("m_pwd");
		String m_name=request.getParameter("m_name");
		String m_post=request.getParameter("m_post");
		String m_roadAddr=request.getParameter("m_roadAddr");
		String m_jibunAddr=request.getParameter("m_jibunAddr");
		String m_detailAddr=request.getParameter("m_detailAddr");
		String m_phone01=request.getParameter("m_phone01");
		String m_phone02=request.getParameter("m_phone02");
		String m_phone03=request.getParameter("m_phone03");
		String m_birth01=request.getParameter("m_birth01");
		String m_birth02=request.getParameter("m_birth02");
		String m_birth03=request.getParameter("m_birth03");
		String mail_id=request.getParameter("mail_id");
		String mail_domain=request.getParameter("mail_domain");
		
		
		
		m.setM_id(m_id); m.setM_pwd(m_pwd); m.setM_name(m_name);
		m.setM_post(m_post); m.setM_roadAddr(m_roadAddr); m.setM_jibunAddr(m_jibunAddr); m.setM_detailAddr(m_detailAddr);
		m.setM_phone01(m_phone01); m.setM_phone02(m_phone02); m.setM_phone03(m_phone03);
		m.setM_birth01(m_birth01); m.setM_birth02(m_birth02); m.setM_birth03(m_birth03);
		m.setMail_id(mail_id); m.setMail_domain(mail_domain);
		
		this.memberService.insertMember(m);
		
		
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping("/member_login")
	public ModelAndView member_login(){
		return new ModelAndView("member/login");
	}
	
	@RequestMapping("/member_login_ok")
	public String member_login_ok( HttpServletResponse response,
			HttpServletRequest request, HttpSession session,
			@RequestParam("m_id") String m_id,
			@RequestParam("m_pwd") String m_pwd
			) throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		MemberVO m = this.memberService.loginCheck(m_id);
		
		if(m == null) {
			out.println("<script>");
			out.println("alert('가입 안된 회원입니다!');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			if(!m.getM_pwd().equals(m_pwd)) {
				out.println("<script>");
				out.println("alert('비번이 다릅니다!');");
				out.println("history.go(-1);");
				out.println("</script>");
			}else {
				
				session.setAttribute("id", m_id);
				
				return "redirect:/mobilia";
			}
		}
		return null;
	}
	
	@RequestMapping("/member_logout")
	public String member_logout(HttpServletResponse response, HttpSession session) 
			throws Exception{
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		session.invalidate();//세션 만료 => 로그아웃
		
		out.println("<script>");
		out.println("alert('로그아웃 되었습니다!');");
		out.println("location='/mobilia';");
		out.println("</script>");
		
		return null;
	}

	@RequestMapping("/modify")
	public ModelAndView modify(HttpSession session, HttpServletResponse response) 
			throws Exception {
		
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    String m_id = (String)session.getAttribute("id");
	    
	    if(m_id == null) {
	    	out.println("<script>");
	    	out.println("alert('다시 로그인 하세요!');");
	    	out.println("location='member_login';");
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
