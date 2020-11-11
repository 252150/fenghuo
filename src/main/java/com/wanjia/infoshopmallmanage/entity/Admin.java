package com.wanjia.infoshopmallmanage.entity;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * (Admin)实体类
 *
 * @author: wlj
 * @date: 2020-10-13 16:27:33
 */
public class Admin {
    
    public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Admin(Long userId, @NotEmpty(message = "账号不能为空") String adminAccount,
			@NotEmpty(message = "密码不能为空") String adminPassword, @NotEmpty(message = "昵称不能为空") String adminAccountName) {
		super();
		this.userId = userId;
		this.adminAccount = adminAccount;
		this.adminPassword = adminPassword;
		this.adminAccountName = adminAccountName;
	}



	public Admin(Long userId, @NotEmpty(message = "账号不能为空") String adminAccount,
			@NotEmpty(message = "密码不能为空") String adminPassword, String phone,
			@NotEmpty(message = "昵称不能为空") String adminAccountName) {
		super();
		this.userId = userId;
		this.adminAccount = adminAccount;
		this.adminPassword = adminPassword;
		this.phone = phone;
		this.adminAccountName = adminAccountName;
	}



	private Long id;
    /**
    * 用户id
    */
    private Long userId;
    /**
    * 账号
    */
    @NotEmpty(message = "账号不能为空")
    private String adminAccount;
    /**
    * 密码
    */

   @NotEmpty(message = "密码不能为空")

    private String adminPassword;
    /**
    * 状态 ： 0：禁用 1：启用
    */
    private Integer status;
    /**
    * 手机号 
    */
    private String phone;
    /**
    * 昵称
    */
    @NotEmpty(message = "昵称不能为空")
    private String adminAccountName;
    /**
     * 角色Id
     */
    @NotNull(message = "角色不能为空")
    private Long roleId;
    /**
     * 角色名称
     */
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    private Integer page;

    private Integer pageSize;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Admin(Long userId, @NotEmpty(message = "账号不能为空") String adminAccount,
			@NotEmpty(message = "密码不能为空") String adminPassword, Integer status,
			@NotEmpty(message = "昵称不能为空") String adminAccountName) {
		super();
		this.userId = userId;
		this.adminAccount = adminAccount;
		this.adminPassword = adminPassword;
		this.status = status;
		this.adminAccountName = adminAccountName;
	}

	public Integer getPage() {
        return page;
    }


    public Integer getPageSize() {
        return pageSize;
    }

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
        
    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }
        
    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
        
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
        
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
        
    public String getAdminAccountName() {
        return adminAccountName;
    }

    public void setAdminAccountName(String adminAccountName) {
        this.adminAccountName = adminAccountName;
    }

}