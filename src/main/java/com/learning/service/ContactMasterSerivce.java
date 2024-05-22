package com.learning.service;

import java.util.List;

import com.learning.entity.ContactMasterEntity;

import jakarta.servlet.http.HttpServletResponse;

public interface ContactMasterSerivce {
	
	public String upsert(ContactMasterEntity contactMasterEntity);
	
	public ContactMasterEntity getById(Integer contactId);
	
	public List<ContactMasterEntity>getAllContact();
	
	public String delectById(Integer cid);

	public List<ContactMasterEntity>getContactByAddress(String address, Long pinCode );

	public void generateExcel(HttpServletResponse response) throws Exception;
}
