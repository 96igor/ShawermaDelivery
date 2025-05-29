package com.igorjava.shawarmadelivery.data.repoImpls.collectionFrw;

import com.igorjava.shawarmadelivery.domain.model.IUser;
import com.igorjava.shawarmadelivery.domain.repo.UserRepo;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

@Repository("u r w LL")
public class UserRepoImplWithLinkedList implements UserRepo {

    private final List<IUser> users=new LinkedList<>();
    private final Logger log = Logger.getLogger("UserRepoImplWithLinkedList");

    @Override
    public IUser saveUser(IUser user) {
        users.add(user);
        log.info("User created in LinkedList!");
        return user;
    }

    @Override
    public void deleteUser(IUser user) {
        log.info("User deleted from LinkedList!");
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
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(user)){
                users.set(i, user);
            }
        }
        return user;
    }
}
