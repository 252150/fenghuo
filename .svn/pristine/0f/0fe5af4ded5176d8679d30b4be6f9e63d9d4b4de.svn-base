package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;

/**
 * (CommentReply)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:44
 */
public class CommentReply {
    
    private Long id;
    /**
    * 被评论id(帖子)
    */
    private Long commentedId;
    /**
    * 评论用户id
    */
    private Long commentUserId;
    /**
    * 被评论用户id
    */
    private Long commentedUserId;
    /**
    * 回复内容
    */
    private String commentReplyContent;
    /**
    * 回复时间
    */
    private Date commentReplyTime;
    /**
    * 是否与管理员有关系: 0:否；1：是
    */
    private Integer isAdminRelation;
    /**
    * 由评论用户id，被评论用户id按规则组合，组合方式为：minid-maxid (minid、maxid分别为评论用户id，被评论用户id中的较小值和较大值)
    */
    private String onlyValue;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Long getCommentedId() {
        return commentedId;
    }

    public void setCommentedId(Long commentedId) {
        this.commentedId = commentedId;
    }
        
    public Long getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Long commentUserId) {
        this.commentUserId = commentUserId;
    }
        
    public Long getCommentedUserId() {
        return commentedUserId;
    }

    public void setCommentedUserId(Long commentedUserId) {
        this.commentedUserId = commentedUserId;
    }
        
    public String getCommentReplyContent() {
        return commentReplyContent;
    }

    public void setCommentReplyContent(String commentReplyContent) {
        this.commentReplyContent = commentReplyContent;
    }
        
    public Date getCommentReplyTime() {
        return commentReplyTime;
    }

    public void setCommentReplyTime(Date commentReplyTime) {
        this.commentReplyTime = commentReplyTime;
    }
        
    public Integer getIsAdminRelation() {
        return isAdminRelation;
    }

    public void setIsAdminRelation(Integer isAdminRelation) {
        this.isAdminRelation = isAdminRelation;
    }
        
    public String getOnlyValue() {
        return onlyValue;
    }

    public void setOnlyValue(String onlyValue) {
        this.onlyValue = onlyValue;
    }

}