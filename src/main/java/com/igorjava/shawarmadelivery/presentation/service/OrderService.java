package com.igorjava.shawarmadelivery.presentation.service;

import com.igorjava.shawarmadelivery.domain.interractor.OrderInteractor;
import com.igorjava.shawarmadelivery.domain.repo.OrderRepo;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends OrderInteractor {
    public OrderService(OrderRepo repo) {
        super(repo);
    }
}
