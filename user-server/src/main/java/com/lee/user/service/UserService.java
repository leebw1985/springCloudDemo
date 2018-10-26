package com.lee.user.service;

import com.lee.user.domain.UserInfo;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    public UserInfo getOne(String id){
        UserInfo user = new UserInfo();
        user.setAge(10);
        user.setId(id);
        user.setUsername("张三" + id);
        return user;
    }

}