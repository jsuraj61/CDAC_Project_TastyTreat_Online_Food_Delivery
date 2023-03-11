package com.app.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	Customer findByEmail(String email);
}
