package net.mobilia.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.mobilia.service.AdminService;
import net.mobilia.vo.ProductVO;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
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
	
	@RequestMapping("/admin_product_list")
	public ModelAndView admin_product_list(ProductVO pv,HttpServletRequest request) throws Exception {
		
		int page=1;//쪽번호
		int limit=10;//한페이지에 보여지는 목록개수
		if(request.getParameter("page") != null) {
			page=Integer.parseInt(request.getParameter("page"));         
		}
		String find_name=request.getParameter("find_name");//검색어
		String find_field=request.getParameter("find_field");//검색 필드
		pv.setFind_field(find_field);
		pv.setFind_name("%"+find_name+"%");

		int listcount= adminService.getListCount(pv);

		pv.setStartrow((page-1)*10+1);//시작행번호
		pv.setEndrow(pv.getStartrow()+limit-1);//끝행번호

		List<ProductVO> plist=adminService.getProductList(pv);

		//총페이지수
		int maxpage=(int)((double)listcount/limit+0.95);
		//현재 페이지에 보여질 시작페이지 수(1,11,21)
		int startpage=(((int)((double)page/10+0.9))-1)*10+1;
		//현재 페이지에 보여줄 마지막 페이지 수(10,20,30)
		int endpage=maxpage;
		if(endpage > startpage+10-1) endpage=startpage+10-1;

		ModelAndView am=new ModelAndView();
		
		am.addObject("plist",plist);
		am.addObject("page",page);
		am.addObject("startpage",startpage);
		am.addObject("endpage",endpage);
		am.addObject("maxpage",maxpage);
		am.addObject("listcount",listcount);
		am.addObject("find_field",find_field);
		am.addObject("find_name", find_name);
		am.setViewName("admin/admin_product_list");
		return am;
	}
}
