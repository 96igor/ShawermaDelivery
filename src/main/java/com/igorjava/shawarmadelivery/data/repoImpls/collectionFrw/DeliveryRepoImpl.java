package com.igorjava.shawarmadelivery.data.repoImpls.collectionFrw;

import com.igorjava.shawarmadelivery.domain.model.Delivery;
import com.igorjava.shawarmadelivery.domain.model.IDelivery;
import com.igorjava.shawarmadelivery.domain.repo.DeliveryRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DeliveryRepoImpl implements DeliveryRepo {

    private final List<IDelivery> deliveries = new ArrayList();

    @Override
    public IDelivery saveDelivery(IDelivery delivery) {
        deliveries.add(delivery);
        return delivery;
    }

    @Override
    public IDelivery updateDelivery(IDelivery delivery) {
        int index=deliveries.indexOf(delivery);
        if (index != -1) deliveries.set(index, delivery);
        return delivery;
    }

    @Override
    public IDelivery getDeliveryById(Long id) {
        return deliveries.stream()
                .filter(del -> del.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
