package com.tamu.alpacagames.service.impl;

import java.util.List;

import com.tamu.alpacagames.model.Orders;
import com.tamu.alpacagames.repository.OrdersRepository;
import com.tamu.alpacagames.service.OrderService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderHistoryImpl implements OrderService {

	@Autowired
    OrdersRepository orderRepository;
    
    @Override
    public List<Orders> GetOrdersByUserId(String userId) {
      orderRepository.findByUserId(userId) ;
      return orderRepository.findByUserId(userId);
    }
    
    @Override
	public List<Orders> getOrders() {
		
    	List<Orders> orderList = orderRepository.findAll();
		return orderList;
	}

}