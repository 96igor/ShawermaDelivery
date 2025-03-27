package com.igorjava.shawarmadelivery.domain.repo;

import com.igorjava.shawarmadelivery.domain.model.User;

public interface UserRepo {
    User saveUser(User user);
    void deleteUser(User user);
    User getUserByEmail(String email);
    User updateUser(User user);
}
