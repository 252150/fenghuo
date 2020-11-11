package com.wanjia.infoshopmallmanage.entity;

/**
 * (AddressContact)实体类
 *
 * @author: wlj
 * @date: 2020-11-06 10:39:24
 */
public class AddressContact {

	private Long id;
	/**
	 * 广告名
	 */
	private String addressName;
	/**
	 * 联系电话
	 */
	private String addressPhone;

	private Long userId;
	/**
	 * 广告联系0：未联系，1：已联系*
	 */
	private Integer isContact;
	/**
	 * 分页
	 */
	private Integer pageNo;
	/**
	 * 联系人昵称
	 */
	private String nickname;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	public String getAddressPhone() {
		return addressPhone;
	}

	public void setAddressPhone(String addressPhone) {
		this.addressPhone = addressPhone;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getIsContact() {
		return isContact;
	}

	public void setIsContact(Integer isContact) {
		this.isContact = isContact;
	}

}