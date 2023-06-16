package com.yejunyu;

import com.yejunyu.service.UserService;
import com.yejunyu.testCase.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author yjy
 * @Description //TODO
 * @Date 2023/6/13
 **/
public class Test1 {

    @Test
    public void testBeanFactory() {
        BeanFactory classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = classPathXmlApplicationContext.getBean("userBean", User.class);
        System.out.println(userBean);
    }

    @Test
    public void testLog() {
        Logger logger = LoggerFactory.getLogger(Test1.class);
        logger.info("xxxxx");
    }

    @Test
    public void testSetDi() {
        BeanFactory classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = classPathXmlApplicationContext.getBean("userServiceBean", UserService.class);
        userService.save();
    }

    @Test
    public void testConDi() {
        BeanFactory classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        UserService userService = classPathXmlApplicationContext.getBean("userServiceBean", UserService.class);
        userService.save();
    }
}
