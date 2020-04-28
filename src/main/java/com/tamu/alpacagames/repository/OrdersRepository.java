package com.tamu.alpacagames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.tamu.alpacagames.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders , Long>{
   List<Orders> findByUserId(String userid);
   
   @Query(nativeQuery =true, value= "SELECT * FROM orders WHERE user_id=:cd and delivery_status=:bo")
   List<Orders> findByUserIdAndDeliveryStatus(@Param("cd") String userid, @Param("bo") Boolean b );
   
   @Query(value = "SELECT max(orderId) FROM Orders")
	public Long max();
}
