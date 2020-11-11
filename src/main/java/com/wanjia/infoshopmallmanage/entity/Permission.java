package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;
import java.util.List;

/**
 * (Permission)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:45
 */
public class Permission {
    /**
    * 权限id
    */
    private Long id;
    /**
    * 权限名称
    */
    private String name;
    /**
    * 权限描述
    */
    private String description;
    /**
    * 权限访问路径
    */
    private String url;
    /**
    * 权限标识
    */
    private String perms;
    /**
    * 父id
    */
    private Long parentId;
    /**
    * 类型；0：目录；1：菜单；2：按钮
    */
    private Integer type;
    /**
    * 排序号
    */
    private Integer orderNum;
    /**
    * 权限状态；0：禁用；1：正常
    */
    private Integer status;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 创建人id
    */
    private Long createAdminId;
    /**
     * 图标
     */
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    private List<Permission> children;

    public List<Permission> getChildren() {
        return children;
    }

    public void setChildren(List<Permission> children) {
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
        
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
        
    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }
        
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
        
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
        
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
        
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
        
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
        
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
        
    public Long getCreateAdminId() {
        return createAdminId;
    }

    public void setCreateAdminId(Long createAdminId) {
        this.createAdminId = createAdminId;
    }

}