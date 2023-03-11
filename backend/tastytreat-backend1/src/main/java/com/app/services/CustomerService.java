package com.app.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.CustomerDao;
import com.app.dtos.Credentials;
import com.app.dtos.CustomerDto;
import com.app.dtos.DaoToEntityConverter;
import com.app.entities.Customer;

import PasswordEncrypt_Decrypt.PasswordHashing;


@Service
@Transactional
public class CustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
//	private PasswordResetTokenRepository passwordResetTokenRepository;
	
	public List<Customer> findAllCustomers() {
		return customerDao.findAll();
	}
	
	public Optional<Customer> getCustomerById(int id) {
		return customerDao.findById(id);
	}
	
	public CustomerDto getCustomerDtoById (int id) {
		Optional<Customer> cust = getCustomerById(id);
		Customer c = null;
		try {
			c = cust.get();
		} catch (Exception e) {
			c = null;
			return null;
		}
		
		CustomerDto custDto = DaoToEntityConverter.customerEntityToDto(c);
		return custDto;
	}
	
	public boolean saveCustomer(Customer cust) {
		customerDao.save(cust);
		return true;
	}
	
	public CustomerDto findCustomerByEmailAndPassword(Credentials cred) {
		Customer cust = customerDao.findByEmail(cred.getEmail());
		if(cust == null || !cust.getPassword().equals(cred.getPassword()))
			return null;
		CustomerDto customerDto = new CustomerDto();
		BeanUtils.copyProperties(cust, customerDto);
		return customerDto;
	}
	
	public CustomerDto findCustomerByEmail(Credentials cred) {
		Customer cust = customerDao.findByEmail(cred.getEmail());
		if(cust == null) {
			return null;
		}
		CustomerDto customerDto = new CustomerDto();
		BeanUtils.copyProperties(cust,customerDto);
		return customerDto;
	}
	
	public boolean updateAddressByCustomerId(int id, String addressText, int pinCode) {
		
		try {
			Customer cust = customerDao.findById(id).get();
			cust.setAddressText(addressText);
			cust.setPinCode(pinCode);
			customerDao.save(cust);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	public CustomerDto findCustomerByEmail(String email) {
		
		Customer cust = customerDao.findByEmail(email);
		if(cust == null) {
			return null;
		}
		CustomerDto customerDto = new CustomerDto();
		BeanUtils.copyProperties(cust,customerDto);
		return customerDto;
	}

	public void savePasswordResetToken(int id, String token) {
		// TODO Auto-generated method stub
		
	}

//	public void savePasswordResetToken(int id, String token) {
//		 Customer customer = customerDao.findById(id)
//		            .orElseThrow(() -> new EntityNotFoundException("Customer not found"));
//
//		    customer.setPasswordResetToken(token);
//		    customerDao.save(customer);
//		
//	}

//	public boolean updateCustomer(CustomerDto customerDto) {
//	    try {
//	        // Map the DTO to an entity
//	        Customer customerEntity = new Customer();
//	        BeanUtils.copyProperties(customerDto, customerEntity);
//
//	        // Save the updated entity to the database
//	        customerDao.save(customerEntity);
//
//	        return true;
//	    } catch (Exception e) {
//	        // Handle any exceptions that occur during the update
//	        System.err.println("Error updating customer");
//	        return false;
//	    }
//	}
//	
//	
//	
//	public CustomerDto findCustomerByPasswordResetToken(String token) {
//	    PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);
//	    if (passwordResetToken == null || passwordResetToken.isExpired()) {
//	        return null;
//	    }
//	    return DaoToDtoConverter.customerEntityToDto(passwordResetToken.getCustomer());
//	}
//	
//






}
	
	
   
	


