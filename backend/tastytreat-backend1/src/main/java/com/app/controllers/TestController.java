package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Customer;
import com.app.entities.DeliveryPerson;
import com.app.entities.FoodItem;
import com.app.entities.FoodType;
import com.app.entities.OrderItem;
import com.app.entities.Orders;
import com.app.entities.Payment;
import com.app.entities.Restaurant;
import com.app.entities.RestaurantManager;
import com.app.services.CustomerService;
import com.app.services.DeliveryPersonService;
import com.app.services.FoodItemService;
import com.app.services.FoodTypeService;
import com.app.services.OrderItemService;
import com.app.services.OrdersService;
import com.app.services.PaymentService;
import com.app.services.RestaurantManagerService;
import com.app.services.RestaurantService;

@RestController
@RequestMapping("/api/test/")
public class TestController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private DeliveryPersonService deliveryPersonService;
	
	@Autowired
	private FoodItemService foodItemService;
	
	@Autowired
	private FoodTypeService foodTypeService;
	
	@Autowired
	private OrderItemService orderItemService;
	
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private RestaurantManagerService restaurantManagerService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/customers")
	public List<Customer> findAllCustomers() {
		return customerService.findAllCustomers();
	}
	
	@GetMapping("/deliverypersons")
	public List<DeliveryPerson> findDeliveryPerson() {
		return deliveryPersonService.findAllDeliveryPerson();
	}
	
	@GetMapping("/fooditems")
	public List<FoodItem> findAllFoodItems() {
		return foodItemService.findAllFoodItems();
	}
	
//	@GetMapping("/foodtypes")
//	public List<FoodType> findAllFoodTypes() {
//		return foodTypeService.findAllFoodTypes();
//	}
	
	@GetMapping("/orderitems")
	public List<OrderItem> findAllOrderItems() {
		return orderItemService.findAllOrderItems();
	}
	
	@GetMapping("/orders")
	public List<Orders> findAllOrders() {
		return ordersService.findAllOders();
	}

	@GetMapping("/payments")
	public List<Payment> findAllPayments() {
		return paymentService.findAllPayments();
	}
	
	@GetMapping("/restaurantmanagers")
	public List<RestaurantManager> findAllRestaurantManagers() {
		return restaurantManagerService.findAllRestaurantManagers();
	}
	
	@GetMapping("/restaurants")
	public List<Restaurant> findAllRestaurants() {
		return restaurantService.findAllRestaurants();
	}
}
