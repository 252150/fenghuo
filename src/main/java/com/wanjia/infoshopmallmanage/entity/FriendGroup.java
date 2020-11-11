package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;

/**
 * (FriendGroup)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:44
 */
public class FriendGroup {
    /**
    * 分组id
    */
    private Long groupId;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 分组排序
    */
    private Integer groupOrder;
    /**
    * 分组名
    */
    private String groupName;
    /**
    * 创建时间
    */
    private Date createTime;

        
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
        
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
        
    public Integer getGroupOrder() {
        return groupOrder;
    }

    public void setGroupOrder(Integer groupOrder) {
        this.groupOrder = groupOrder;
    }
        
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
        
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}