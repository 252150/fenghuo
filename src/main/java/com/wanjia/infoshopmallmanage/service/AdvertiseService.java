package com.wanjia.infoshopmallmanage.service;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanjia.infoshopmallmanage.entity.Admin;
import com.wanjia.infoshopmallmanage.entity.Advertise;
import com.wanjia.infoshopmallmanage.entity.User;
import com.wanjia.infoshopmallmanage.mapper.AdminMapper;
import com.wanjia.infoshopmallmanage.mapper.AdvertiseMapper;
import com.wanjia.infoshopmallmanage.mapper.AdvertiseUserMapper;
import com.wanjia.infoshopmallmanage.mapper.UserLevelMapper;
import com.wanjia.infoshopmallmanage.mapper.UserMapper;
import com.wanjia.infoshopmallmanage.util.DateUtils;
import com.wanjia.infoshopmallmanage.util.FileUtil;
import com.wanjia.infoshopmallmanage.util.FileuploadUtil;
import com.wanjia.infoshopmallmanage.util.RestResponse;
import com.wanjia.infoshopmallmanage.util.StringUtil;

/**
 * 广告发布接口
 * @author 吉俊海
 *
 */
@Service
public class AdvertiseService {
	@Autowired
	private AdvertiseMapper advertiseMapper;
	@Autowired
	private FileuploadUtil  fileuploadUtil;
	@Autowired
	private AdvertiseUserMapper advertiseUserMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
    private AdminMapper adminMapper;
	@Autowired
	private UserLevelMapper userLevelMapper;
	@SuppressWarnings({ "null", "unused" })

	/**
	 * 
	 * @param advertise 实体类
	 * @param multipartFile 文件上传
	 * @return RestResponse 封装类
	 */
      public RestResponse add(Advertise advertise,MultipartFile multipartFile) {
		Admin  admin=	adminMapper.queryBysId(advertise.getAdminId());
		advertise.setUserId(admin.getId());
        System.out.println(advertise.getContenttype());
          //获取当前时间
    	  advertise.setCreateTime(DateUtils.currentTime());
    	  //log上传
    	  //上传广告文件
    	  int filenum=1;
    	  if(multipartFile!=null&& multipartFile.getOriginalFilename()!=null&&!"".equals(multipartFile.getOriginalFilename()))
    		  filenum	=  multipartFile.getOriginalFilename().lastIndexOf(".");
    	
      	List<MultipartFile>list =advertise.getImageNamePartFile();
      	//判断文件集合里是否有文件
      	if(list!=null&&list.size()>0) {
      	int []filenum1=new int[list.size()];
      	for (int i=0;i<list.size();i++) {
      		MultipartFile multipartFile2=list.get(i);
      		//找到文件是否合法
      		filenum1 [i]=multipartFile2.getOriginalFilename().indexOf(".");
      		//如果不合法就删除
      		if(filenum1 [i]==-1)list.remove(i);
  		}
      	advertise.setImageName( fileuploadUtil.batchFileUpload(advertise.getImageNamePartFile(),admin.getAdminAccount()));
      	}
    	
		
    	 
    	if (filenum!=-1)    advertise.setIcon(fileuploadUtil.fileUpload(multipartFile,admin.getAdminAccount()));
		
    	  //新增
    	int num=  advertiseMapper.insert(advertise);
    	if(num>0) {
    	return	RestResponse.ok("新增成功");
    	}else {
    	return RestResponse.ok("新增失败,服务器问题");
    	}
      }
     /**
      * 修改广告服务
      * @param advertise 广告修改
      * @param multipartFile 广告文件
      * @return
      */
      public RestResponse update (Advertise advertise,MultipartFile multipartFile) {
    	  
    		Admin  admin=	adminMapper.queryBysId(advertise.getAdminId());
    	  if(StringUtil.isNotEmpty(admin)) advertise.setUserId(admin.getUserId());
    	  Advertise a=    advertiseMapper.queryById(advertise.getId());
    	  //判断是否有这条广告
          if(advertise.getId()==null) {
        	return  RestResponse.fail  ("请选中修改的信息");
          }
          String fileImages="";
          //判断文件是否有有则删除
          if(multipartFile!=null&&advertise.getImageName()!=null&&"".equals(advertise.getImageName())) {
        	  String []images=advertise.getImageName().split(",");
        	  for (int i = 0; i < images.length; i++) {
				String string = images[i];
				 fileuploadUtil.removeFile(fileuploadUtil.fileName(string));
			}
        	 
          }
          //组装文件
          if(advertise.getImageName()!=null&&!"".equals(advertise.getImageName())) {
        	  String []images=advertise.getImageName().split(",");
        	  System.out.print(advertise.getImageName());
        	  if(a.getImageName()!=null&&!"".equals(a.getImageName())) {
        		  String []images1=a.getImageName().split(",");
        		 
            	  fileImages=FileUtil.fileImages(images1, images);
        	  }
        	  
          }
          else {
        	 
        	  fileImages=a.getImageName()+",";  
          }
          //判断log是否有有则删除
    	  if(a.getIcon()!=null&&!"".equals(a.getIcon())) {
  
    		fileuploadUtil.removeFile(fileuploadUtil.fileName(a.getIcon()))  ;
    	  }
    	 
    	  int filenum=1;
    	  if(multipartFile!=null&&multipartFile.getOriginalFilename()!=null&&!"".equals(multipartFile.getOriginalFilename()))
    		  filenum	=  multipartFile.getOriginalFilename().lastIndexOf(".");
    	
      	List<MultipartFile>list =advertise.getImageNamePartFile();
      	//判断文件集合里是否有文件
      	if(list!=null&&list.size()>0) {
      	int []filenum1=new int[list.size()];
      	for (int i=0;i<list.size();i++) {
      		MultipartFile multipartFile2=list.get(i);
      		//找到文件是否合法
      		filenum1 [i]=multipartFile2.getOriginalFilename().indexOf(".");
      		//如果不合法就删除
      		if(filenum1 [i]==-1)list.remove(i);
  		}
      	System.out.println(list);
    	advertise.setImageName(fileImages+ fileuploadUtil.batchFileUpload(list,admin.getAdminAccount()));
      	}else {
      		advertise.setImageName(fileImages);
      		
      	}
      	 //上传广告文件
      
  		
      	 //上传广告log
      	if (filenum!=-1)    advertise.setIcon(fileuploadUtil.fileUpload(multipartFile,admin.getAdminAccount()));
  	
    	  //修改广告信息
    	  int num=  advertiseMapper.update(advertise);
    	  if(num>0) {
    	    	return	RestResponse.ok("修改成功");
    	    	}else {
    	    	return RestResponse.fail("修改失败,服务器问题");
    	    	} 
      }
      /**
       * 广告删除
       * @param id 删除id
       * @param userName 用户名
       * @return
       */
      
