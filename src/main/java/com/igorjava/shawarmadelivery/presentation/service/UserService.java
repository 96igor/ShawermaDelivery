package com.igorjava.shawarmadelivery.presentation.service;

import com.igorjava.shawarmadelivery.domain.interractor.UserInteractor;
import com.igorjava.shawarmadelivery.domain.repo.UserRepo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService extends UserInteractor {

    private UserRepo userRepo;

    public UserService(@Qualifier("URwAL") UserRepo userRepo) {
        super(userRepo);
    }

}
