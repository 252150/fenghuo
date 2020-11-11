package com.wanjia.infoshopmallmanage.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * (Advertise)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:43
 */
public class Advertise {

	private Long id;
	/**
	 * 广告类型(0:启动广告,1:弹出广告 2:信息广告)
	 */
	private Integer advertiseType;
	/**
	 * 广告标题
	 */
	private String advertiseTitle;
	/**
	 * 广告文件名
	 */
	private String imageName;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 生效时间
	 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date sxTime;
	/**
	 * 过期时间
	 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date overTime;
	/**
	 * 停止时间
	 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date stopTime;
	/**
	 * 投放开始s时间
	 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tfTimeBeg;
	/**
	 * 投放结束时间
	 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date tfTimeEnd;
	/**
	 * 广告状态(0:有效，1：未审核,2: 未通过，3: 失效，4：合同中止
	 */
	private Integer advertiseStatus;
	/**
	 * 广告指向的链接
	 */
	private String advertiseUrl;
	/**
	 * 看广告积分
	 */
	private Integer adPoints;
	/**
	 * 时长(秒)
	 */
	private Integer adDuration;
	/**
	 * 至少看多少秒
	 */
	private Integer leastTime;
	/**
	 * 是否强制性广告 0：非强制 1：强制
	 */
	private Integer isQzts;
	/**
	 * 广告金额
	 */
	private BigDecimal advertiseAmount;
	/**
	 * 广告商公司名称
	 */
	private String advertiseuserName;
	/**
	 * 广告点击次数
	 */
	private Integer clickNum;
	/**
	 * 点赞量 判断 0小于等于 1大于等于
	 */
	private Integer isclick;
	public Integer getIsclick() {
		return isclick;
	}

	public void setIsclick(Integer isclick) {
		this.isclick = isclick;
	}

	/**
	 * 广告内容类型；0：其它；1：游戏；2：服装
	 */
	private Integer contenttype;
	/**
	 * 图标
	 */
	private String icon;
	/**
	 * 用户名
	 */
	private String userName;
	private Long userId;
	/**
	 * 文件上传
	 */
	private List<MultipartFile> imageNamePartFile;
	/**
	 * log上传
	 */
    private MultipartFile multipartFile;
    /**
     * 分页
     */
    private Integer pageNo;
    /**
                  * 管理员id
     */
    private Long adminId;
    
	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public MultipartFile getMultipartFile() {
		return multipartFile;
	}

	public void setMultipartFile(MultipartFile multipartFile) {
		this.multipartFile = multipartFile;
	}




	public List<MultipartFile> getImageNamePartFile() {
		return imageNamePartFile;
	}

	public void setImageNamePartFile(List<MultipartFile> imageNamePartFile) {
		this.imageNamePartFile = imageNamePartFile;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAdvertiseType() {
		return advertiseType;
	}

	public void setAdvertiseType(Integer advertiseType) {
		this.advertiseType = advertiseType;
	}

	public String getAdvertiseTitle() {
		return advertiseTitle;
	}

	public void setAdvertiseTitle(String advertiseTitle) {
		this.advertiseTitle = advertiseTitle;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getSxTime() {
		return sxTime;
	}

	public void setSxTime(Date sxTime) {
		this.sxTime = sxTime;
	}

	public Date getOverTime() {
		return overTime;
	}

	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}

	public Date getStopTime() {
		return stopTime;
	}

	public void setStopTime(Date stopTime) {
		this.stopTime = stopTime;
	}

	public Date getTfTimeBeg() {
		return tfTimeBeg;
	}

	public void setTfTimeBeg(Date tfTimeBeg) {
		this.tfTimeBeg = tfTimeBeg;
	}

	public Date getTfTimeEnd() {
		return tfTimeEnd;
	}

	public void setTfTimeEnd(Date tfTimeEnd) {
		this.tfTimeEnd = tfTimeEnd;
	}

	public Integer getAdvertiseStatus() {
		return advertiseStatus;
	}

	public void setAdvertiseStatus(Integer advertiseStatus) {
		this.advertiseStatus = advertiseStatus;
	}

	public String getAdvertiseUrl() {
		return advertiseUrl;
	}

	public void setAdvertiseUrl(String advertiseUrl) {
		this.advertiseUrl = advertiseUrl;
	}

	public Integer getAdPoints() {
		return adPoints;
	}

	public void setAdPoints(Integer adPoints) {
		this.adPoints = adPoints;
	}

	public Integer getAdDuration() {
		return adDuration;
	}

	public void setAdDuration(Integer adDuration) {
		this.adDuration = adDuration;
	}

	public Integer getLeastTime() {
		return leastTime;
	}

	public void setLeastTime(Integer leastTime) {
		this.leastTime = leastTime;
	}

	public Integer getIsQzts() {
		return isQzts;
	}

	public void setIsQzts(Integer isQzts) {
		this.isQzts = isQzts;
	}

	public BigDecimal getAdvertiseAmount() {
		return advertiseAmount;
	}

	public void setAdvertiseAmount(BigDecimal advertiseAmount) {
		this.advertiseAmount = advertiseAmount;
	}

	public String getAdvertiseuserName() {
		return advertiseuserName;
	}

	public void setAdvertiseuserName(String advertiseuserName) {
		this.advertiseuserName = advertiseuserName;
	}

	public Integer getClickNum() {
		return clickNum;
	}

	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}

	public Integer getContenttype() {
		return contenttype;
	}

	public void setContenttype(Integer contenttype) {
		this.contenttype = contenttype;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

}