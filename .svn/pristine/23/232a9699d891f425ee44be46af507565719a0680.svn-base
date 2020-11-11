package com.wanjia.infoshopmallmanage.entity;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * (GoodsPrice)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:44
 */
public class GoodsPrice {
    
    private Long id;
    /**
    * 商品id
    */
    @NotNull
    private Long goodsId;
    /**
    * 商品属性组合值（属性名：属性值；逗号拼接）
    */
    private String goodsPropertyValue;
    /**
    * 属性对应的库存
    */
    @NotNull(message = "库存不能为空")
    @Min(value=0,message = "库存不能为负数")
    private Integer goodsPropertyStock;
    /**
    * 销量
    */
    private Integer goodsPropertySaleNum;
    /**
    * 属性价格
    */
    @NotNull(message = "价格不能为空")
    @Min(value=0,message = "价格不能为负数")
    private BigDecimal goodsPropertyPrice;
    /**
    * 图片
    */
    private String goodsPropertyImage;
    /**
    * 商品规格组合值（逗号拼接，id小的在前面）
    */
    private String goodsPropertyOnlyValue;
    /**
    * 成本价
    */
   @Min(value=0,message = "价格不能为负数")
    private BigDecimal goodsPropertyCost;

        
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
        
    public String getGoodsPropertyValue() {
        return goodsPropertyValue;
    }

    public void setGoodsPropertyValue(String goodsPropertyValue) {
        this.goodsPropertyValue = goodsPropertyValue;
    }
        
    public Integer getGoodsPropertyStock() {
        return goodsPropertyStock;
    }

    public void setGoodsPropertyStock(Integer goodsPropertyStock) {
        this.goodsPropertyStock = goodsPropertyStock;
    }
        
    public Integer getGoodsPropertySaleNum() {
        return goodsPropertySaleNum;
    }

    public void setGoodsPropertySaleNum(Integer goodsPropertySaleNum) {
        this.goodsPropertySaleNum = goodsPropertySaleNum;
    }
        
    public BigDecimal getGoodsPropertyPrice() {
        return goodsPropertyPrice;
    }

    public void setGoodsPropertyPrice(BigDecimal goodsPropertyPrice) {
        this.goodsPropertyPrice = goodsPropertyPrice;
    }
        
    public String getGoodsPropertyImage() {
        return goodsPropertyImage;
    }

    public void setGoodsPropertyImage(String goodsPropertyImage) {
        this.goodsPropertyImage = goodsPropertyImage;
    }
        
    public String getGoodsPropertyOnlyValue() {
        return goodsPropertyOnlyValue;
    }

    public void setGoodsPropertyOnlyValue(String goodsPropertyOnlyValue) {
        this.goodsPropertyOnlyValue = goodsPropertyOnlyValue;
    }
        
    public BigDecimal getGoodsPropertyCost() {
        return goodsPropertyCost;
    }

    public void setGoodsPropertyCost(BigDecimal goodsPropertyCost) {
        this.goodsPropertyCost = goodsPropertyCost;
    }

}