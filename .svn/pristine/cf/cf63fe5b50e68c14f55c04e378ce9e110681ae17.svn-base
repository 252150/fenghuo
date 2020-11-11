package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * (MessPublish)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:45
 */
public class MessPublish {
    
    private Long id;
    /**
    * 标题
    */
    private String title;
    /**
    * 图片
    */
    private String messImage;
    /**
    * 视频
    */
    private String messVidio;
    /**
    * 发布用户
    */
    private Long userId;
    /**
    * 商品id
    */
    private Long goodsId;
    /**
    * 信息内容
    */
    private String messText;
    /**
    *企业公告等级（1、普通信息，2、紧急信息）
    */
    private Integer messSortGrade;
    /**
    * 创建时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
    * 状态；1:已发布；0:草稿箱
    */
    private Integer messState;
    /**
    * 信息类型；1:图文；0:视频
    */
    private Integer messType;
    /**
    * 浏览奖励积分
    */
    private Integer messLljf;
    /**
    * 点赞数量
    */
    private Integer messCount;
    /**
    * 收藏量
    */
    private Integer messCollect;
    /**
    *  可见范围: 0：所有平台用户可见；1：到信息用户关联表去查询哪些人可见
    */
    private Integer messScope;
    /**
    * 查阅人(企业级用户发布信息的查阅者中的下级人)
    */
    private Long messRefer;
    /**
    * 信息分类id
    */
    private Long messTypeId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date overTime;
     /**
      * 经度
      */
     private String longitude ;
     /**
      * 纬度
      */
     private String latitude;
     /**
      * 半径
      */
     private String radius;
     public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}



	/**
      * 管理员id
      */
     private Long admin;
     /**
      * 图片文件集合
      */
     private List<MultipartFile> files;
     /**
      * 视频文件
      */
     private MultipartFile file;
     /**
      * 分页
      */
     private Integer pageNo;
     /**
      * 过期 0：未过期1：已过期
      */
     private Integer overTimeType;
     /**
      * 系统用户名
      */
     private String adminAccountName;
     
    public String getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = radius;
	}

	public String getAdminAccountName() {
		return adminAccountName;
	}

	public void setAdminAccountName(String adminAccountName) {
		this.adminAccountName = adminAccountName;
	}

	public Integer getOverTimeType() {
		return overTimeType;
	}

	public void setOverTimeType(Integer overTimeType) {
		this.overTimeType = overTimeType;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public Long getAdmin() {
		return admin;
	}

	public void setAdmin(Long admin) {
		this.admin = admin;
	}
  
    



	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}



	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
        
    public String getMessImage() {
        return messImage;
    }

    public void setMessImage(String messImage) {
        this.messImage = messImage;
    }
        
    public String getMessVidio() {
        return messVidio;
    }

    public void setMessVidio(String messVidio) {
        this.messVidio = messVidio;
    }
        
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
        
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
        
    public String getMessText() {
        return messText;
    }

    public void setMessText(String messText) {
        this.messText = messText;
    }
        
    public Integer getMessSortGrade() {
        return messSortGrade;
    }

    public void setMessSortGrade(Integer messSortGrade) {
        this.messSortGrade = messSortGrade;
    }
        
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
        
    public Integer getMessState() {
        return messState;
    }

    public void setMessState(Integer messState) {
        this.messState = messState;
    }
        
    public Integer getMessType() {
        return messType;
    }

    public void setMessType(Integer messType) {
        this.messType = messType;
    }
        
    public Integer getMessLljf() {
        return messLljf;
    }

    public void setMessLljf(Integer messLljf) {
        this.messLljf = messLljf;
    }
        
    public Integer getMessCount() {
        return messCount;
    }

    public void setMessCount(Integer messCount) {
        this.messCount = messCount;
    }
        
    public Integer getMessCollect() {
        return messCollect;
    }

    public void setMessCollect(Integer messCollect) {
        this.messCollect = messCollect;
    }
        
    public Integer getMessScope() {
        return messScope;
    }

    public void setMessScope(Integer messScope) {
        this.messScope = messScope;
    }
        
    public Long getMessRefer() {
        return messRefer;
    }

    public void setMessRefer(Long messRefer) {
        this.messRefer = messRefer;
    }
        
    public Long getMessTypeId() {
        return messTypeId;
    }

    public void setMessTypeId(Long messTypeId) {
        this.messTypeId = messTypeId;
    }
        
    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

}