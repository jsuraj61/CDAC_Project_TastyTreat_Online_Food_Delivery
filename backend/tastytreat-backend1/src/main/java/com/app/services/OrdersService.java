package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.daos.CustomerDao;
import com.app.daos.DeliveryPersonDao;
import com.app.daos.FoodItemDao;
import com.app.daos.OrderItemDao;
import com.app.daos.OrdersDao;
import com.app.daos.PaymentDao;
import com.app.daos.RestaurantDao;
import com.app.dtos.CustomerDto;
import com.app.dtos.DaoToEntityConverter;
import com.app.dtos.DeliveryPersonHomePageDto;
import com.app.dtos.OrdersDto;
import com.app.dtos.PlaceOrderDto;
import com.app.entities.Customer;
import com.app.entities.DeliveryPerson;
import com.app.entities.OrderItem;
import com.app.entities.Orders;
import com.app.entities.Payment;
import com.app.entities.Restaurant;

@Service
@Transactional
public class OrdersService {

	@Autowired
	private OrdersDao ordersDao;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Autowired
	private OrderItemDao orderItemDao;
	
	@Autowired
	private FoodItemDao foodItemDao;
	
	@Autowired
	private PaymentDao paymentDao;
	
	@Autowired
	private DeliveryPersonDao deliveryPersonDao;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Orders> findAllOders() {
		return ordersDao.findAll();
	}
	


	public OrdersDto addOrder(PlaceOrderDto placeOrderDto) {
		OrdersDto ordersDto = null;
		try {
			Orders order = new Orders();
			
			Customer cust = customerDao.getById(placeOrderDto.getCustomerId());
			Restaurant rest = restaurantDao.getById(placeOrderDto.getRestaurantId());
			
			order.setCustomerId(cust);
			order.setRestaurantId(rest);
			order.setAssignToDeliveryPersonId(null);
			order.setStatus("arrived");
			
			Orders ordersEntity = ordersDao.save(order);
			System.out.println(ordersEntity);
			
			placeOrderDto.getFoodItemsInOrder().forEach(orderItem -> orderItemDao.save(new OrderItem(
						ordersEntity,
						foodItemDao.getById(orderItem.getFoodItemId()),
						orderItem.getFoodName(),
						orderItem.getFoodPrice()*orderItem.getFoodQuantity(),
						orderItem.getFoodQuantity()
					)));
			
			// save payment
			Payment payment = new Payment();
			payment.setCustomerId(cust);
			payment.setOrderId(ordersEntity);
			payment.setStatus("paid");
			paymentDao.save(payment);
			
			// construct orderDto to send back
			entityManager.refresh(ordersEntity);
			ordersDto = DaoToEntityConverter.orderToOrderDto(ordersEntity);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return ordersDto;
	}



	public Optional<Orders> grtOrdersById(int id) {
		return ordersDao.findById(id);
	}
	
	public DeliveryPersonHomePageDto getdeliveryPersonHomePageDtoById (int id) {
		Optional<Orders> orders = grtOrdersById(id);
		Orders o = null;
		try {
			o = orders.get();
		} catch (Exception e) {
			o = null;
			return null;
		}
		
		DeliveryPersonHomePageDto Dto = DaoToEntityConverter.toDeliveryPersonDTO(o);
		return Dto;
		
	}
	
	public List<Orders> findArrivedOrdersByRestaurantIdAndStatus(int restId, String status) {
		Restaurant rest = restaurantDao.getById(restId);
		List<Orders> orders = new ArrayList<Orders>();
		orders = ordersDao.findByRestaurantIdAndStatus(rest, status);
//		System.out.println(orders);
		return orders;
	}
	
	public List<Orders> findAllOrdersByRestaurantid(int restId) {
		Restaurant rest = restaurantDao.getById(restId);
		List<Orders> ordersList = ordersDao.findByRestaurantId(rest);
		return ordersList;
	}
	
	public boolean setStatusForOrder(int orderId, String status) {
		try {
			Orders order = ordersDao.getById(orderId);
			order.setStatus(status);
			ordersDao.save(order);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public List<OrdersDto> findAllOrdersByCustomerId(int customerId) {
		List<OrdersDto> ordersDto = null;
		try {
			Customer cust = customerDao.getById(customerId);
			List<Orders> orderList = cust.getOrders();
			ordersDto = DaoToEntityConverter.ordersToOrdersDto(orderList);
		} catch (Exception e) {
			return null;
		}
		
		return ordersDto;
	}
	
	public List<DeliveryPersonHomePageDto> findAllOrdersByDeliveryPerson(int deliveryPersonId) {
		List<DeliveryPersonHomePageDto> dphpdtoList = new ArrayList<DeliveryPersonHomePageDto>();
		try {
			DeliveryPerson deliveryPerson = deliveryPersonDao.getById(deliveryPersonId);
			List<Orders> orders = deliveryPerson.getOrders();
			orders.forEach(order -> dphpdtoList.add(DaoToEntityConverter.toDeliveryPersonDTO(order)));
		} catch (Exception e) {
			return null;
		}
		return dphpdtoList;	
	}
	
	public boolean assignDeliveryPersonToOrder(int orderId, int deliveryPersonId) {
		try {
			Orders order = ordersDao.getById(orderId);
			DeliveryPerson deliveryPerson = deliveryPersonDao.getById(deliveryPersonId);
			order.setStatus("out for delivery");
			order.setAssignToDeliveryPersonId(deliveryPerson);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	
	public List<DeliveryPersonHomePageDto> findArrivedordersByDeliverypersonIdAndStatus(int deliverypersonId, String status) {
		DeliveryPerson deliveryperson = deliveryPersonDao.getById(deliverypersonId);
		List<Orders> orderslist = ordersDao.findByAssignToDeliveryPersonIdAndStatus(deliveryperson,status);
		List<DeliveryPersonHomePageDto> deliverypersonHomePageDtoList = new ArrayList<DeliveryPersonHomePageDto>();
		orderslist.forEach(order -> deliverypersonHomePageDtoList.add(DaoToEntityConverter.toDeliveryPersonDTO(order)));
		
		return deliverypersonHomePageDtoList;
	}

}
