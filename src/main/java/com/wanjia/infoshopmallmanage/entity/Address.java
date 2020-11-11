package com.wanjia.infoshopmallmanage.entity;


/**
 * (Address)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:43
 */
public class Address {
    
    private Long id;
    /**
    * 用户id
    */
    private Long userId;
    
    private String recPerson;
    /**
    *  收货人手机号  
    */
    private String recPersonPhone;
    /**
    *  所在地区
    */
    private String region;
    
    private String addrTag;
    /**
    *  是否是默认地址： 0：否；1：是
    */
    private Integer isDefaultAddr;
    /**
    *  详细地址 
    */
    private String addrDetail;

        
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
        
    public String getRecPerson() {
        return recPerson;
    }

    public void setRecPerson(String recPerson) {
        this.recPerson = recPerson;
    }
        
    public String getRecPersonPhone() {
        return recPersonPhone;
    }

    public void setRecPersonPhone(String recPersonPhone) {
        this.recPersonPhone = recPersonPhone;
    }
        
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
        
    public String getAddrTag() {
        return addrTag;
    }

    public void setAddrTag(String addrTag) {
        this.addrTag = addrTag;
    }
        
    public Integer getIsDefaultAddr() {
        return isDefaultAddr;
    }

    public void setIsDefaultAddr(Integer isDefaultAddr) {
        this.isDefaultAddr = isDefaultAddr;
    }
        
    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }

}