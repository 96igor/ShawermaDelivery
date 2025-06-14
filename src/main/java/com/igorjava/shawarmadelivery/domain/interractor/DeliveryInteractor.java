package com.igorjava.shawarmadelivery.domain.interractor;

import com.igorjava.shawarmadelivery.domain.model.IDelivery;
import com.igorjava.shawarmadelivery.domain.repo.DeliveryRepo;

public class DeliveryInteractor {

    private final DeliveryRepo repo;

    public DeliveryInteractor(DeliveryRepo repo) {
        this.repo = repo;
    }

    public IDelivery createDelivery(IDelivery delivery){
        return repo.saveDelivery(delivery);
    }

    public IDelivery changeDelivery(IDelivery delivery){
        return repo.updateDelivery(delivery);
    }

    public IDelivery getDeliveryById(Long id){
        return repo.getDeliveryById(id);
    }

}
