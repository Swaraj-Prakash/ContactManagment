package com.learning.service;

import java.util.List;

import com.learning.entity.ContactMasterEntity;

public interface ContactMasterSerivce {
	
	public String upsert(ContactMasterEntity contactMasterEntity);
	
	public ContactMasterEntity getById(Integer contactId);
	
	public List<ContactMasterEntity>getAllContact();
	
	public String delectById(Integer cid);

}
