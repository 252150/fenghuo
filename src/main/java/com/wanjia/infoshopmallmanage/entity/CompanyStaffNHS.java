package com.wanjia.infoshopmallmanage.entity;

/**
 * 	冗余了员工昵称、员工头像、员工个性签名的员工实体类
 *
 */ 
public class CompanyStaffNHS extends CompanyStaff{
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUserHeadImage() {
		return userHeadImage;
	}
	public void setUserHeadImage(String userHeadImage) {
		this.userHeadImage = userHeadImage;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String nickname;
	public String userHeadImage;
	public String signature;
}
