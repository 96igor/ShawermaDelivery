package com.igorjava.shawarmadelivery.domain.repo;

import com.igorjava.shawarmadelivery.domain.model.IUser;

public interface UserRepo {
    IUser saveUser(IUser user);
    void deleteUser(IUser user);
    IUser getUserByEmail(String email);
    IUser updateUser(IUser user);
}
