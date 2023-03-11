package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.OrdersDao;
import com.app.daos.RestaurantDao;
import com.app.daos.RestaurantManagerDao;
import com.app.dtos.Credentials;
import com.app.dtos.CustomerDto;
import com.app.dtos.DaoToEntityConverter;
import com.app.dtos.RestaurantManagerDto;
import com.app.dtos.RestaurantManagerHomePageDto;
import com.app.entities.Customer;
import com.app.entities.OrderItem;
import com.app.entities.Orders;
import com.app.entities.Restaurant;
import com.app.entities.RestaurantManager;

@Service
public class RestaurantManagerService {

	@Autowired
	private RestaurantManagerDao restaurantManagerDao;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	private OrdersDao ordersDao;
	
	public List<RestaurantManager> findAllRestaurantManagers() {
		return restaurantManagerDao.findAll();
	}
	
	public Optional<RestaurantManager> getRestaurantManagerById(int id)
	{
		return restaurantManagerDao.findById(id);
	}
	
	public RestaurantManagerDto getRestaurantManagerDtoById(int id)
	{
		Optional<RestaurantManager> rest=getRestaurantManagerById(id);
		RestaurantManager r =null;
		try {
			r=rest.get();
		}
		catch(Exception e){
			r=null;
			return null;
		}
		RestaurantManagerDto restDto=DaoToEntityConverter.RestaurantManagerEntityToDto(r);
		return restDto;
		
	}
	
     public boolean saveRestaurantManager(RestaurantManager rest)
     {
    	 restaurantManagerDao.save(rest);
    	 return true;
     }

     public RestaurantManagerDto findRestaurantManagerByEmailAndPassword(Credentials cred) {
    	 RestaurantManager rest= restaurantManagerDao.findByEmail(cred.getEmail());
 		if(rest == null || !rest.getPassword().equals(cred.getPassword()))
 			return null;
 		RestaurantManagerDto restaurantManagerDto = DaoToEntityConverter.RestaurantManagerToRestaurantmanagerDto(rest);
 		return restaurantManagerDto;
 	}
     
//     public List<RestaurantManagerHomePageDto> getAllArrivedOrdersFromRestaurant(int restaurantId,String status)
//     {
//    	 Restaurant restId=null;
//		    try {
//		    	restId=restaurantDao.findById(restaurantId).get();
//		    }
//		    catch(Exception e)
//		    {
//		    	return null;
//		    }
//		    
//		    List<Orders> orders=ordersDao.findOrdersByRestaurantId(restaurantId, status);
//		    
//		    List<RestaurantManagerHomePageDto> restDto= new ArrayList<RestaurantManagerHomePageDto>();
//		    
//		  //  orders.forEach(order->restDto.add(DaoToEntityConverter.toRestaurantManagerHomePageDto(order)));
//		    
//			return null;
//     }
     
}
