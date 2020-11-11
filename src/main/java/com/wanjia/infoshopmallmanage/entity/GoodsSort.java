package com.wanjia.infoshopmallmanage.entity;

import com.wanjia.infoshopmallmanage.validated.Groups;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * (GoodsSort)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:44
 */
public class GoodsSort {
    
    private Long id;
    /**
    * 父id
    */
    @NotNull(groups = {Groups.Insert.class},message = "父级不能为空")
    private Long pid;
    /**
    * 分类名称
    */
    @NotBlank(groups = {Groups.Insert.class},message = "分类名称不能为空")
    private String sortName;
    /**
    * 排序（按层级排序）
    */
    private Integer orderTag;
    /**
    * 图标
    */
    private String sortImage;
    /**
    * 是否推荐: 0:否，1：是
    */
    private Integer recommendTag;
    /**
    * 添加时间
    */
    private Date addTime;

    private List<GoodsSort> children;

    public List<GoodsSort> getChildren() {
        return children;
    }

    public void setChildren(List<GoodsSort> children) {
        this.children = children;
    }

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
        
    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }
        
    public Integer getOrderTag() {
        return orderTag;
    }

    public void setOrderTag(Integer orderTag) {
        this.orderTag = orderTag;
    }
        
    public String getSortImage() {
        return sortImage;
    }

    public void setSortImage(String sortImage) {
        this.sortImage = sortImage;
    }
        
    public Integer getRecommendTag() {
        return recommendTag;
    }

    public void setRecommendTag(Integer recommendTag) {
        this.recommendTag = recommendTag;
    }
        
    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

}