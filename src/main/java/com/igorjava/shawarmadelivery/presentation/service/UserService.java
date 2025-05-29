package com.igorjava.shawarmadelivery.presentation.service;

import com.igorjava.shawarmadelivery.domain.interactor.UserInteractor;
import com.igorjava.shawarmadelivery.domain.model.User;
import com.igorjava.shawarmadelivery.domain.repo.UserRepo;
import com.igorjava.shawarmadelivery.presentation.service.dto.MapperDto;
import com.igorjava.shawarmadelivery.presentation.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService extends UserInteractor {

    private UserRepo userRepo;
    private MapperDto mapper;

    public UserService(@Qualifier("URwAL") UserRepo userRepo) {
        super(userRepo);
    }

    @Override
    public User createUser(User user) {
        return super.createUser(mapper.getUserFromDto(user));
    }
}
