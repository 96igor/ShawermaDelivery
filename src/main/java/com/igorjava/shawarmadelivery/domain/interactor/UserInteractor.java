package com.igorjava.shawarmadelivery.domain.interactor;

import com.igorjava.shawarmadelivery.domain.model.User;
import com.igorjava.shawarmadelivery.domain.repo.UserRepo;

public class UserInteractor {

    private UserRepo repo;

    public void setRepo(UserRepo userRepo) {
        this.repo = userRepo;
    }

    public UserInteractor(UserRepo userRepo) {
        this.repo=userRepo;
    }

    public User createUser(User user){
        return repo.saveUser(user);
    }

    public void deleteUser(User user){
        repo.deleteUser(user);
    }

    public User getUserByEmail(String email){
        return repo.getUserByEmail(email);
    }

    public User updateUser(User user){
        return repo.updateUser(user);
    }

}
