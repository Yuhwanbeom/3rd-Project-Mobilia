package net.mobilia.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

@Controller
public class HomeController {

	private IamportClient api;
	
	public HomeController() {
		this.api = new IamportClient("6232876357604662", "l91ui5N6mjAPPZkinVjvr3iWSuIOUBPoDyEqGenSIBouQXPS27DGK2Na4o4VDr3BZ14upNYL7aBAS617");
	}
	
	@ResponseBody
	@RequestMapping(value="/verifyIamport/{imp_uid}")
	public IamportResponse<Payment> paymentByImpUid(
			Model model
			, Locale locale
			, HttpSession session
			, @PathVariable(value = "imp_uid") String imp_uid) throws IamportResponseException, IOException{
				return api .paymentByImpUid(imp_uid);
			}
}
