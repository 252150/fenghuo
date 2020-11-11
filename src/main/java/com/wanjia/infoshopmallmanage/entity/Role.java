package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;
import java.util.List;

/**
 * (Role)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:45
 */
public class Role {
    /**
    * 角色id
    */
    private Long roleId;
    /**
    * 角色名称
    */
    private String roleName;
    /**
    * 角色描述
    */
    private String description;
    /**
    * 角色状态：0：禁用；1：正常
    */
    private Integer status;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 最近更新时间
    */
    private Date updateTime;
    /**
    * 创建人
    */
    private Long createAdminId;
    /**
     * 角色拥有的权限id
     */
    private List<Long> permissionIds;

    public List<Long> getPermissionIds() {
        return permissionIds;
    }

    public void setPermissionIds(List<Long> permissionIds) {
        this.permissionIds = permissionIds;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
        
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
        
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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