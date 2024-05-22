package com.learning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.entity.ContactMasterEntity;
import com.learning.repository.ContactsMasterRepo;

@Service
public class ContactServiceImpl implements ContactMasterSerivce{

	@Autowired
	private ContactsMasterRepo contactsMasterRepo;
	@Override
	public String upsert(ContactMasterEntity contactMasterEntity) {
		contactsMasterRepo.save(contactMasterEntity);
		return "Success";
	}

	@Override
	public ContactMasterEntity getById(Integer contactId) {
		Optional<ContactMasterEntity>findById= contactsMasterRepo.findById(contactId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<ContactMasterEntity> getAllContact() {
		return contactsMasterRepo.findAll();
	}

	@Override
	public String delectById(Integer cid) {
		if(contactsMasterRepo.existsById(cid)) {
			contactsMasterRepo.deleteById(cid);
			return "delet success";
		}else {
			return "no record found";
		}
		
	}

}
