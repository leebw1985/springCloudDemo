package com.lee.consumer.user.feign;


import com.lee.consumer.user.entity.UserInfo;
import com.lee.consumer.user.fallback.UserClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 使用@FeignClient注解的fallback属性，指定fallback类
 */
@FeignClient(name = "userinfo-server", fallback = UserClientFallBack.class)
public interface UserClient {

    @RequestMapping("/{id}")
    UserInfo findByIdFeign(@PathVariable("id") String id);

    @RequestMapping("/time_out/{time}")
    UserInfo testTimeOutFeign(@PathVariable("time") long time);

}