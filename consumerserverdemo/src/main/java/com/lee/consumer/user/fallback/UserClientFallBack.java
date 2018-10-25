package com.lee.consumer.user.fallback;

import com.lee.consumer.user.entity.UserInfo;
import com.lee.consumer.user.feign.UserClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallBack implements UserClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserClientFallBack.class);

    /**
     * hystrix fallback方法
     * @param id id
     * @return 默认的用户
     */
    @Override
    public UserInfo findByIdFeign(String id) {
        UserClientFallBack.LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
        UserInfo user = makeUser();
        return user;
    }

    @Override
    public UserInfo testTimeOutFeign(long time) {
        UserClientFallBack.LOGGER.info("异常发生，进入fallback方法，接收的参数：time = {}", time);
        UserInfo user = makeUser();
        return user;
    }

    private UserInfo makeUser() {
        UserInfo user = new UserInfo();
        user.setId("none");
        user.setUsername("default username");
        user.setAge(0);
        return user;
    }
}