       public RestResponse delete(Long id) {

    	   Advertise a=    advertiseMapper.queryById(id);
    	   //删除广告log
     	  if(a.getIcon()!=null||a.getIcon()!="") {
     		  
      		fileuploadUtil.removeFile(fileuploadUtil.fileName(a.getIcon()))  ;
      	  }
     	 //删除广告图片
     	  if(a.getImageName()!=null||a.getImageName()!="") {
     		 fileuploadUtil.removeFile(fileuploadUtil.fileName(a.getImageName()))  ;
     	  }
     	  advertiseUserMapper.deleteById(id);
      	  int num=  advertiseMapper.deleteById(id);
      	  if(num>0) {
      	    	return	RestResponse.ok("删除成功");
      	    	}else {
      	    	return RestResponse.fail("删除失败,服务器问题");
      	    	} 
      }
       /**
        * 广告集合获取
        * @param advertise 实体类
        * @param pageNo 当前页码 
        * @return
        */
        public RestResponse selectState(Advertise advertise,Integer pageNo) {
        	PageHelper.startPage(pageNo,20); 
        	advertise.setCreateTime(DateUtils.currentTime());
        	List<Advertise> list=	advertiseMapper.queryAll(advertise);
   		    PageInfo<Advertise> page = new PageInfo<Advertise>(list);
   		return RestResponse.ok("获取成功", page);
        }
        /**
         * 状态修改
         * @param advertise 实体类
         * @return
         */
        public RestResponse updateState(Advertise advertise) {
        int num=	advertiseMapper.update(advertise);
        return num>0?RestResponse.ok("审核成功"):RestResponse.fail("审核失败");
        }
        /**
         * 积分给定
         * @param advertise
         * @return
         */
        public RestResponse updateLise(Integer adPoints,Long id) {
        int num=	advertiseMapper.updateadPoints(adPoints, id);
        return num>0?RestResponse.ok("积分给定成功"):RestResponse.fail("积分给定失败");
        }
    
}

