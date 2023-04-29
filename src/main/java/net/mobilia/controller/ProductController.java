package net.mobilia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.mobilia.service.ProductService;
import net.mobilia.vo.ProductVO;

@Controller
@RequestMapping("/mobilia")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("")
	public ModelAndView mobilia(ProductVO pv){
		
		ModelAndView plist=new ModelAndView();
		
		List<ProductVO> nlist=productService.getNewItem(pv);
		List<ProductVO> mlist=productService.getMdChoice(pv);
		
		plist.addObject("nlist", nlist);
		plist.addObject("mlist", mlist);
		plist.setViewName("./index");
		return plist;
		
		
	}
}
