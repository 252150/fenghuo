package com.wanjia.infoshopmallmanage.entity;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * (GoodsProperty)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:44
 */
public class GoodsProperty {
    
    private Long id;
    /**
    * 商品id
    */
    @NotNull(message = "商品id不能为空")
    private Long goodsId;
    /**
    * 属性名
    */
    @NotBlank(message = "属性名不能为空")
    private String goodsPropertyName;
    /**
     * 商品规格
     */
    @Valid
    @Size(min = 1,message = "添加一条规则必须有一个属性")
    private List<GoodsSize> goodsSizes;
    /**
    * 备注
    */
    private String remarks;

    public List<GoodsSize> getGoodsSizes() {
        return goodsSizes;
    }

    public void setGoodsSizes(List<GoodsSize> goodsSizes) {
        this.goodsSizes = goodsSizes;
    }

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
        
    public String getGoodsPropertyName() {
        return goodsPropertyName;
    }

    public void setGoodsPropertyName(String goodsPropertyName) {
        this.goodsPropertyName = goodsPropertyName;
    }
        
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}