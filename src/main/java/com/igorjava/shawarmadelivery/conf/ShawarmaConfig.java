package com.igorjava.shawarmadelivery.conf;

import com.igorjava.shawarmadelivery.data.repoImpls.collectionFrw.UserRepoImpl;
import com.igorjava.shawarmadelivery.data.repoImpls.collectionFrw.UserRepoImplWithLinkedList;
import com.igorjava.shawarmadelivery.domain.model.User;
import com.igorjava.shawarmadelivery.domain.repo.UserRepo;
import com.igorjava.shawarmadelivery.presentation.service.UserController;
import com.igorjava.shawarmadelivery.presentation.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class ShawarmaConfig {

//    @Bean
//    //@Scope("prototype")
//    public User user(){
//        User user = new User();
//        user.setName("96igor");
//        user.setTelegram("@ig0r_z1000");
//        return user;
//    }

    @Bean(value="URwAL")
    public UserRepo userRepo(){
        return new UserRepoImpl();
    }

    @Bean("u r w LL")
    //@Primary
    public UserRepo userRepoLinkedList(){
        return new UserRepoImplWithLinkedList();
    }

    @Bean
    public UserService userService(){
        return new UserService();
    }

    @Bean
    public UserController userController(){
        return new UserController(userService());
    }


    @Bean
    public CommandLineRunner commandLineRunner(){
        return new ApplicationStartupRunner(userController());
    }
}
