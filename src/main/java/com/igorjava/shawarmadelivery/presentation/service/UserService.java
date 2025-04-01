package com.igorjava.shawarmadelivery.presentation.service;

import com.igorjava.shawarmadelivery.domain.interactor.UserInteractor;
import com.igorjava.shawarmadelivery.domain.repo.UserRepo;

public class UserService extends UserInteractor {
    public UserService(UserRepo userRepo) {
        super(userRepo);
    }
}
