package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;

/**
 * (CompanyStaff)实体类
 *
 * @author: wlj
 * @date: 2020-10-13 10:10:20
 */
public class CompanyStaff {
    
    public CompanyStaff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompanyStaff(Long id, Integer status) {
		super();
		this.id = id;
		this.status = status;
	}

	private Long id;
    public CompanyStaff(Long id, Integer staffLevelId, Long staffId, Long companyId, Integer status) {
		super();
		this.id = id;
		this.staffLevelId = staffLevelId;
		this.staffId = staffId;
		this.companyId = companyId;
		this.status = status;
	}

	public CompanyStaff(Long id, Integer staffLevelId, Long staffId, Long companyId, Integer status, Date examineTime) {
		super();
		this.id = id;
		this.staffLevelId = staffLevelId;
		this.staffId = staffId;
		this.companyId = companyId;
		this.status = status;
		this.examineTime = examineTime;
	}

	/**
    * 员工等级(0:企业创建人等级,1-9:普通员工等级)
    */
    private Integer staffLevelId;
    /**
    * 员工的用户id
    */
    private Long staffId;
    /**
    * 企业id
    */
    private Long companyId;
    /**
    * 企业创建者是否同意员工加入: 0:否,1：是
    */
    private Integer status;
    
    private Date examineTime;

        
    

	public Date getExamineTime() {
		return examineTime;
	}

	public void setExamineTime(Date examineTime) {
		this.examineTime = examineTime;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Integer getStaffLevelId() {
        return staffLevelId;
    }

    public void setStaffLevelId(Integer staffLevelId) {
        this.staffLevelId = staffLevelId;
    }
        
    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }
        
    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
        
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}