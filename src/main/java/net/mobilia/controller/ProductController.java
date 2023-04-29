package net.mobilia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.mobilia.service.ProductService;
import net.mobilia.vo.ProductVO;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/mobilia")
	public ModelAndView mobilia(ProductVO pv){
		
		ModelAndView plist=new ModelAndView();
		
		List<ProductVO> nlist=productService.getNewItem(pv);
		List<ProductVO> mlist=productService.getMdChoice(pv);
		
		plist.addObject("nlist", nlist);
		plist.addObject("mlist", mlist);
		plist.setViewName("./index");
		return plist;
		
		
	}
	@RequestMapping("/product")
	public ModelAndView mobilia_bed(ProductVO pv,String c,String state,String m) {
		
		ModelAndView bm=new ModelAndView();
		
		if(state.equals("all")) { //전체 상품
			int listCount=productService.getListCount(pv);
			List<ProductVO> plist=productService.getProductList(pv);
			bm.addObject("listCount", listCount);
			bm.addObject("plist", plist);
		}else { //카테고리별 상품
			int listCount=productService.getListCount2(pv);
			List<ProductVO> plist=productService.getProductList2(pv);
			bm.addObject("listCount", listCount);
			bm.addObject("plist", plist);
		}
		if(state.equals("all") && m != null) { //전체상품 중 정렬순서 선택 시
			int listCount=productService.getListCount(pv);
			List<ProductVO> plist=productService.getProductListMod(pv);
			bm.addObject("listCount", listCount); 
			bm.addObject("plist", plist);
		}
		if(!state.equals("all") && m != null) { //카테고리 선택, 정렬순서 선택 시
			int listCount=productService.getListCount2(pv);
			List<ProductVO> plist=productService.getProductListMod2(pv);
			bm.addObject("listCount", listCount);
			bm.addObject("plist", plist);
		}
		if(c.equals("bed")){
			bm.setViewName("./product/list_bed");
		}else if(c.equals("sofa")) {
			bm.setViewName("./product/list_sofa");
		}else if(c.equals("table")) {
			bm.setViewName("./product/list_table");
		}else if(c.equals("chair")) {
			bm.setViewName("./product/list_chair");
		}else if(c.equals("cabinet")) {
			bm.setViewName("./product/list_cabinet");
		}
		bm.addObject("state", state);
		return bm;
	}
}
