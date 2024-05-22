package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.learning.entity.ContactMasterEntity;
import com.learning.repository.ContactsMasterRepo;

@SpringBootApplication
public class SpringbootRestOracleappApplication {

	public static void main(String[] args) {
		//ConfigurableApplicationContext ctxt=
		SpringApplication.run(SpringbootRestOracleappApplication.class, args);
		
//		ContactsMasterRepo bean=ctxt.getBean(ContactsMasterRepo.class);
//		
//		ContactMasterEntity entity=new ContactMasterEntity();
//		entity.setContactId(101);
//		entity.setContactName("Swaraj");
//		entity.setContactNumber(77350837);
//		
//		bean.save(entity);
//		
//		ctxt.close();
		
	}

}
