package com.app.controllers;

import java.util.List;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.Credentials;
import com.app.dtos.CustomerDto;
import com.app.dtos.CustomerSignUpDto;
import com.app.dtos.DaoToEntityConverter;
import com.app.dtos.FoodItemHomePageDto;
import com.app.dtos.TastyTreatResponse;
import com.app.dtos.ListOfFoodItemIds;
import com.app.dtos.OrdersDto;
import com.app.dtos.PlaceOrderDto;
import com.app.dtos.ResetPasswordDto;
import com.app.dtos.RestaurantHomePageDto;
import com.app.entities.*;
import com.app.services.CustomerService;
import com.app.services.EmailService;
import com.app.services.FoodItemService;
import com.app.services.OrdersService;
import com.app.services.RestaurantService;

import PasswordEncrypt_Decrypt.PasswordHashing;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1/")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private FoodItemService foodItemService;
	
	@Autowired
	private OrdersService ordersService;
	
	/*
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.findAllCustomers();
	}
	
	
	@GetMapping("/customertest")
	public ResponseEntity<HungerBuzzResponse> getAllCustomersTest() {
//		return customerService.findAllCustomers();
		return HungerBuzzResponse.success(customerService.findAllCustomers());
	}
	
	// getCustomerDtoById - demo
	@GetMapping("/customertest/{id}")
	public ResponseEntity<HungerBuzzResponse> getAllCustomersTest(@PathVariable("id") int id) {
		CustomerDto c = customerService.getCustomerDtoById(id);
		if (c == null)
			return HungerBuzzResponse.error("Could not fing customer by that id");
		
		return HungerBuzzResponse.success(c);
	}
	
	// demo
	@GetMapping("/customers/{id}")
	public Optional<Customer> getCustomerById(@PathVariable("id") int id) {
		return customerService.getCustomerById(id);
	}
	*/
	
	
	// Method to add customer to database
	@PostMapping("/customers/signup")
	public ResponseEntity<TastyTreatResponse> signUp(@RequestBody CustomerSignUpDto customerSignUpDto) {
		String password = customerSignUpDto.getPassword();
		String hashedPassword = PasswordHashing.hashPassword(password);
		Customer cust = DaoToEntityConverter.customerSignUpDtoToCustomerEntity(customerSignUpDto);
		cust.setPassword(hashedPassword);
		customerService.saveCustomer(cust);
		
		String recipient=customerSignUpDto.getEmail();
		String subject="Welcome To Tasty Treat!!";
		String body = "Thank you for signing up with Tasty Treat!!. We look forward to serving you!";
		EmailService.sendEmail(recipient, subject, body);
		return TastyTreatResponse.success("Customer added!");
	}
	
	@PostMapping("/customers/signin")
	public ResponseEntity<TastyTreatResponse> signIn(@RequestBody Credentials cred) {
		String password = cred.getPassword();
		CustomerDto customerDto = customerService.findCustomerByEmail(cred);
		System.out.println("in signIn");
		if(customerDto == null)
			return TastyTreatResponse.error("Couldn't find Customer with that credentials");
		
		Customer customer=DaoToEntityConverter.customerSignIn(customerDto);
		System.out.println(customer.getPassword());
		String hashedPassword=customer.getPassword();
		if (PasswordHashing.checkPassword(password, hashedPassword)) {
		    return TastyTreatResponse.success(customerDto);
		} else {
		    return TastyTreatResponse.error("Invalid email or password");
		}
	}
	
	@GetMapping("/restaurants")
	public ResponseEntity<TastyTreatResponse> findAllRestaurants() {
		List<RestaurantHomePageDto> restDtoList = restaurantService.findAllRestaurantHomePageDtos();
		return TastyTreatResponse.success(restDtoList);
	}
	
	@GetMapping("/fooditems/restaurant/{id}")
	public ResponseEntity<TastyTreatResponse> findFoodItemsByRestaurantId(@PathVariable("id") int restaurantId) {
		List<FoodItemHomePageDto> foodItemsDtos = foodItemService.findAllFoodItemsFromRestaurant(restaurantId);
		if (foodItemsDtos == null) {
			return TastyTreatResponse.error("Could not find food items with that restaurant id");
		}
		return TastyTreatResponse.success(foodItemsDtos);
	}
	
	@PostMapping("/fooditems/cart")
	public ResponseEntity<TastyTreatResponse> getCartItems(@RequestBody ListOfFoodItemIds listOfFoodItemIds) {
		List<FoodItemHomePageDto> foodItemsDtos = foodItemService.findAllFoodItemsByIds(listOfFoodItemIds.getItemIds());
		return TastyTreatResponse.success(foodItemsDtos);
	}
	
	@PutMapping("/customers/{id}/address")
	public ResponseEntity<TastyTreatResponse> updateAddress(@PathVariable("id") int id, @RequestBody CustomerDto customerDto) {
		boolean status = customerService.updateAddressByCustomerId(id, customerDto.getAddressText(), customerDto.getPinCode());
		if(!status)
			return TastyTreatResponse.error("Couldn't update address");
		return TastyTreatResponse.success("Ok");
	}
	
	@PostMapping("/orders/place")
	public ResponseEntity<TastyTreatResponse> placeOrder(@RequestBody PlaceOrderDto placeOrderDto) {
		System.out.println(placeOrderDto);
		OrdersDto ordersDto = ordersService.addOrder(placeOrderDto);
		if(ordersDto == null)
			return TastyTreatResponse.error("Couldn't add order");
		return TastyTreatResponse.success(ordersDto);
	}
	
	@GetMapping("/orders/customer/{id}")
	public ResponseEntity<TastyTreatResponse> getAllOrdersbyCustomerId(@PathVariable("id") int customerId) {
		List<OrdersDto> ordersDtoList = ordersService.findAllOrdersByCustomerId(customerId);
		if(ordersDtoList == null || ordersDtoList.isEmpty())
			return TastyTreatResponse.error("List empty!");
		return TastyTreatResponse.success(ordersDtoList);
	}
	
	
	@PostMapping("/customers/forgot-password")
	public ResponseEntity<TastyTreatResponse> forgotPassword(@RequestBody String email) {
	// Check if the email exists in the database
	       CustomerDto customerDto = customerService.findCustomerByEmail(email);
	       if (customerDto == null) {
	            return TastyTreatResponse.error("Could not find customer with that email address.");
	       }

	// Generate a password reset token and save it to the database
	      String token = UUID.randomUUID().toString();
          customerService.savePasswordResetToken(customerDto.getId(), token);

	// Send an email to the customer with a link to reset their password
	      String recipient = customerDto.getEmail();
	      String subject = "Reset your password for HungerBuzz";
	      String body = "Please click the following link to reset your password: http://localhost:3000/reset-password/" + token;
	      EmailService.sendEmail(recipient, subject, body);

	return TastyTreatResponse.success("Password reset token generated and sent to customer.");
}
	
	
//	@PostMapping("/customers/reset-password/{token}")
//	public ResponseEntity<HungerBuzzResponse> resetPassword(@PathVariable String token, @RequestBody ResetPasswordDto resetPasswordDto) {
//	  // Verify that the token is valid
//	  CustomerDto customerDto = customerService.findCustomerByPasswordResetToken(token);
//	  if (customerDto == null) {
//	    return HungerBuzzResponse.error("Invalid password reset token.");
//	  }
//
//	  // Reset the customer's password
//	  boolean success = customerService.resetCustomerPassword(customerDto, resetPasswordDto.getPassword());
//	  if (!success) {
//	    return HungerBuzzResponse.error("Error resetting password.");
//	  }
//
//	  return HungerBuzzResponse.success("Password reset successfully.");
//	}
//	
//	
//	public boolean resetCustomerPassword(CustomerDto customerDto, String newPassword) {
//	    // Hash the new password
//	    String hashedPassword = PasswordHashing.hashPassword(newPassword);
//	    customerDto.setPassword(hashedPassword);
//
//	    // Clear the password reset token
//	    customerDto.setPasswordResetToken(null);
//
//	    // Update the customer in the database
//	    return customerService.updateCustomer(customerDto);
//	}
}
