package br.gov.ma.tce.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.FingerTechWeb.FingertechAPIWeb.Models.Digital;
import com.nitgen.SDK.BSP.NBioBSPJNI;
import com.nitgen.SDK.BSP.NBioBSPJNI.FIR_PAYLOAD;
import com.nitgen.SDK.BSP.NBioBSPJNI.FIR_TEXTENCODE;
import com.nitgen.SDK.BSP.NBioBSPJNI.INPUT_FIR;

import br.gov.ma.tce.Utils.UtilsNitgen;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class restController {
	@GetMapping("/captura/Capturar")
	public String captureSingleFinger() {
		
		return  ut.Captura();	
		
	}
	

	
	
	@GetMapping("/captura/Comparar")
	public boolean compareFingerPrint( String digital) {	
		
					
		
		return ut.identify(digital);
		
	}	



  

UtilsNitgen ut = new UtilsNitgen();	
}
