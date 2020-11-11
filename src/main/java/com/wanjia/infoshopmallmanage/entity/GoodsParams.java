package com.wanjia.infoshopmallmanage.entity;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * (GoodsParams)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:44
 */
public class GoodsParams {
    
    private Long id;
    /**
    * 商品id
    */
    @NotNull(message = "商品id不能为空")
    private Long goodsId;
    /**
    * 参数名
    */
    @NotBlank(message = "商品参数名不能为空")
    private String goodsParamName;
    /**
    * 参数值
    */
    @NotBlank(message = "商品参数值不能为空")
    private String goodsParamValue;

        
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
        
    public String getGoodsParamName() {
        return goodsParamName;
    }

    public void setGoodsParamName(String goodsParamName) {
        this.goodsParamName = goodsParamName;
    }
        
    public String getGoodsParamValue() {
        return goodsParamValue;
    }

    public void setGoodsParamValue(String goodsParamValue) {
        this.goodsParamValue = goodsParamValue;
    }

}