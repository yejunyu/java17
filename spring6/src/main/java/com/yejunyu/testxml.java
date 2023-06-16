package com.yejunyu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author yjy
 * @Description //TODO
 * @Date 2023/6/13
 **/
public class testxml {
    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getLogger(testxml.class);
//        logger.info("xxxxxx");
        // 1. 获取容器对象
        ClassPathXmlApplicationContext spring = new ClassPathXmlApplicationContext("spring.xml");
        // 2. 根据bean id从spring中获取这个对象
        Object user = spring.getBean("userBean");
        System.out.println(user);
    }
}
