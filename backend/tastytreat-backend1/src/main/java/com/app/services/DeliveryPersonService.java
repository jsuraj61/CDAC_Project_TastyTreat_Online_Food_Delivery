package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.DeliveryPersonDao;
import com.app.dtos.Credentials;
import com.app.dtos.CustomerDto;
import com.app.dtos.DaoToEntityConverter;
import com.app.dtos.DeliveryPersonDto;
import com.app.dtos.DeliveryPersonSignUpDto;
import com.app.entities.Customer;
import com.app.entities.DeliveryPerson;

@Service
@Transactional
public class DeliveryPersonService {

	@Autowired
	private DeliveryPersonDao deliveryPersonDao;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<DeliveryPerson> findAllDeliveryPerson() {
		return deliveryPersonDao.findAll();
	}
	
	public Optional<DeliveryPerson> getDeliveryPersonById(int id) {
		return deliveryPersonDao.findById(id);
	}
	
	public DeliveryPersonDto getDeliveryPersonDtoById(int id) {
		Optional<DeliveryPerson> dp = getDeliveryPersonById(id);
		DeliveryPerson deliveryPerson = null;
		
		try 
		{
			deliveryPerson = dp.get();
		} 
		catch (Exception e) 
		{
			deliveryPerson = null;
			return null;
		}
		DeliveryPersonDto deliveryPersonDto = new DeliveryPersonDto();
		deliveryPersonDto = DaoToEntityConverter.deliveryPersonEntityToDto(deliveryPerson);
		return deliveryPersonDto;
	}
	
	public boolean saveDeliveryPerson(DeliveryPerson deliveryPerson) {
		deliveryPersonDao.save(deliveryPerson);
		return true;
	}
	
	public DeliveryPersonDto findDeliveryPersonByEmailAndPassword(Credentials cred) {
		DeliveryPerson deliveryPerson = deliveryPersonDao.findByEmail(cred.getEmail());
		if(deliveryPerson == null || !deliveryPerson.getPassword().equals(cred.getPassword()))
			return null;
		DeliveryPersonDto deliveryPersonDto = new DeliveryPersonDto();
		BeanUtils.copyProperties(deliveryPerson, deliveryPersonDto, "password");
		return deliveryPersonDto;
	}
	
	public List<DeliveryPersonDto> findDeliveryPersonByIsAvailable(boolean status) {
		List<DeliveryPerson> deliveryPersons= deliveryPersonDao.findByIsAvailable(status);
		if(deliveryPersons == null)
			return null;
		List<DeliveryPersonDto> deliveryPersonDto = new ArrayList<DeliveryPersonDto>();
		deliveryPersons.forEach(person -> deliveryPersonDto.add(DaoToEntityConverter.deliveryPersonEntityToDto(person)));
		return deliveryPersonDto;
	}
	
	public boolean addDeliveryPerson (DeliveryPersonSignUpDto dto) {
		try {
			DeliveryPerson dp = new DeliveryPerson();
			dp.setName(dto.getName());
			dp.setEmail(dto.getEmail());
			dp.setPassword(dto.getPassword());
			dp.setAvailable(dto.isAvailable());
			
			dp = deliveryPersonDao.save(dp);
			entityManager.refresh(dp);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	
}
