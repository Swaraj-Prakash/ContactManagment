package com.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.entity.ContactMasterEntity;

public interface ContactsMasterRepo extends JpaRepository<ContactMasterEntity, Integer>{

	@Query(value="select *from contacts_master where address=?1 and pinCode=?2",nativeQuery = true)
	public List<ContactMasterEntity>getContactByAddress(@Param("address") String address,@PathVariable("pinCode") Long pinCode);
}
