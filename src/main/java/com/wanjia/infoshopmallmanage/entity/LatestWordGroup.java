package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;

/**
 * (LatestWordGroup)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:44
 */
public class LatestWordGroup {
    /**
    * 最新群消息id
    */
    private Long id;
    /**
    * 群成员id
    */
    private Long userId;
    /**
    * 群id
    */
    private Long groupId;
    /**
    * 发送人id，(为0时，为系统推送消息)
    */
    private Long sendUserId;
    /**
    * 聊天信息
    */
    private String chatText;
    /**
    * 发送时间
    */
    private Date createTime;
    /**
    * 阅读状态；0：未读；1：已读
    */
    private Integer chatStatus;
    /**
    * 未读数量
    */
    private Integer unreadMessageNum;
    /**
    * 消息类型；0：文字；1：图片；2：语音；3：文件；4：视频；5：商品
    */
    private Integer chatMessageType;

        
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
        
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
        
    public Long getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Long sendUserId) {
        this.sendUserId = sendUserId;
    }
        
    public String getChatText() {
        return chatText;
    }

    public void setChatText(String chatText) {
        this.chatText = chatText;
    }
        
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
        
    public Integer getChatStatus() {
        return chatStatus;
    }

    public void setChatStatus(Integer chatStatus) {
        this.chatStatus = chatStatus;
    }
        
    public Integer getUnreadMessageNum() {
        return unreadMessageNum;
    }

    public void setUnreadMessageNum(Integer unreadMessageNum) {
        this.unreadMessageNum = unreadMessageNum;
    }
        
    public Integer getChatMessageType() {
        return chatMessageType;
    }

    public void setChatMessageType(Integer chatMessageType) {
        this.chatMessageType = chatMessageType;
    }

}