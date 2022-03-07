package br.gov.ma.tce.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.ma.tce.Utils.UtilsNitgen;


@Controller
public class CaptureController {

		@RequestMapping(method = RequestMethod.GET, value= "/login")
		public String inicio() {
			
			
			return "/login";	
		}		
			
			@RequestMapping(method = RequestMethod.GET, value= "/cadastro")
			public String cadastro() {
				
				
				return "/cadastro";	
			
		}
			
			
	
	
	

	

	UtilsNitgen ut = new UtilsNitgen();
	

}
