package com.wanjia.infoshopmallmanage.entity;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * (GoodsSize)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:44
 */
public class GoodsSize {
    
    private Long id;
    /**
    * 商品id
    */
    @NotNull(message = "规格商品id不能为空")
    private Long goodsId;
    /**
    * 商品属性id
    */

    private Long goodsPropertyId;
    /**
     * 属性名
     */
    private String GoodsPropertyName;
    /**
    * 商品属性值
    */
    @NotBlank(message = "规格属性值不能为空")
    private String goodsPropertyValue;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
        
    public Long getGoodsPropertyId() {
        return goodsPropertyId;
    }

    public void setGoodsPropertyId(Long goodsPropertyId) {
        this.goodsPropertyId = goodsPropertyId;
    }
        
    public String getGoodsPropertyValue() {
        return goodsPropertyValue;
    }

    public void setGoodsPropertyValue(String goodsPropertyValue) {
        this.goodsPropertyValue = goodsPropertyValue;
    }

    public String getGoodsPropertyName() {
        return GoodsPropertyName;
    }

    public void setGoodsPropertyName(String goodsPropertyName) {
        GoodsPropertyName = goodsPropertyName;
    }
}