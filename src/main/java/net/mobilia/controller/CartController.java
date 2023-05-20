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

import net.mobilia.service.CartService;
import net.mobilia.vo.CartVO;

@Controller
public class CartController {

	@Autowired CartService cartService;

	@RequestMapping("/cart_main")
	public ModelAndView cart_list(HttpSession session, HttpServletResponse response,
			HttpServletRequest request) throws Exception{

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String m_id = (String)session.getAttribute("id");

		if(m_id == null) {
			out.println("<script>");
			out.println("alert('장바구니는 로그인후 확인이 가능합니다');");
			out.println("location='member_login';");
			out.println("</script>");

			return null;
		}else {
			List<CartVO> cvo = cartService.getCartList(m_id);

			ModelAndView mv = new ModelAndView();
			mv.addObject("cvo", cvo);
			mv.setViewName("cart/cart_list");
			return mv;
		}
	}

	@RequestMapping(value="/cart/add")
	@ResponseBody
	ResponseEntity<String> addCart(@RequestBody CartVO cvo){
		ResponseEntity<String> entity = null;

		try {
			int data = cartService.getCartData(cvo);//상품이 등록되어있는지 확인한다.

			if(data == 1) {//만약 이미 상품이 등록되어있다면
				cartService.updateCount(cvo);//수량을 수정한다.
				entity = new ResponseEntity<String>("UPDATE", HttpStatus.OK);
			}else {//상품이 등록되어있지 않다면
				cartService.addCart(cvo);//장바구니에 상품을 추가
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
			}
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(
					e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	@RequestMapping(value="/cart/count_modify")
	@ResponseBody
	ResponseEntity<String> count_modify(@RequestBody CartVO cvo){
		ResponseEntity<String> entity = null;

		try {
				cartService.countModifyCart(cvo);//장바구니에 상품을 추가
				entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(
					e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/cart/delete")
	@ResponseBody
	ResponseEntity<String> deleteCart(@RequestBody CartVO cvo){
		ResponseEntity<String> entity = null;
		try {
			cartService.delCartData(cvo);//상품이 등록되어있는지 확인한다.
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(
			e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
