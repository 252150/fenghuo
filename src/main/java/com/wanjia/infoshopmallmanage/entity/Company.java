package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;

/**
 * (Company)实体类
 *
 * @author: wlj
 * @date: 2020-10-13 10:10:20
 */
public class Company {
    
    private Long id;
    /**
    * 申请人的用户id
    */
    private Long userId;
    /**
    * 公司性质： 0：普通企业；1：政府企业;2:求助中心
    */
    private Integer companyNature;
    /**
    * 完整公司名称
    */
    private String companyName;
    /**
    * 营业执照号
    */
    private String businessNum;
    /**
    * 营业执照
    */
    private String businessLicense;
    /**
    * 申请人的姓名
    */
    private String idcardName;
    /**
    * 申请人的身份证号
    */
    private String idcardNum;
    /**
    * 申请人的身份证正反面照片
    */
    private String idcardImages;
    /**
    * 公司地址
    */
    private String companyAddr;
    /**
    * 创建时间
    */
    private Date createTime;

        
    public Company(Long userId, Integer companyNature, String companyName, String businessNum, String businessLicense,
			String idcardName, String idcardNum, String idcardImages, String companyAddr, Date createTime) {
		super();
		this.userId = userId;
		this.companyNature = companyNature;
		this.companyName = companyName;
		this.businessNum = businessNum;
		this.businessLicense = businessLicense;
		this.idcardName = idcardName;
		this.idcardNum = idcardNum;
		this.idcardImages = idcardImages;
		this.companyAddr = companyAddr;
		this.createTime = createTime;
	}

	public Company() {
		super();
		// TODO Auto-generated constructor stub
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
        
    public Integer getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(Integer companyNature) {
        this.companyNature = companyNature;
    }
        
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
        
    public String getBusinessNum() {
        return businessNum;
    }

    public void setBusinessNum(String businessNum) {
        this.businessNum = businessNum;
    }
        
    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }
        
    public String getIdcardName() {
        return idcardName;
    }

    public void setIdcardName(String idcardName) {
        this.idcardName = idcardName;
    }
        
    public String getIdcardNum() {
        return idcardNum;
    }

    public void setIdcardNum(String idcardNum) {
        this.idcardNum = idcardNum;
    }
        
    public String getIdcardImages() {
        return idcardImages;
    }

    public void setIdcardImages(String idcardImages) {
        this.idcardImages = idcardImages;
    }
        
    public String getCompanyAddr() {
        return companyAddr;
    }

    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }
        
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}