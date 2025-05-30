package com.igorjava.shawarmadelivery.domain.repo;

import com.igorjava.shawarmadelivery.domain.model.IDelivery;

public interface DeliveryRepo {
    IDelivery saveDelivery(IDelivery delivery);
    IDelivery updateDelivery(IDelivery delivery);
    IDelivery getDeliveryById(Long id);
}
