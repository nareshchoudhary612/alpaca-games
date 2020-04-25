package com.tamu.alpacagames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tamu.alpacagames.model.OrderLine;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long>{
	
}
