package com.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.entity.ContactMasterEntity;

public interface ContactsMasterRepo extends JpaRepository<ContactMasterEntity, Integer>{

}
