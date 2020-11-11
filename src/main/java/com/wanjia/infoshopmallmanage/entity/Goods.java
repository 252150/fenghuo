package com.wanjia.infoshopmallmanage.entity;


import com.wanjia.infoshopmallmanage.validated.Groups;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * (Goods)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:44
 */
public class Goods {
   @NotNull( groups = {Groups.Update.class}, message = "商品id不能为空")
    private Long id;
    /**
    * 商户id
    */
    private Long merId;
    /**
    * 推荐图
    */
    private String recommendImage;
    /**
    * 轮播图
    */
    private String rotationImages;
    /**
    * 商品名称
    */
   @NotEmpty(groups = {Groups.Insert.class},message = "商品名称不能为空")
    private String goodsName;
    /**
    * 商品简介
    */
    private String goodsIntroduce;
    /**
    * 商品描述
    */
    private String goodsDescription;
    /**
    * 关键字
    */
    private String goodsKeyword;
    /**
    * 分类id
    */
    @NotNull(groups = {Groups.Insert.class},message = "分类id不能为空")
    private Long goodsSortId;
    /**
    * 商品价格
    */
    private BigDecimal goodsPrice;
    /**
    * 会员价格
    */
    private BigDecimal goodsVipPrice;
    /**
    * 市场价格
    */
    private BigDecimal marketPrice;
    /**
    * 单位名
    */
    private String unitName;
    /**
    * 活动标题
    */
    private String activityTitle;
    /**
    * 活动属性
    */
    private String activityProperty;
    /**
    * 参团人数
    */
    private Integer joinTeamPeopleNum;
    /**
    * 倒序排序(具有权限的商品管理页面手工修改)
    */
    private Long goodsSort;
    /**
    * 销量
    */
    private Integer goodsSaleNum;
    /**
    * 库存量
    */
    private Integer goodsStock;
    /**
    * 添加时间
    */
    private Date addTime;
    /**
    * 商品上架状态：0：未上架，1：上架
    */
    private Integer goodsStatus;
    /**
    * 是否热卖： 1:是；0:否
    */
    private Integer isHot;
    /**
    * 是否优惠： 1:是；0:否
    */
    private Integer isDiscount;
    /**
    * 是否精品： 1:是；0:否
    */
    private Integer isBest;
    /**
    * 是否新品： 1:是；0:否
    */
    private Integer isNew;
    /**
    * 是否包邮 ；1:是；0:否
    */
    private Integer emailFree;
    /**
    * 是否删除 ；1:是；0:否
    */
    private Object isDelete;
    /**
    * 商户是否代理 ；1:是；0:否
    */
    private Integer merUse;
    /**
    * 获得积分
    */
    @Min(value = 0,message = "赠送积分大于等于0")
    private Integer giveIntegral;
    /**
    * 成本价
    */
    private BigDecimal costPrice;
    /**
    * 邮费
    */
    private BigDecimal emailPrice;
    /**
    * 秒杀状态： 1：开启;0：关闭
    */
    private Integer isSeckill;
    /**
    * 砍价状态： 1：开启;0：关闭
    */
    private Integer isBargain;
    /**
    * 虚拟销量
    */
    private Integer fictitiousSaleNum;
    /**
    * 商品二维码地址
    */
    private String goodsQrcodePath;
    /**
    * 浏览量
    */
    private Integer browserNum;
    /**
    * 收藏量
    */
    private Integer collectionNum;
    /**
     * 商品参数
     */
    private List<GoodsParams> goodsParams;

    public List<GoodsParams> getGoodsParams() {
        return goodsParams;
    }

    public void setGoodsParams(List<GoodsParams> goodsParams) {
        this.goodsParams = goodsParams;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Long getMerId() {
        return merId;
    }

    public void setMerId(Long merId) {
        this.merId = merId;
    }
        
    public String getRecommendImage() {
        return recommendImage;
    }

    public void setRecommendImage(String recommendImage) {
        this.recommendImage = recommendImage;
    }
        
    public String getRotationImages() {
        return rotationImages;
    }

    public void setRotationImages(String rotationImages) {
        this.rotationImages = rotationImages;
    }
        
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
        
    public String getGoodsIntroduce() {
        return goodsIntroduce;
    }

    public void setGoodsIntroduce(String goodsIntroduce) {
        this.goodsIntroduce = goodsIntroduce;
    }
        
    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }
        
