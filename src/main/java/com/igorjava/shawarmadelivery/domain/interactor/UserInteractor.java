package com.igorjava.shawarmadelivery.domain.interactor;

import com.igorjava.shawarmadelivery.domain.model.IUser;
import com.igorjava.shawarmadelivery.domain.repo.UserRepo;

public class UserInteractor {

    private UserRepo repo;

    public void setRepo(UserRepo userRepo) {
        this.repo = userRepo;
    }

    public UserInteractor(UserRepo userRepo) {
        this.repo=userRepo;
    }

    public IUser createUser(IUser user){
        return repo.saveUser(user);
    }

    public void deleteUser(IUser user) { repo.deleteUser(user);
    }

    public IUser getUserByEmail(String email){
        return repo.getUserByEmail(email);
    }

    public IUser updateUser(IUser user){
        return repo.updateUser(user);
    }

}
