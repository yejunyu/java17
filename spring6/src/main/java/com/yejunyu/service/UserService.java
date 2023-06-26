package com.yejunyu.service;

import com.yejunyu.dao.UserDao;
import com.yejunyu.dao.VipDao;

/**
 * @Author yjy
 * @Description //TODO
 * @Date 2023/6/13
 **/
public class UserService {

    UserDao userDao;

    VipDao vipDao;

    public void setUserDao(UserDao xyz) {
        this.userDao = xyz;
    }

    public void setVipDao(VipDao vipDao) {
        this.vipDao = vipDao;
    }

    public UserService(UserDao userDao, VipDao vipDao) {
        this.userDao = userDao;
        this.vipDao = vipDao;
    }

    public void save() {
        userDao.insert();
    }

    public UserService() {
    }
}
