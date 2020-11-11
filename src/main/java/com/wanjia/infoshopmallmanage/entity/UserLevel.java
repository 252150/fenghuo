package com.wanjia.infoshopmallmanage.entity;


/**
 * (UserLevel)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:46
 */
public class UserLevel {
    
    public UserLevel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserLevel(Integer level, String levelName, Integer requireScore, String remarks) {
		super();
		this.level = level;
		this.levelName = levelName;
		this.requireScore = requireScore;
		this.remarks = remarks;
	}

	public UserLevel(Long id, String levelName, Integer requireScore, String remarks) {
		super();
		this.id = id;
		this.levelName = levelName;
		this.requireScore = requireScore;
		this.remarks = remarks;
	}

	private Long id;
    /**
    * 等级(数)
    */
    private Integer level;
    /**
    * 等级名称
    */
    private String levelName;
    /**
    * 积分需求
    */
    private Integer requireScore;
    /**
    * 等级描述
    */
    private String remarks;

        
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
        
    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
        
    public Integer getRequireScore() {
        return requireScore;
    }

    public void setRequireScore(Integer requireScore) {
        this.requireScore = requireScore;
    }
        
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}