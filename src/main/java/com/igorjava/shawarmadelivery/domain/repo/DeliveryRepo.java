package com.igorjava.shawarmadelivery.domain.repo;

import com.igorjava.shawarmadelivery.domain.model.Delivery;

public interface DeliveryRepo {
    Delivery saveDelivery(Delivery delivery);
    Delivery updateDelivery(Delivery delivery);
    Delivery getDeliveryById(Long id);
}
