package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;

/**
 * (User)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:45
 */
public class User {
    
    private Long id;
    /**
    * 用户名
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 手机
    */
    private String phone;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 性别：女：0；男：1
    */
    private Integer sex;
    /**
    * 用户状态：有效：1; 禁用：0
    */
    private Integer status;
    /**
    * 年龄
    */
    private Integer age;
    /**
    * 昵称
    */
    private String nickname;
    /**
    * 注册时间
    */
    private Date regTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    /**
    * 最后登录时间
    */
    private Date lastLoginTime;
    /**
    * 用户角色：个人：0；商户：1；企业：2；平台：3
    */
    private Integer userRole;
    /**
    * 是否广告用户 0：否，1：是
    */
    private Integer isAdvertise;
    /**
    * 累计积分
    */
    private Object cumulativeScore;
    /**
    * 剩余积分
    */
    private Object leftoverScore;
    /**
    * 关注的信息分类id(多个分类id以”,”为分隔符)
    */
    private String attentionMessSortTypeIds;
    /**
    * 用户等级ID
    */
    private Long userLevelId;
    /**
    * 点赞量
    */
    private Integer bingoNum;
    /**
    * 微信的openid
    */
    private String openId;
    /**
    * 微信昵称
    */
    private String wxNickname;
    /**
    * 用户头像
    */
    private String userHeadImage;
    /**
    * 背景图
    */
    private String bgImage;
    /**
    * 出生日期
    */
    private Object birthDate;
    /**
    * 推荐人的 user_id
    */
    private String recommendPersonId;
    /**
    * 推荐码
    */
    private String recommendCode;
    /**
    * 经度
    */
    private String longitude;
    /**
    * 纬度
    */
    private String latitude;
    /**
    * 最近登陆地点
    */
    private String lastLoginRegion;
    /**
    * 地区
    */
    private String location;
    /**
    * 聊天背景
    */
    private String chatImg;
    /**
    * 是否有创建推广群的权限 0: 否； 1:是
    */
    private Integer isGroud;
    /**
    * 个性签名
    */
    private String signature;
    /**
    * 收藏是否可见 0:否 1:是
    */
    private Integer isCollectVisible;
    /**
    * 是否能发长视频(30秒以内短视频,30秒以外长视频) 0:否 1:是
    */
    private Integer isLongVideo;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
        
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
        
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
        
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
        
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
        
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
        
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
        
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
        
    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }
        
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
        
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
        
    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }
        
    public Integer getIsAdvertise() {
        return isAdvertise;
    }

    public void setIsAdvertise(Integer isAdvertise) {
        this.isAdvertise = isAdvertise;
    }
        
    public Object getCumulativeScore() {
        return cumulativeScore;
    }

    public void setCumulativeScore(Object cumulativeScore) {
        this.cumulativeScore = cumulativeScore;
    }
        
    public Object getLeftoverScore() {
        return leftoverScore;
    }

    public void setLeftoverScore(Object leftoverScore) {
        this.leftoverScore = leftoverScore;
    }
        
    public String getAttentionMessSortTypeIds() {
        return attentionMessSortTypeIds;
    }

    public void setAttentionMessSortTypeIds(String attentionMessSortTypeIds) {
        this.attentionMessSortTypeIds = attentionMessSortTypeIds;
    }
        
    public Long getUserLevelId() {
        return userLevelId;
    }

    public void setUserLevelId(Long userLevelId) {
        this.userLevelId = userLevelId;
    }
        
    public Integer getBingoNum() {
        return bingoNum;
    }

    public void setBingoNum(Integer bingoNum) {
        this.bingoNum = bingoNum;
    }
        
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
        
    public String getWxNickname() {
        return wxNickname;
    }

    public void setWxNickname(String wxNickname) {
        this.wxNickname = wxNickname;
    }
        
    public String getUserHeadImage() {
        return userHeadImage;
    }

    public void setUserHeadImage(String userHeadImage) {
        this.userHeadImage = userHeadImage;
    }
        
    public String getBgImage() {
        return bgImage;
    }

    public void setBgImage(String bgImage) {
        this.bgImage = bgImage;
    }
        
    public Object getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Object birthDate) {
        this.birthDate = birthDate;
    }
        
    public String getRecommendPersonId() {
        return recommendPersonId;
    }

    public void setRecommendPersonId(String recommendPersonId) {
        this.recommendPersonId = recommendPersonId;
    }
        
    public String getRecommendCode() {
        return recommendCode;
    }

    public void setRecommendCode(String recommendCode) {
        this.recommendCode = recommendCode;
    }
        
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
        
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
        
    public String getLastLoginRegion() {
        return lastLoginRegion;
    }

    public void setLastLoginRegion(String lastLoginRegion) {
        this.lastLoginRegion = lastLoginRegion;
    }
        
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
        
    public String getChatImg() {
        return chatImg;
    }

    public void setChatImg(String chatImg) {
        this.chatImg = chatImg;
    }
        
    public Integer getIsGroud() {
        return isGroud;
    }

    public void setIsGroud(Integer isGroud) {
        this.isGroud = isGroud;
    }
        
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
        
    public Integer getIsCollectVisible() {
        return isCollectVisible;
    }

    public void setIsCollectVisible(Integer isCollectVisible) {
        this.isCollectVisible = isCollectVisible;
    }
        
    public Integer getIsLongVideo() {
        return isLongVideo;
    }

    public void setIsLongVideo(Integer isLongVideo) {
        this.isLongVideo = isLongVideo;
    }

}