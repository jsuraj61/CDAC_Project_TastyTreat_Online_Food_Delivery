package com.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

/*
 * CREATE TABLE orders (
    ->     id INT NOT NULL AUTO_INCREMENT,
    ->     customer_id INT NOT NULL,
    ->     restaurant_id INT,
    ->     status VARCHAR(20),
    ->     assigned_to_delivery_person_id INT,
    ->
    ->
    ->     PRIMARY KEY (id),
    ->     FOREIGN KEY (customer_id) REFERENCES customer(id),
    ->     FOREIGN KEY (restaurant_id) REFERENCES restaurant(id),
    ->     FOREIGN KEY (assigned_to_delivery_person_id) REFERENCES delivery_person(id)
    -> );
    */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customerId;
	
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurantId;
	
	@Column
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "assigned_to_delivery_person_id")
	private DeliveryPerson assignToDeliveryPersonId;
	
	@OneToMany(mappedBy = "orderId")
	private List<OrderItem> orderItems;
	
	@OneToOne(mappedBy = "orderId")
	private Payment payment;

	public Orders(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	
	
	public Orders(Customer customerId, Restaurant restaurantId, String status, DeliveryPerson assignToDeliveryPersonId) {
		super();
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.status = status;
		this.assignToDeliveryPersonId = assignToDeliveryPersonId;
	}

	

	public Orders(int id, Customer customerId, Restaurant restaurantId, String status,
			DeliveryPerson assignToDeliveryPersonId, List<OrderItem> orderItems, Payment payment) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.status = status;
		this.assignToDeliveryPersonId = assignToDeliveryPersonId;
		this.orderItems = orderItems;
		this.payment = payment;
	}



	public Orders() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public Restaurant getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Restaurant restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public DeliveryPerson getAssignToDeliveryPersonId() {
		return assignToDeliveryPersonId;
	}

	public void setAssignToDeliveryPersonId(DeliveryPerson assignToDeliveryPersonId) {
		this.assignToDeliveryPersonId = assignToDeliveryPersonId;
	}

	
	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}



	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}



	public Payment getPayment() {
		return payment;
	}



	public void setPayment(Payment payment) {
		this.payment = payment;
	}



	@Override
	public String toString() {
		return "Orders [id=" + id + ", customerId=" + customerId + ", restaurantId=" + restaurantId + ", status="
				+ status + ", assignToDeliveryPersonId=" + assignToDeliveryPersonId + "]";
	}
	
	
}
