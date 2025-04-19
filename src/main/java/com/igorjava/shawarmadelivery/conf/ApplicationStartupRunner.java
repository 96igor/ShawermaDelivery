package com.igorjava.shawarmadelivery.conf;

import com.igorjava.shawarmadelivery.domain.model.User;
import com.igorjava.shawarmadelivery.presentation.service.UserController;
import com.igorjava.shawarmadelivery.presentation.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupRunner implements CommandLineRunner, ApplicationContextAware {
    private ApplicationContext ctx;

//    private final UserController userController;

//    public ApplicationStartupRunner(UserController userController) {
//        this.userController = userController;
//    }

    @Override
    public void run(String... args) throws Exception {

        UserController controller = new UserController(ctx.getBean(UserService.class));
        User user = new User();
        controller.createUser(user);
        controller.deleteUser(user);

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
