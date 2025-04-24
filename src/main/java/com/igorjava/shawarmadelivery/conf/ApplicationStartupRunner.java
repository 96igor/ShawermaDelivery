package com.igorjava.shawarmadelivery.conf;

import com.igorjava.shawarmadelivery.domain.model.User;
import com.igorjava.shawarmadelivery.presentation.service.UserController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {

    private final UserController userController;

    public ApplicationStartupRunner(UserController userController) {
        this.userController = userController;
    }

    @Override
    public void run(String... args) throws Exception {



    }
}
