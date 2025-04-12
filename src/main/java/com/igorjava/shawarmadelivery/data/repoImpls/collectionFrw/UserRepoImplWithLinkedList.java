package com.igorjava.shawarmadelivery.data.repoImpls.collectionFrw;

import com.igorjava.shawarmadelivery.domain.model.User;
import com.igorjava.shawarmadelivery.domain.repo.UserRepo;
import org.springframework.stereotype.Component;
import java.util.LinkedList;
import java.util.List;

@Component("u r w LL")
public class UserRepoImplWithLinkedList implements UserRepo {

    private final List<User> users=new LinkedList<>();

    @Override
    public User saveUser(User user) {
        users.add(user);
        System.out.println("User created in LinkedList!");
        return user;
    }

    @Override
    public void deleteUser(User user) {
        System.out.println("User deleted from LinkedList!");
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
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(user)){
                users.set(i, user);
            }
        }
        return user;
    }
}
