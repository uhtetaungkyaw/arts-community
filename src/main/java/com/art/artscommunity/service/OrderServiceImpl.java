package com.art.artscommunity.service;

import com.art.artscommunity.model.OrderDetail;
import com.art.artscommunity.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public OrderDetail create(OrderDetail order) {
        return orderRepo.save(order);
    }
}
