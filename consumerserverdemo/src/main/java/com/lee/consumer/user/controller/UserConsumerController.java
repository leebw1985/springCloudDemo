package com.lee.consumer.user.controller;

import com.lee.consumer.user.entity.UserInfo;
import com.lee.consumer.user.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserConsumerController {
    @Autowired
    private UserClient userClient;

    @GetMapping("feign/{id}")
    public UserInfo findByIdFeign(@PathVariable String id) {
        UserInfo userInfo = this.userClient.findByIdFeign(id);
        return userInfo;
    }

    @GetMapping("feign/time_out/{time}")
    public UserInfo findUserTimeOutTest(@PathVariable Long time) {
        UserInfo userInfo = this.userClient.testTimeOutFeign(time);
        return userInfo;
    }
}
