package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;

/**
 * (UserFootmark)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:46
 */
public class UserFootmark {
    
    private Long id;
    /**
    * 用户id 
    */
    private Long userId;
    /**
    * 足迹类型；0:商品；1:发布的信息
    */
    private Integer footmarkType;
    /**
    * 浏览时间 
    */
    private Date browseTime;
    /**
    * 内容id
    */
    private Long contentId;
    /**
    * 经度
    */
    private String longitude;
    /**
    * 纬度
    */
    private String latitude;

        
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
        
    public Integer getFootmarkType() {
        return footmarkType;
    }

    public void setFootmarkType(Integer footmarkType) {
        this.footmarkType = footmarkType;
    }
        
    public Date getBrowseTime() {
        return browseTime;
    }

    public void setBrowseTime(Date browseTime) {
        this.browseTime = browseTime;
    }
        
    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
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

}