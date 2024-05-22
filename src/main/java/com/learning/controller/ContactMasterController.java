package com.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.ContactMasterEntity;
import com.learning.repository.ContactsMasterRepo;
import com.learning.service.ContactMasterSerivce;

@RestController
public class ContactMasterController {
	
	@Autowired
	private ContactMasterSerivce contactMasterSerivce;
	
	@PostMapping("/contact")
	public ResponseEntity<String>createContact(@RequestBody ContactMasterEntity contactMasterEntity){
		String status=contactMasterSerivce.upsert(contactMasterEntity);
		return new ResponseEntity<>(status,HttpStatus.CREATED);
	}
	
	@GetMapping("/contact/{contactId}")
	public ResponseEntity<ContactMasterEntity>getContactById(@PathVariable Integer contactId){
		ContactMasterEntity contact=contactMasterSerivce.getById(contactId);
		return new ResponseEntity<>(contact,HttpStatus.OK);		
	}
	@GetMapping("/contacts")
	public ResponseEntity<List<ContactMasterEntity>>getAllContact(){
		List<ContactMasterEntity> allcontacts=contactMasterSerivce.getAllContact();
		return new ResponseEntity<>(allcontacts,HttpStatus.OK);		
	}
	@PutMapping("/contact")
	public ResponseEntity<String>updateContact(@RequestBody ContactMasterEntity contactMasterEntity){
		String status=contactMasterSerivce.upsert(contactMasterEntity);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	@DeleteMapping("/contact/{contactId}")
	public ResponseEntity<String>deletContact(@PathVariable Integer contactId){
		String status=contactMasterSerivce.delectById(contactId);
		return new ResponseEntity<>(status,HttpStatus.OK);
	}
	
	
}
