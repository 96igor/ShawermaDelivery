package com.igorjava.shawarmadelivery.conf;

import com.igorjava.shawarmadelivery.data.repoImpls.collectionFrw.UserRepoImpl;
import com.igorjava.shawarmadelivery.domain.repo.UserRepo;
import com.igorjava.shawarmadelivery.presentation.service.UserController;
import com.igorjava.shawarmadelivery.presentation.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShawarmaConfig {

    @Bean
    public UserRepo userRepo(){
        return new UserRepoImpl();
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


//    @Bean
//    public UserService userService(UserRepo userRepo){
//        return new UserService(userRepo);
//    }

}
