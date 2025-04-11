package com.igorjava.shawarmadelivery.presentation.service;

import com.igorjava.shawarmadelivery.domain.interactor.UserInteractor;
import com.igorjava.shawarmadelivery.domain.repo.UserRepo;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class UserService extends UserInteractor implements ApplicationContextAware {

    private ApplicationContext ctx;
    private UserRepo repo;

    public UserService() {
        super(null);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx=applicationContext;
        this.repo=ctx.getBean("u r w LL",UserRepo.class);
      //  this.repo= (UserRepo) ctx.getBean("userRepoLinkedList");
      //  this.repo=ctx.getBean("userRepoLinkedList",UserRepo.class);
      //  this.repo=ctx.getBean(UserRepo.class);
        super.setRepo(repo);
    }
}
