package com.wanjia.infoshopmallmanage.entity;


/**
 * (LogisticsCompany)实体类
 *
 * @author: wlj
 * @date: 2020-10-21 09:13:51
 */
public class LogisticsCompany {
    
    private Integer id;
    /**
    * 快递公司名称
    */
    private String expressName;
    /**
    * 快递编码
    */
    private String expressCode;
    /**
    * 排序号
    */
    private Integer orderNum;
    /**
    * 状态：1：正常；0：禁用
    */
    private Integer status;

        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
        
    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }
        
    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }
        
    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
        
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}