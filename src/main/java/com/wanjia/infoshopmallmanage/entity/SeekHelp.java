package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;

/**
 * (SeekHelp)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:45
 */
public class SeekHelp {
    /**
    * id
    */
    private Long id;
    /**
    * 求助人id
    */
    private Long seekHelperId;
    /**
    * 求职人电话
    */
    private String seekHelperPhone;
    /**
    * 求助范围: 0:仅向政府中心求助;1：同时向100米以内的朋友求助；2：同时向200米以内的朋友求助；3：同时向300米以内的朋友求助；5：同时向500米以内的朋友求助；10：同时向1000米以内的朋友求助
    */
    private Integer ranger;
    /**
    * 求助内容
    */
    private String seekHelpContent;
    /**
    * 求助类型
    */
    private Integer seekHelpType;
    /**
    * 求助结果；0：假求助；1：真求助
    */
    private Object seekHelpResult;
    /**
    * 求助时间
    */
    private Date seekHelpTime;
    /**
    * 求助失效时间
    */
    private Date seekHelpPrescription;
    
    private String seekAddr;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Long getSeekHelperId() {
        return seekHelperId;
    }

    public void setSeekHelperId(Long seekHelperId) {
        this.seekHelperId = seekHelperId;
    }
        
    public String getSeekHelperPhone() {
        return seekHelperPhone;
    }

    public void setSeekHelperPhone(String seekHelperPhone) {
        this.seekHelperPhone = seekHelperPhone;
    }
        
    public Integer getRanger() {
        return ranger;
    }

    public void setRanger(Integer ranger) {
        this.ranger = ranger;
    }
        
    public String getSeekHelpContent() {
        return seekHelpContent;
    }

    public void setSeekHelpContent(String seekHelpContent) {
        this.seekHelpContent = seekHelpContent;
    }
        
    public Integer getSeekHelpType() {
        return seekHelpType;
    }

    public void setSeekHelpType(Integer seekHelpType) {
        this.seekHelpType = seekHelpType;
    }
        
    public Object getSeekHelpResult() {
        return seekHelpResult;
    }

    public void setSeekHelpResult(Object seekHelpResult) {
        this.seekHelpResult = seekHelpResult;
    }
        
    public Date getSeekHelpTime() {
        return seekHelpTime;
    }

    public void setSeekHelpTime(Date seekHelpTime) {
        this.seekHelpTime = seekHelpTime;
    }
        
    public Date getSeekHelpPrescription() {
        return seekHelpPrescription;
    }

    public void setSeekHelpPrescription(Date seekHelpPrescription) {
        this.seekHelpPrescription = seekHelpPrescription;
    }
        
    public String getSeekAddr() {
        return seekAddr;
    }

    public void setSeekAddr(String seekAddr) {
        this.seekAddr = seekAddr;
    }

}