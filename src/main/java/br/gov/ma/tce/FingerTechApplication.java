package br.gov.ma.tce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

import br.gov.ma.tce.FingerTechApplication;

@SpringBootApplication
@ComponentScan
public class FingerTechApplication {

	
		public static void main(String[] args) {
			SpringApplicationBuilder builder = new SpringApplicationBuilder(FingerTechApplication.class);
	        builder.headless(false).run(args);
	      
	}

}
