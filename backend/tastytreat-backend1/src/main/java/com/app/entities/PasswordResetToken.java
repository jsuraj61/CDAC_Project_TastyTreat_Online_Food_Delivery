package com.app.entities;
//package com.hungerbuzz.entities;
//
//import java.time.LocalDateTime;
//
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
//
//public class PasswordResetToken {
//	
//	 @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	    private Long id;
//
//	    @OneToOne
//	    @JoinColumn(name = "customer_id")
//	    private Customer customer;
//
//	    @Column(name = "token")
//	    private String token;
//
//	    @Column(name = "expiry_date")
//	    private LocalDateTime expiryDate;
//
//		public Long getId() {
//			return id;
//		}
//
//		public void setId(Long id) {
//			this.id = id;
//		}
//
//		public Customer getCustomer() {
//			return customer;
//		}
//
//		public void setCustomer(Customer customer) {
//			this.customer = customer;
//		}
//
//		public String getToken() {
//			return token;
//		}
//
//		public void setToken(String token) {
//			this.token = token;
//		}
//
//		public LocalDateTime getExpiryDate() {
//			return expiryDate;
//		}
//
//		public void setExpiryDate(LocalDateTime expiryDate) {
//			this.expiryDate = expiryDate;
//		}
//	    
//	    
//
//}