    public String getGoodsKeyword() {
        return goodsKeyword;
    }

    public void setGoodsKeyword(String goodsKeyword) {
        this.goodsKeyword = goodsKeyword;
    }
        
    public Long getGoodsSortId() {
        return goodsSortId;
    }

    public void setGoodsSortId(Long goodsSortId) {
        this.goodsSortId = goodsSortId;
    }
        
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
        
    public BigDecimal getGoodsVipPrice() {
        return goodsVipPrice;
    }

    public void setGoodsVipPrice(BigDecimal goodsVipPrice) {
        this.goodsVipPrice = goodsVipPrice;
    }
        
    public BigDecimal getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(BigDecimal marketPrice) {
        this.marketPrice = marketPrice;
    }
        
    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
        
    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }
        
    public String getActivityProperty() {
        return activityProperty;
    }

    public void setActivityProperty(String activityProperty) {
        this.activityProperty = activityProperty;
    }
        
    public Integer getJoinTeamPeopleNum() {
        return joinTeamPeopleNum;
    }

    public void setJoinTeamPeopleNum(Integer joinTeamPeopleNum) {
        this.joinTeamPeopleNum = joinTeamPeopleNum;
    }
        
    public Long getGoodsSort() {
        return goodsSort;
    }

    public void setGoodsSort(Long goodsSort) {
        this.goodsSort = goodsSort;
    }
        
    public Integer getGoodsSaleNum() {
        return goodsSaleNum;
    }

    public void setGoodsSaleNum(Integer goodsSaleNum) {
        this.goodsSaleNum = goodsSaleNum;
    }
        
    public Integer getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }
        
    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
        
    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }
        
    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }
        
    public Integer getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(Integer isDiscount) {
        this.isDiscount = isDiscount;
    }
        
    public Integer getIsBest() {
        return isBest;
    }

    public void setIsBest(Integer isBest) {
        this.isBest = isBest;
    }
        
    public Integer getIsNew() {
        return isNew;
    }

    public void setIsNew(Integer isNew) {
        this.isNew = isNew;
    }
        
    public Integer getEmailFree() {
        return emailFree;
    }

    public void setEmailFree(Integer emailFree) {
        this.emailFree = emailFree;
    }
        
    public Object getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Object isDelete) {
        this.isDelete = isDelete;
    }
        
    public Integer getMerUse() {
        return merUse;
    }

    public void setMerUse(Integer merUse) {
        this.merUse = merUse;
    }
        
    public Integer getGiveIntegral() {
        return giveIntegral;
    }

    public void setGiveIntegral(Integer giveIntegral) {
        this.giveIntegral = giveIntegral;
    }
        
    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }
        
    public BigDecimal getEmailPrice() {
        return emailPrice;
    }

    public void setEmailPrice(BigDecimal emailPrice) {
        this.emailPrice = emailPrice;
    }
        
    public Integer getIsSeckill() {
        return isSeckill;
    }

    public void setIsSeckill(Integer isSeckill) {
        this.isSeckill = isSeckill;
    }
        
    public Integer getIsBargain() {
        return isBargain;
    }

    public void setIsBargain(Integer isBargain) {
        this.isBargain = isBargain;
    }
        
    public Integer getFictitiousSaleNum() {
        return fictitiousSaleNum;
    }

    public void setFictitiousSaleNum(Integer fictitiousSaleNum) {
        this.fictitiousSaleNum = fictitiousSaleNum;
    }
        
    public String getGoodsQrcodePath() {
        return goodsQrcodePath;
    }

    public void setGoodsQrcodePath(String goodsQrcodePath) {
        this.goodsQrcodePath = goodsQrcodePath;
    }
        
    public Integer getBrowserNum() {
        return browserNum;
    }

    public void setBrowserNum(Integer browserNum) {
        this.browserNum = browserNum;
    }
        
    public Integer getCollectionNum() {
        return collectionNum;
    }

    public void setCollectionNum(Integer collectionNum) {
        this.collectionNum = collectionNum;
    }

}