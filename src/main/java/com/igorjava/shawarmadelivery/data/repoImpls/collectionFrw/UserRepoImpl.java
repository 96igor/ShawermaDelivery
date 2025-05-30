package com.igorjava.shawarmadelivery.data.repoImpls.collectionFrw;

import com.igorjava.shawarmadelivery.domain.model.IUser;
import com.igorjava.shawarmadelivery.domain.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository("URwAL")
public class UserRepoImpl implements UserRepo {

    private final List<IUser> users = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1);


    //    private final Logger logo = Logger.getLogger("UserRepoImpl");
    private final Logger logo = LoggerFactory.getLogger(UserRepoImpl.class);

    @Override
    public IUser saveUser(IUser user) {
        user.setId(nextId.getAndIncrement());
        users.add(user);
        logo.info("User created!");
        return user;
    }

    @Override
    public void deleteUser(IUser user) {
        logo.info("User deleted!");
        users.remove(user);
    }

    @Override
    public IUser getUserByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public IUser updateUser(IUser user) {
        int index=users.indexOf(user);
        if (index != -1) users.set(index,user);
        return user;
    }
}
