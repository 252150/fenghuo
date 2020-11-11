package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;

/**
 * (OfflineMessage)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:45
 */
public class OfflineMessage {
    
    private Long id;
    /**
    * 发送人id
    */
    private Long senderId;
    /**
    * 接受人id
    */
    private Long receiverId;
    /**
    * 发送时间
    */
    private Date createTime;
    /**
    * 消息类型；0：文字；1：图片；2：语音；3:文件；4：视频；5：商品
    */
    private Integer msgType;
    /**
    * 聊天类型；0：私聊；1：群聊；2：分组群发
    */
    private Integer chatType;
    /**
    * 群id
    */
    private Long groupId;
    /**
    * 好友分组id
    */
    private Long friendGroupId;
    /**
    * 消息内容
    */
    private String content;
    /**
    * 那个的离线消息
    */
    private Long userId;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }
        
    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }
        
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
        
    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }
        
    public Integer getChatType() {
        return chatType;
    }

    public void setChatType(Integer chatType) {
        this.chatType = chatType;
    }
        
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
        
    public Long getFriendGroupId() {
        return friendGroupId;
    }

    public void setFriendGroupId(Long friendGroupId) {
        this.friendGroupId = friendGroupId;
    }
        
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
        
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}