package net.mobilia.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.mobilia.service.MemberService;
import net.mobilia.vo.MemberVO;
import net.mobilia.vo.OrderVO;

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
			OrderVO ovo = new OrderVO();
			ovo.setM_id(m_id); ovo.setOrder_state(0);
			int order_wait = memberService.getOrderCount(ovo);//주문조회
			ovo.setOrder_state(-1);
			int order_return = memberService.getOrderCount(ovo);//반품목록
			ovo.setOrder_state(1);
			int order_past = memberService.getOrderCount(ovo);//과거주문내역
			
			MemberVO mvo = memberService.getMemData(m_id);
			
			ModelAndView mv = new ModelAndView();
			mv.addObject("m_id", m_id);
			mv.addObject("order_wait", order_wait);
			mv.addObject("order_return", order_return);
			mv.addObject("order_past", order_past);
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

	
	@RequestMapping("/myshop_orderlist")
	public ModelAndView order_list(HttpSession session, OrderVO getovo) 
			throws Exception{
		
		String m_id = (String)session.getAttribute("id");
		List<OrderVO> ovo = memberService.getOrderList(getovo);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("m_id", m_id);
		mv.addObject("ovo", ovo);
		
		if(getovo.getOrder_state() == 0) {
			mv.setViewName("myshop/order_wait");
		}else if(getovo.getOrder_state() == -1) {
			
		}else if(getovo.getOrder_state() == 1) {
			
		}
		return mv;
	}
}
	

