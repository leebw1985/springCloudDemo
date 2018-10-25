package com.lee.user.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.lee.user.domain.UserInfo;
import com.lee.user.service.UserService;

@RestController
public class UserController {
    //Logger log = LoggerFactory.getLogger(UserController.class);
    Logger logger = LogManager.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;
    /**
     * 注：@GetMapping("/{id}")是spring 4.3的新注解等价于：
     * @RequestMapping(value = "/id", method = RequestMethod.GET)
     * 类似的注解还有@PostMapping等等
     * @param id
     * @return user信息
     */
    @GetMapping("/{id}")
    public UserInfo  findById(@PathVariable("id") String id) {
        UserInfo findOne = this.userService.getOne(id);
        logger.info("---" + findOne.toString());
        return findOne;
    }


    @GetMapping("/time_out/{time}")
    public UserInfo testTimeout(@PathVariable("time") Long time) {

        //让程序等待传入的时间毫秒数量
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        UserInfo findOne = this.userService.getOne(time.toString());
        logger.info("---" + findOne.toString());
        return findOne;
    }
}