package net.mobilia.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.mobilia.service.MemberService;
import net.mobilia.vo.CartVO;
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
			out.println("alert('로그인 후 이용할 수 있습니다!');");
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
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		
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
	
	@RequestMapping(value="/order_check")
	@ResponseBody
	ResponseEntity<String> order_check(HttpServletRequest request, @RequestBody OrderVO ovo){
		ResponseEntity<String> entity = null;
		
		try {
			
			if(ovo.getOrder_check().equals("구매확정")) {
				memberService.orderConfirm(ovo.getOrder_no());
				entity = new ResponseEntity<String>("CONFIRM_OK", HttpStatus.OK);
			}else if(ovo.getOrder_check().equals("반품요청")) {
				
				List<CartVO> getcvo = memberService.getReturnList(ovo.getOrder_no());//반품할 상품목록을 가져온다
				for(CartVO cvo : getcvo) {
					
					memberService.pCountReturn(cvo);//가져온 상품목록의 재고개수를 다시 돌려놓음
				}
				
				memberService.orderReturn(ovo.getOrder_no());//반품처리로 업데이트
				entity = new ResponseEntity<String>("RETURN_OK", HttpStatus.OK);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(
			e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
	

