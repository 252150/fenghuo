package com.wanjia.infoshopmallmanage.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * (Order)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:45
 */
public class Order {
    
    private Long id;
    /**
    *  订单号
    */
    private String orderName;
    /**
    * 用户id 
    */
    private Long userId;
    /**
    * 用户姓名  
    */
    private String userName;
    /**
    *  用户电话
    */
    private String userPhone;
    /**
    * 详细地址 
    */
    private String orderAddr;
    /**
    * 订单商品总数量 
    */
    private Integer orderProductCount;
    /**
    * 订单总价格
    */
    private BigDecimal orderPrices;
    /**
    * 邮费   
    */
    private BigDecimal postage;
    /**
    * 实际支付金额
    */
    private BigDecimal practicalPrice;
    /**
    *  支付邮费
    */
    private BigDecimal payPostage;
    /**
    * 抵扣金额
    */
    private BigDecimal deductionPrice;
    /**
    * 优惠卷id 
    */
    private Long discountId;
    /**
    *  支付状态  0：失败；1：成功
    */
    private Integer payState;
    /**
    * 支付时间  
    */
    private Date payTime;
    /**
    * 支付方式 0 微信，1支付宝
    */
    private Integer payMethod;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    *  订单状态 -1:申请退款；-2:退款成功；0:待发货；1:已发货；2:已收货;3:待付款
    */
    private Integer orderState;
    /**
    * 退款图片
    */
    private String refundImage;
    /**
    * 退款用户说明
    */
    private String refundExplain;
    /**
    * 退款时间
    */
    private Date refundTime;
    /**
    * 前台退款原因
    */
    private String refundCause;
    /**
    * 不退款的理由
    */
    private String refundNotCause;
    /**
    *  退款金额
    */
    private BigDecimal refundPrice;
    /**
    * 快递编号
    */
    private String expressCode;
    /**
    * 快递名称 
    */
    private String expressName;
    /**
    * 送货人姓名
    */
    private String deliveryName;
    /**
    * 发货类型 
    */
    private Integer deliveryType;
    /**
    * 快递单号
    */
    private String expressOddnumbers;
    /**
    * 手机号
    */
    private String deliveryPhone;
    /**
    * 消费赚取积分
    */
    private Integer earnPoints;
    /**
    * 使用积分
    */
    private Integer usePoints;
    /**
    * 给用户退了多少积分
    */
    private Integer sendPoints;
    /**
    * 备注
    */
    private String remarks;
    /**
    *  是否删除0 删除，1 不删除
    */
    private Integer isDelete;
    /**
    * 唯一id（md5加密）
    */
    private String orderSoleId;
    /**
    * 管理员备注
    */
    private String adminRemarks;
    /**
    * 商户id
    */
    private Long commercialId;
    /**
     * 发货时间
     */
    private Date deliveryTime;

    private Integer page;

    private Integer pageSize;

    List<OrderDetail> orderDetails;

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
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
        
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
        
    public String getOrderAddr() {
        return orderAddr;
    }

    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr;
    }
        
    public Integer getOrderProductCount() {
        return orderProductCount;
    }

    public void setOrderProductCount(Integer orderProductCount) {
        this.orderProductCount = orderProductCount;
    }
        
    public BigDecimal getOrderPrices() {
        return orderPrices;
    }

    public void setOrderPrices(BigDecimal orderPrices) {
        this.orderPrices = orderPrices;
    }
        
    public BigDecimal getPostage() {
        return postage;
    }

    public void setPostage(BigDecimal postage) {
        this.postage = postage;
    }
        
    public BigDecimal getPracticalPrice() {
        return practicalPrice;
    }

    public void setPracticalPrice(BigDecimal practicalPrice) {
        this.practicalPrice = practicalPrice;
    }
        
    public BigDecimal getPayPostage() {
        return payPostage;
    }

    public void setPayPostage(BigDecimal payPostage) {
        this.payPostage = payPostage;
    }
        
    public BigDecimal getDeductionPrice() {
        return deductionPrice;
    }

    public void setDeductionPrice(BigDecimal deductionPrice) {
        this.deductionPrice = deductionPrice;
    }
        
    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }
        
    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }
        
    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
        
    public Integer getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(Integer payMethod) {
        this.payMethod = payMethod;
    }
        
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
        
    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }
        
    public String getRefundImage() {
        return refundImage;
    }

    public void setRefundImage(String refundImage) {
        this.refundImage = refundImage;
    }
        
    public String getRefundExplain() {
        return refundExplain;
    }

    public void setRefundExplain(String refundExplain) {
        this.refundExplain = refundExplain;
    }
        
    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }
        
    public String getRefundCause() {
        return refundCause;
    }

    public void setRefundCause(String refundCause) {
        this.refundCause = refundCause;
    }
        
    public String getRefundNotCause() {
        return refundNotCause;
    }

    public void setRefundNotCause(String refundNotCause) {
        this.refundNotCause = refundNotCause;
    }
        
    public BigDecimal getRefundPrice() {
        return refundPrice;
    }

    public void setRefundPrice(BigDecimal refundPrice) {
        this.refundPrice = refundPrice;
    }
        
    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }
        
    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }
        
    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }
        
    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }
        
    public String getExpressOddnumbers() {
        return expressOddnumbers;
    }

    public void setExpressOddnumbers(String expressOddnumbers) {
        this.expressOddnumbers = expressOddnumbers;
    }
        
    public String getDeliveryPhone() {
        return deliveryPhone;
    }

    public void setDeliveryPhone(String deliveryPhone) {
        this.deliveryPhone = deliveryPhone;
    }
        
    public Integer getEarnPoints() {
        return earnPoints;
    }

    public void setEarnPoints(Integer earnPoints) {
        this.earnPoints = earnPoints;
    }
        
    public Integer getUsePoints() {
        return usePoints;
    }

    public void setUsePoints(Integer usePoints) {
        this.usePoints = usePoints;
    }
        
    public Integer getSendPoints() {
        return sendPoints;
    }

    public void setSendPoints(Integer sendPoints) {
        this.sendPoints = sendPoints;
    }
        
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
        
    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
        
    public String getOrderSoleId() {
        return orderSoleId;
    }

    public void setOrderSoleId(String orderSoleId) {
        this.orderSoleId = orderSoleId;
    }
        
    public String getAdminRemarks() {
        return adminRemarks;
    }

    public void setAdminRemarks(String adminRemarks) {
        this.adminRemarks = adminRemarks;
    }
        
    public Long getCommercialId() {
        return commercialId;
    }

    public void setCommercialId(Long commercialId) {
        this.commercialId = commercialId;
    }

}