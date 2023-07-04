/**
 * Organization: lemon-china <br>
 * Date: 2023-06-28 11:15:27 <br>
 * Automatically Generate By EasyCodeGenerine <br>
 * Copyright (c) 2023 All Rights Reserved.
 */
package com.yejunyu;


import java.util.Date;


/**************************
 * DeviceActivationReportDto
 * 渠道推广设备激活上报
 * @author lonyee
 * @date 2023-06-28 11:15:27
 *
 **************************/
public class DeviceActivationReportDto {
    private static final long serialVersionUID = 1L;
    //fields
    /**
     * 安卓id，仅安卓用
     **/
    private String androidId;
    /**
     * 推广的渠道
     **/
    private String appChannel;
    /**
     * ios为idfa号，安卓此字段存imei号
     **/
    private String appIdfa;
    /**
     * 激活回调的地址
     **/
    private String callbackUrl;
    /**
     * 点击时的时间
     **/
    private Date clickDatetime;
    /**
     * 创建时间
     **/
    private Date createdDate;
    /**
     * 自定义的唯一标识
     **/
    private String deviceImei;
    /**
     * 1:ios;2:安卓
     **/
    private Integer deviceOsType;
    /**
     * 主键
     **/
    private Long id;
    /**
     * 是否激活
     **/
    private Integer isCallback;
    /**
     * 是否有关键行为
     **/
    private Integer isKeyAction;
    /**
     * 是否付费
     **/
    private Integer isPayCallback;
    /**
     * 是否注册
     **/
    private Integer isRegisterCallback;
    /**
     * 次日是否登录
     **/
    private Integer isRetention;
    /**
     * oaid，仅安卓用
     **/
    private String oaId;
    /**
     * 备注
     **/
    private String remark;
    /**
     * 更新时间
     **/
    private Date updatedDate;
    /**
     * 用户ID
     **/
    private Long userId;


    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public String getAndroidId() {
        return androidId;
    }

    public void setAppChannel(String appChannel) {
        this.appChannel = appChannel;
    }

    public String getAppChannel() {
        return appChannel;
    }

    public void setAppIdfa(String appIdfa) {
        this.appIdfa = appIdfa;
    }

    public String getAppIdfa() {
        return appIdfa;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setClickDatetime(Date clickDatetime) {
        this.clickDatetime = clickDatetime;
    }

    public Date getClickDatetime() {
        return clickDatetime;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setDeviceImei(String deviceImei) {
        this.deviceImei = deviceImei;
    }

    public String getDeviceImei() {
        return deviceImei;
    }

    public void setDeviceOsType(Integer deviceOsType) {
        this.deviceOsType = deviceOsType;
    }

    public Integer getDeviceOsType() {
        return deviceOsType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setIsCallback(Integer isCallback) {
        this.isCallback = isCallback;
    }

    public Integer getIsCallback() {
        return isCallback;
    }

    public void setIsKeyAction(Integer isKeyAction) {
        this.isKeyAction = isKeyAction;
    }

    public Integer getIsKeyAction() {
        return isKeyAction;
    }

    public void setIsPayCallback(Integer isPayCallback) {
        this.isPayCallback = isPayCallback;
    }

    public Integer getIsPayCallback() {
        return isPayCallback;
    }

    public void setIsRegisterCallback(Integer isRegisterCallback) {
        this.isRegisterCallback = isRegisterCallback;
    }

    public Integer getIsRegisterCallback() {
        return isRegisterCallback;
    }

    public void setIsRetention(Integer isRetention) {
        this.isRetention = isRetention;
    }

    public Integer getIsRetention() {
        return isRetention;
    }

    public void setOaId(String oaId) {
        this.oaId = oaId;
    }

    public String getOaId() {
        return oaId;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
