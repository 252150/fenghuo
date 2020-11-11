package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;

/**
 * (GroupMessage)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:44
 */
public class GroupMessage {
    /**
    * 群消息id
    */
    private Long messageId;
    /**
    * 群id
    */
    private Long groupId;
    /**
    * 发送人id
    */
    private Long senderId;
    /**
    * 指定接受人id（比如领取红包写入）
    */
    private Long tdUserId;
    /**
    * 消息类型；0：文字；1：图片；2：语音；3：文件；4：视频；5：商品；6：邀请消息；6：红包消息
    */
    private Integer messageType;
    /**
    * 消息内容
    */
    private String messageText;
    /**
    * 创建时间
    */
    private Date createTime;

        
    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
        
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
        
    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }
        
    public Long getTdUserId() {
        return tdUserId;
    }

    public void setTdUserId(Long tdUserId) {
        this.tdUserId = tdUserId;
    }
        
    public Integer getMessageType() {
        return messageType;
    }

    public void setMessageType(Integer messageType) {
        this.messageType = messageType;
    }
        
    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
        
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}