package com.yejunyu;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

/**
 * @Author: yejunyu
 * @Date: Created in 2023/6/29
 * @Description: TODO
 **/
@RedisHash("user")
public class User {

    @Id
    String id;

    String callbackUrl;
    Integer isCallBack;

    Integer isPayCallback;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public Integer getIsCallBack() {
        return isCallBack;
    }

    public void setIsCallBack(Integer isCallBack) {
        this.isCallBack = isCallBack;
    }

    public Integer getIsPayCallback() {
        return isPayCallback;
    }

    public void setIsPayCallback(Integer isPayCallback) {
        this.isPayCallback = isPayCallback;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                ", isCallBack=" + isCallBack +
                ", isPayCallback=" + isPayCallback +
                '}';
    }
}
