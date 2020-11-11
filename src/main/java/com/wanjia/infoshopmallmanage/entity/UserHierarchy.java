package com.wanjia.infoshopmallmanage.entity;


/**
 * (UserHierarchy)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:46
 */
public class UserHierarchy {
    
    private Long id;
    /**
    * 上级id
    */
    private Long pid;
    /**
    * 经度
    */
    private String longitude;
    /**
    * 纬度
    */
    private String latitude;
    
    private Integer radius;
    
    private String addrArea;
    /**
    * 详细地址
    */
    private String addrDetail;
    /**
    * 用户id
    */
    private Long userId;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }
        
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
        
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
        
    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }
        
    public String getAddrArea() {
        return addrArea;
    }

    public void setAddrArea(String addrArea) {
        this.addrArea = addrArea;
    }
        
    public String getAddrDetail() {
        return addrDetail;
    }

    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail;
    }
        
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}