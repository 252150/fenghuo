package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;

/**
 * (UserCollect)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:46
 */
public class UserCollect {
    /**
    * id
    */
    private Long id;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 类型；0：商品；1：发布的信息
    */
    private Integer collectType;
    /**
    * 内容id
    */
    private Long contentId;
    /**
    * 收藏时间
    */
    private Date collectTime;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
        
    public Integer getCollectType() {
        return collectType;
    }

    public void setCollectType(Integer collectType) {
        this.collectType = collectType;
    }
        
    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }
        
    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

}