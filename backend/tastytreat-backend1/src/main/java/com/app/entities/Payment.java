package com.app.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	
	/*
	 * CREATE TABLE payment (
    ->     id INT NOT NULL AUTO_INCREMENT,
    ->     order_id INT,
    ->     customer_id INT,
    ->     status VARCHAR(30),
    ->
    ->     PRIMARY KEY (id),
    ->     FOREIGN KEY (order_id) REFERENCES orders(id),
    ->     FOREIGN KEY (customer_id) REFERENCES customer(id)
    -> );
    */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name="order_id")
	private Orders orderId;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customerId;
	
	@Column
	private String status;

	public Payment() {
		super();
	}

	public Payment(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Orders getOrderId() {
		return orderId;
	}

	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", orderId=" + orderId + ", customerId=" + customerId + ", status=" + status + "]";
	}

	
}
