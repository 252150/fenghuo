package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;

/**
 * (OperationLog)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:45
 */
public class OperationLog {
    
    private Long id;
    /**
    * 操作人id
    */
    private Long userId;
    /**
    * 操作人
    */
    private String userName;
    /**
    * 操作时间
    */
    private Date operationTime;
    /**
    * 操作内容
    */
    private String operationContent;
    /**
    * ip地址
    */
    private String ip;
    /**
    * 备注
    */
    private String remarks;

        
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
        
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
        
    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
        
    public String getOperationContent() {
        return operationContent;
    }

    public void setOperationContent(String operationContent) {
        this.operationContent = operationContent;
    }
        
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
        
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}