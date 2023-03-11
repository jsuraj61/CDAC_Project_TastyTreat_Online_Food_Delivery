package com.app.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.DeliveryPerson;
import com.app.entities.Orders;
import com.app.entities.Restaurant;



@Repository
public interface OrdersDao extends JpaRepository<Orders, Integer> {

//	@Query("select * from orders where restaurant_id= ?1 and status=?2")
//	List<Orders>findOrdersByRestaurandId(int restaurantId,String status);
	
//	@Query("SELECT o FROM Orders o WHERE o.restaurantId= :p_restaurantId and o.status= :p_status")
//	List<Orders> findByRestaurantIdAndStatus(@Param("p_restaurantId") Restaurant restaurantId, @Param("p_status") String status);
	
	List<Orders> findByRestaurantIdAndStatus(Restaurant restaurantId, String status);
	
	List<Orders> findByStatus(String status);
	
	List<Orders> findByRestaurantId(Restaurant restaurantId);

	List<Orders> findByAssignToDeliveryPersonIdAndStatus(DeliveryPerson deliveryperson, String status);
	
//	@Query(value = "select * from orders where restaurant_id= 5 and status='arrived' ", nativeQuery = true)
//	List<Orders> findByRestaurantIdAndStatus();

}
