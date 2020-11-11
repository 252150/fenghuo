package com.wanjia.infoshopmallmanage.entity;


/**
 * (AdvertiseUser)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:44
 */
public class AdvertiseUser {
    
    private Long id;
    /**
    * 广告id  
    */
    private Long advertiseId;
    /**
    * 关联的用户id  
    */
    private Long userId;

        
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

}