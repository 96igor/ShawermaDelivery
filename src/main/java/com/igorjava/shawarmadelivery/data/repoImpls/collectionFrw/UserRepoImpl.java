package com.igorjava.shawarmadelivery.data.repoImpls.collectionFrw;

import com.igorjava.shawarmadelivery.domain.model.User;
import com.igorjava.shawarmadelivery.domain.repo.UserRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Repository(value = "URwAL")
public class UserRepoImpl implements UserRepo {

    private final List<User> users = new ArrayList<>();
    private final Logger logo = Logger.getLogger("UserRepoImpl");

    @Override
    public User saveUser(User user) {
        users.add(user);
        logo.info("User created!");
        return user;
    }

    @Override
    public void deleteUser(User user) {
        logo.info("User deleted!");
        users.remove(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User updateUser(User user) {
        int index=users.indexOf(user);
        if (index != -1) users.set(index,user);
        return user;
    }
}
