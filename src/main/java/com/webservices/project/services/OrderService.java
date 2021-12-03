package com.webservices.project.services;

import com.webservices.project.model.entities.Order;
import com.webservices.project.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository ordeRepository;

    public List<Order> findAll(){
        return ordeRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> order = ordeRepository.findById(id);

        return order.get();
    }

}
