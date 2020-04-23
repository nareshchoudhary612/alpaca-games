package com.tamu.alpacagames.service;

import java.util.List;
import com.tamu.alpacagames.model.Orders;

public interface OrderService {
    List<Orders> GetOrdersByUserId(String userId);

}