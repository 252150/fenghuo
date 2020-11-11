package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;

/**
 * (AdvertiseClickDeli)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:44
 */
public class AdvertiseClickDeli {
    
    private Long id;
    /**
    * 广告id
    */
    private Long advertiseId;
    /**
    * 用户id 
    */
    private Long userId;
    /**
    * 点击时间
    */
    private Date clickTime;
    /**
    *  点击经度
    */
    private String clickLongitude;
    /**
    * 点击纬度
    */
    private String clickLatitude;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Long getAdvertiseId() {
        return advertiseId;
    }

    public void setAdvertiseId(Long advertiseId) {
        this.advertiseId = advertiseId;
    }
        
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
        
    public Date getClickTime() {
        return clickTime;
    }

    public void setClickTime(Date clickTime) {
        this.clickTime = clickTime;
    }
        
    public String getClickLongitude() {
        return clickLongitude;
    }

    public void setClickLongitude(String clickLongitude) {
        this.clickLongitude = clickLongitude;
    }
        
    public String getClickLatitude() {
        return clickLatitude;
    }

    public void setClickLatitude(String clickLatitude) {
        this.clickLatitude = clickLatitude;
    }

}