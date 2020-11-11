package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * (MessType)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:45
 */
public class MessType {
    
    private Long id;
    /**
    * 父id
    */
    private Long pid;
    /**
    *  分类名称 
    */
    private String messTypeName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 分页
     */
    private Integer pageNo;


	/**
    *  分类图标 
    */
    private String icon;
    
    private Long uid;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Long getPid() {
        return pid;
    }
    public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
    public void setPid(Long pid) {
        this.pid = pid;
    }
        
    public String getMessTypeName() {
        return messTypeName;
    }

    public void setMessTypeName(String messTypeName) {
        this.messTypeName = messTypeName;
    }
        
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
        
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
        
    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

}