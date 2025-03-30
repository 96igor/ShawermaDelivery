package com.igorjava.shawarmadelivery.domain.interactor;

import com.igorjava.shawarmadelivery.domain.model.Delivery;
import com.igorjava.shawarmadelivery.domain.repo.DeliveryRepo;

public class DeliveryInteractor {

    private final DeliveryRepo repo;

    public DeliveryInteractor(DeliveryRepo repo) {
        this.repo = repo;
    }

    public Delivery createDelivery(Delivery delivery){
        return repo.saveDelivery(delivery);
    }

    public Delivery changeDelivery(Delivery delivery){
        return repo.updateDelivery(delivery);
    }

    public Delivery getDeliveryById(Long id){
        return repo.getDeliveryById(id);
    }

}
