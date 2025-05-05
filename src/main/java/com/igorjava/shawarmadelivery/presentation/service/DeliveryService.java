package com.igorjava.shawarmadelivery.presentation.service;

import com.igorjava.shawarmadelivery.domain.interactor.DeliveryInteractor;
import com.igorjava.shawarmadelivery.domain.repo.DeliveryRepo;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService extends DeliveryInteractor {
    public DeliveryService(DeliveryRepo repo) {
        super(repo);
    }
}
