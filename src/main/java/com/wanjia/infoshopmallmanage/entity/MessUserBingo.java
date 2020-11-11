package com.wanjia.infoshopmallmanage.entity;


/**
 * (MessUserBingo)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:45
 */
public class MessUserBingo {
    
    private Long id;
    /**
    * 发布的信息id
    */
    private Long messPublishId;
    /**
    * 点赞的用户id
    */
    private Long userId;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Long getMessPublishId() {
        return messPublishId;
    }

    public void setMessPublishId(Long messPublishId) {
        this.messPublishId = messPublishId;
    }
        
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}