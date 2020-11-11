package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;

/**
 * (GroupMembers)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:44
 */
public class GroupMembers {
    
    private Long id;
    /**
    * 群id
    */
    private Long groupId;
    /**
    * 成员id
    */
    private Long memberId;
    /**
    * 成员名称
    */
    private String memberName;
    /**
    * 成员头像
    */
    private String menberHeadPortrait;
    /**
    * 免打扰状态； 0：否；1：是
    */
    private Integer noDisturbState;
    /**
    * 是否消息置顶状态 0：否；1：是
    */
    private Integer noTopState;
    /**
    * 是否强提醒状态 0：否；1：是
    */
    private Integer noRemindState;
    /**
    * 群昵称
    */
    private String groupNickname;
    /**
    * 进群时间
    */
    private Date enterGroupTime;
    /**
    * 群备注
    */
    private String groupRemarks;
    /**
    * 聊天背景
    */
    private String groupImg;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
        
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
        
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
        
    public String getMenberHeadPortrait() {
        return menberHeadPortrait;
    }

    public void setMenberHeadPortrait(String menberHeadPortrait) {
        this.menberHeadPortrait = menberHeadPortrait;
    }
        
    public Integer getNoDisturbState() {
        return noDisturbState;
    }

    public void setNoDisturbState(Integer noDisturbState) {
        this.noDisturbState = noDisturbState;
    }
        
    public Integer getNoTopState() {
        return noTopState;
    }

    public void setNoTopState(Integer noTopState) {
        this.noTopState = noTopState;
    }
        
    public Integer getNoRemindState() {
        return noRemindState;
    }

    public void setNoRemindState(Integer noRemindState) {
        this.noRemindState = noRemindState;
    }
        
    public String getGroupNickname() {
        return groupNickname;
    }

    public void setGroupNickname(String groupNickname) {
        this.groupNickname = groupNickname;
    }
        
    public Date getEnterGroupTime() {
        return enterGroupTime;
    }

    public void setEnterGroupTime(Date enterGroupTime) {
        this.enterGroupTime = enterGroupTime;
    }
        
    public String getGroupRemarks() {
        return groupRemarks;
    }

    public void setGroupRemarks(String groupRemarks) {
        this.groupRemarks = groupRemarks;
    }
        
    public String getGroupImg() {
        return groupImg;
    }

    public void setGroupImg(String groupImg) {
        this.groupImg = groupImg;
    }

}