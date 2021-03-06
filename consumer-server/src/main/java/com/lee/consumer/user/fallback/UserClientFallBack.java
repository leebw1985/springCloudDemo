package com.lee.consumer.user.fallback;

import com.lee.consumer.user.entity.UserInfo;
import com.lee.consumer.user.feign.UserClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallBack implements UserClient {
   //private static final Logger LOGGER = LoggerFactory.getLogger(UserClientFallBack.class);

    private static final Logger logger = LogManager.getLogger(UserClientFallBack.class.getName());
    /**
     * hystrix fallback方法
     * @param id id
     * @return 默认的用户
     */
    @Override
    public UserInfo findByIdFeign(String id) {
        UserClientFallBack.logger.error("异常发生，进入fallback方法，接收的参数：id = {}", id);
        UserInfo user = makeUser();
        return user;
    }

    @Override
    public UserInfo testTimeOutFeign(long time) {
        UserClientFallBack.logger.error("异常发生，进入fallback方法，接收的参数：time = {}", time);
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
