package com.wanjia.infoshopmallmanage.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wxconfig")
public class WxModel {
	//开发者平台申请得到的应用唯一标识
	public String appId;
	//开发者平台申请得到的应用密钥AppSecret
	public String appSecret;
	//微信支付分配的商户号
	public String mchId;
	//接收微信支付异步通知的回调地址
	public String rechargeNotifyUrl;
	//商户平台设置的密钥key
	public String apiKey;
	//预下单的url
	public String orderUrl;
	//微信商户申请成功后提供的api证书路径
	public String certificatePath;
	//微信退款url
	public String refundUrl;
	//微信退款通知url
	public String refundNotifyUrl;
	public String getRefundNotifyUrl() {
		return refundNotifyUrl;
	}
	public void setRefundNotifyUrl(String refundNotifyUrl) {
		this.refundNotifyUrl = refundNotifyUrl;
	}
	public String getRefundUrl() {
		return refundUrl;
	}
	public void setRefundUrl(String refundUrl) {
		this.refundUrl = refundUrl;
	}
	public String getCertificatePath() {
		return certificatePath;
	}
	public void setCertificatePath(String certificatePath) {
		this.certificatePath = certificatePath;
	}
	public String getCheckOrderUrl() {
		return checkOrderUrl;
	}
	public void setCheckOrderUrl(String checkOrderUrl) {
		this.checkOrderUrl = checkOrderUrl;
	}
	//查单url
	public String checkOrderUrl;
	public String getOrderUrl() {
		return orderUrl;
	}
	public void setOrderUrl(String orderUrl) {
		this.orderUrl = orderUrl;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public String getRechargeNotifyUrl() {
		return rechargeNotifyUrl;
	}
	public void setRechargeNotifyUrl(String rechargeNotifyUrl) {
		this.rechargeNotifyUrl = rechargeNotifyUrl;
	}
	public String getMchId() {
		return mchId;
	}
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	
}
