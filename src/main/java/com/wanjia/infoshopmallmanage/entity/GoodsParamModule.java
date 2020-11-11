package com.wanjia.infoshopmallmanage.entity;


import javax.validation.constraints.NotNull;

/**
 * (GoodsParamModule)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:44
 */
public class GoodsParamModule {
    
    private Long id;
    /**
    * 商品分类id
    */
    @NotNull(message = "商品分类id不能为空")
    private Long goodsSortId;
    /**
    * 参数名
    */
    @NotNull(message = "参数名不能为空")
    private String goodsParamName;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Long getGoodsSortId() {
        return goodsSortId;
    }

    public void setGoodsSortId(Long goodsSortId) {
        this.goodsSortId = goodsSortId;
    }
        
    public String getGoodsParamName() {
        return goodsParamName;
    }

    public void setGoodsParamName(String goodsParamName) {
        this.goodsParamName = goodsParamName;
    }

}