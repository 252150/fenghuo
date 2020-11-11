package com.wanjia.infoshopmallmanage.entity;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * (Warningmsg)实体类
 *
 * @author: wlj
 * @date: 2020-09-27 13:33:46
 */
public class Warningmsg {
    
    private Long id;
    /**
    * 管理员id
    */
    private Long adminId;
    /**
    * 图片
    */
    private String messImage;
    /**
     * 修改删除时用
     */
    private String removeMessImage;
    /**
    * 视频
    */
    private String messVidio;
    /**
    * 预警内容
    */
    private String warningContent;
    /**
    * 创建时间
    */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
    * 经度
    */
    private String longitude;
    /**
    * 纬度
    */
    private String latitude;
    /**
    * 半径
    */
    private Integer radius;
    /**
    * 预警类型： 0:地质灾害；1:天气灾害
    */
    private Integer warningType;
    /**
    * 预警等级： 1、2、3、4、5
    */
    private Integer warningLevel;
    /**
     * 灾害标题
     */
    private String title;
    private Integer isPush;
    private List<MultipartFile> messImageMultipartFile;
    private MultipartFile messVidioMultipartFile;
    /**
     * 分页
     */
    private Integer pageNo;
    
    private String adminUser;
    
	public String getRemoveMessImage() {
		return removeMessImage;
	}

	public void setRemoveMessImage(String removeMessImage) {
		this.removeMessImage = removeMessImage;
	}

	public String getAdminUser() {
		return adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getIsPush() {
		return isPush;
	}

	public void setIsPush(Integer isPush) {
		this.isPush = isPush;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public List<MultipartFile> getMessImageMultipartFile() {
		return messImageMultipartFile;
	}

	public void setMessImageMultipartFile(List<MultipartFile> messImageMultipartFile) {
		this.messImageMultipartFile = messImageMultipartFile;
	}

	public MultipartFile getMessVidioMultipartFile() {
		return messVidioMultipartFile;
	}

	public void setMessVidioMultipartFile(MultipartFile messVidioMultipartFile) {
		this.messVidioMultipartFile = messVidioMultipartFile;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
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
        
    public String getWarningContent() {
        return warningContent;
    }

    public void setWarningContent(String warningContent) {
        this.warningContent = warningContent;
    }
        
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        
    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }
        
    public Integer getWarningType() {
        return warningType;
    }

    public void setWarningType(Integer warningType) {
        this.warningType = warningType;
    }
        
    public Integer getWarningLevel() {
        return warningLevel;
    }

    public void setWarningLevel(Integer warningLevel) {
        this.warningLevel = warningLevel;
    }

}