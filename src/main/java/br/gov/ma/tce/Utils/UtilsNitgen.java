package br.gov.ma.tce.Utils;

import java.util.ArrayList;

import br.gov.ma.tce.Models.Digital;
import com.nitgen.SDK.BSP.NBioBSPJNI;
import com.nitgen.SDK.BSP.NBioBSPJNI.FIR_HANDLE;

import ft_enro.view.Enroll;


public class UtilsNitgen {
	NBioBSPJNI bsp;
	NBioBSPJNI.IndexSearch    IndexSearchEngine;
	ArrayList<Digital> ad;	
	
	public  UtilsNitgen(){
		
	
		 bsp = new NBioBSPJNI();
	     IndexSearchEngine = bsp.new IndexSearch();		 
		 this.bsp = bsp;
		
		
		
	}
	
	
	public String Captura() {
		
		bsp.OpenDevice();		
		NBioBSPJNI.FIR_HANDLE captura = bsp.new FIR_HANDLE();	
		bsp.Capture(captura);	
		bsp.CloseDevice();
		return  handleparaString(captura);
		
	}
	
	

	
// 

	
	//convert String para inputFir
	//retorta INPUT_FIR
	public NBioBSPJNI.INPUT_FIR stringToInputFIR(String digital) {
		
		NBioBSPJNI.FIR_TEXTENCODE textSavedFIRA;
		textSavedFIRA = bsp.new FIR_TEXTENCODE();
		textSavedFIRA.TextFIR = digital;
		NBioBSPJNI.INPUT_FIR inputFIR = bsp.new INPUT_FIR();
		inputFIR.SetTextFIR(textSavedFIRA);			
		return inputFIR;
		
	}
	
	
	//Handle para String
	public String handleparaString(NBioBSPJNI.FIR_HANDLE digital) {
		
		NBioBSPJNI.FIR_TEXTENCODE textSavedFIRA = bsp.new FIR_TEXTENCODE();		
		bsp.GetTextFIRFromHandle(digital, textSavedFIRA);	
		
		
		return textSavedFIRA.TextFIR;
		
		
		
	}
	
	public boolean identify(String digital) {
		
		
		bsp.OpenDevice();
		Boolean resultado = new Boolean(false);		
		bsp.Verify(stringToInputFIR(digital), resultado, null);
		bsp.CloseDevice();
		return resultado;
		
	}
	
	

	
	public String enrollDigital() {		
		Enroll enroll = new Enroll();	
		
		return handleparaString(enroll.EnrolInit());
		
		
	}
	
	
	
	public boolean check1to1(Digital fp, Digital fp2){		

		NBioBSPJNI.FIR_TEXTENCODE textSavedFIRA;
		NBioBSPJNI.FIR_TEXTENCODE textSavedFIRA2;
		
        textSavedFIRA = bsp.new FIR_TEXTENCODE();
        textSavedFIRA.TextFIR = fp.getDigitalp(); 
        
        textSavedFIRA2 = bsp.new FIR_TEXTENCODE();
        textSavedFIRA2.TextFIR = fp2.getDigitals();	
        
		NBioBSPJNI.INPUT_FIR inputFIR = bsp.new INPUT_FIR();
		NBioBSPJNI.INPUT_FIR inputFIR2 = bsp.new INPUT_FIR();
		Boolean bResult = new Boolean(false);
		NBioBSPJNI.FIR_PAYLOAD payload = bsp.new FIR_PAYLOAD();
		
		inputFIR.SetTextFIR(textSavedFIRA);
		inputFIR2. SetTextFIR(textSavedFIRA2);		
		
		bsp.VerifyMatch(inputFIR, inputFIR2, bResult, payload);
		
		
		return bResult;
		
	}
	
	
	
	

	
	   private Boolean CheckError()    {
	        if (bsp.IsErrorOccured())  {	           
	            return true;
	        }

	        return false;
	    }
}