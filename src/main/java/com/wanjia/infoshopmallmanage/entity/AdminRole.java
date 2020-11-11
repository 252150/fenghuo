package com.wanjia.infoshopmallmanage.entity;


/**
 * (AdminRole)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:43
 */
public class AdminRole {
    
    public AdminRole(Long adminId, Long roleId) {
		super();
		this.adminId = adminId;
		this.roleId = roleId;
	}

	public AdminRole() {
		super();
		// TODO Auto-generated constructor stub
	}

	private Long id;
    /**
    * 管理员id
    */
    private Long adminId;
    /**
    * 角色id
    */
    private Long roleId;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }
        
    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

}