package com.tamu.alpacagames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamu.alpacagames.model.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders , Long>{
	
}
