package com.wanjia.infoshopmallmanage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanjia.infoshopmallmanage.entity.Admin;
import com.wanjia.infoshopmallmanage.entity.MessPublish;
import com.wanjia.infoshopmallmanage.entity.User;
import com.wanjia.infoshopmallmanage.mapper.AdminMapper;
import com.wanjia.infoshopmallmanage.mapper.MessPublishMapper;
import com.wanjia.infoshopmallmanage.mapper.UserMapper;
import com.wanjia.infoshopmallmanage.util.DateUtils;
import com.wanjia.infoshopmallmanage.util.FileUtil;
import com.wanjia.infoshopmallmanage.util.FileuploadUtil;
import com.wanjia.infoshopmallmanage.util.RestResponse;
import com.wanjia.infoshopmallmanage.util.StringUtil;

@Service
public class MessPublishService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private FileuploadUtil fileuploadUtil;
	@Autowired
	private MessPublishMapper messPublishMapper;
     @Autowired
	private JPushService jPushService; 
	/**
	 * 平台消息新增
	 * @param mp
	 * @return
	 */
	public RestResponse add(MessPublish mp) {
		 if(mp.getOverTime()==null)return RestResponse.fail("没有过期时间");
    	 //找出用户信息
    	 Admin  admin=	adminMapper.queryBysId(mp.getAdmin());
    	 User user= new User();
    	 if(admin.getUserId()!=null) {
 	      user= 	userMapper.queryById(admin.getUserId());
 	    if(StringUtil.isNotEmpty(user)) {
 	    	mp.setUserId(admin.getUserId());
 	    	
 	    }
    	 }else{
    		 user.setUsername(admin.getAdminAccount());
  	    	user.setUserRole(0);
    	 }
        mp.setAdmin(admin.getId());
 	    mp.setMessState(1);
 	    mp.setCreateTime(DateUtils.currentTime());
 	    System.out.println(user.getUserRole());
 	    //判断是不是平台用户
 	   if(user.getUserRole()!=3&&admin.getUserId()!=null)return RestResponse.fail("您不是平台用户无法发送平台消息");

 	    if(mp.getMessType()==1) {
 	    //批量新增图片
 			List<MultipartFile> list=mp.getFiles();
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
 	      	mp.setMessImage(fileuploadUtil.batchFileUpload(mp.getFiles(), user.getUsername()))	;
 	      	}
 	    	
 	    }
 	   
 	int num=   messPublishMapper.insert(mp);
 	jPushService.sendToAllAndroid("消息通知", mp.getTitle(), mp.getMessText(), "附件");
 	return num>0?RestResponse.ok("新增成功"):RestResponse.fail("新增失败");
     }
    /**
     * 消息修改
     * @param mp 消息修改成功
     * @return
     */
	public RestResponse update(MessPublish mp) {
		mp.setMessState(1);
    	 //找出用户信息
    	 Admin  admin=	adminMapper.queryBysId(mp.getAdmin());
 	    
   	 User user= new User();
   	 if(admin.getUserId()!=null) {
	      user= 	userMapper.queryById(admin.getUserId());
	    if(StringUtil.isNotEmpty(user)) {
	    	mp.setUserId(admin.getUserId());
	    	
	    }
   	 }else{
		 user.setUsername(admin.getAdminAccount());
	    	user.setUserRole(0);
 	 }
 	    mp.setCreateTime(DateUtils.currentTime());
 	   mp.setAdmin(admin.getId());
 	    //判断用户是不是平台用户
 	   if(user.getUserRole()!=3&&admin.getUserId()!=null)return RestResponse.fail("您不是平台用户无法发送平台消息");
 	   //找出要修改的消息
 	   MessPublish messPublish=messPublishMapper.queryById(mp.getId());
 	   //删除图片
 	    if(mp.getMessImage()!=null&&!"".equals(mp.getMessImage())) {
 	    	String []imgs=mp.getMessImage().split(",");
 	    	for (int i = 0; i < imgs.length; i++) {
 	    		fileuploadUtil.removeFile(imgs[i]);
			}
 	    }
 	   String fileImage="";
 	   
         
         if(mp.getMessImage()!=null&&!"".equals(mp.getMessImage())) {
        	 String []images=mp.getMessImage().split(",");
        	 if(messPublish.getMessImage()!=null&&!"".equals(messPublish.getMessImage())) {
        		 String []images1=messPublish.getMessImage().split(",");
        		 fileImage= FileUtil.fileImages(images1,images );
        		 System.out.println(fileImage);
        	 }
         }else {
        	 fileImage= messPublish.getMessImage()+",";
         }
 	    if(mp.getMessType()==1) {
 	    //批量新增图片
 			List<MultipartFile> list=mp.getFiles();
 	      	//判断文件集合里是否有文件
 	      	if(list!=null&&list.size()>0) {
 	      	int []filenum1=new int[list.size()];
 	      	for (int i=0;i<list.size();i++) {
 	      		MultipartFile multipartFile2=list.get(i);
 	      		//找到文件是否合法
 	      		filenum1 [i]=multipartFile2.getOriginalFilename().indexOf(".");
 	      		//如果不合法就删除
 	      		if(filenum1 [i]==-1)list.remove(i);
 	      		mp.setMessVidio(null);
 	  		}
 	      	mp.setMessImage(fileImage+fileuploadUtil.batchFileUpload(list, user.getUsername()))	;
 	      	}else {
 	      		mp.setMessImage(fileImage);
 	      	}
 	      	
 	    	
 	    }else {
       	 if(messPublish.getMessImage()!=null&&!"".equals(messPublish.getMessImage())) {
    		 String []images1=messPublish.getMessImage().split(",");
    		for (int i = 0; i < images1.length; i++) {
				String string = images1[i];
				fileuploadUtil.removeFile(string);
			}
    	 }
       	 
       	mp.setMessImage(null);
	      		
	      	}
 	   int num=   messPublishMapper.update(mp);
 	  jPushService.sendToAllAndroid("消息通知", mp.getTitle(), mp.getMessText(), "附件");
 	   return num>0 ?RestResponse.ok("消息修改成功"):RestResponse.fail("消息修改失败");
     }
	/**
	 * 消息删除
	 * @param adminId 管理员id
	 * @param id      删除id
	 * @return
	 */
	public RestResponse delete(Long adminId,Long id) {
		 Admin  admin=	adminMapper.queryBysId(adminId);
		 System.out.println(id);
	   	 User user= new User();
	   	 if(admin.getUserId()!=null) {
		      user= 	userMapper.queryById(admin.getUserId());
		    if(StringUtil.isNotEmpty(user)) {
		    	admin.setUserId(admin.getUserId());
		    	
		    }
	   	 }
	   	else{
   		 user.setUsername(admin.getAdminAccountName());
 	    	user.setUserRole(0);
   	 }
 	    //判断用户是不是平台用户
 	   if(user.getUserRole()!=3&&admin.getUserId()!=null)return RestResponse.fail("您不是平台用户无法发送平台消息");
 	   //找出要修改的消息
 	   MessPublish messPublish=messPublishMapper.queryById(id);
 	   //删除图片
 	    if(messPublish.getMessImage()!=null&&!"".equals(messPublish.getMessImage())) {
 	    	String []imgs=messPublish.getMessImage().split(",");
 	    	for (int i = 0; i < imgs.length; i++) {
 	    		fileuploadUtil.removeFile(imgs[i]);
			}
 	    }
 	   if(messPublish.getMessVidio()!=null&&!"".equals(messPublish.getMessVidio())) fileuploadUtil.removeFile(messPublish.getMessVidio());
 	   int num=messPublishMapper.deleteById(id);
 	  return num>0?RestResponse.ok("删除成功"):RestResponse.fail("删除失败");
 	   
	}
	/**
	 * 平台消息获取
	 * @param mp
	 * @return
	 */
	public RestResponse list(MessPublish mp) {
		PageHelper.startPage(mp.getPageNo(),20);
		//找出用户信息
   	    Admin  admin=	adminMapper.queryById(mp.getAdmin());
   	 User user=    new User();
   	    if(admin.getUserId()!=null) {
   	 user =	userMapper.queryById(admin.getUserId());
   	    }else {
   	    	user.setUserRole(0);
   	    }
	   
	    List<MessPublish> list=new ArrayList<MessPublish>();
	    //判断是平台用户或者是系统用户
	    if(user.getUserRole()!=3&&admin.getUserId()!=null)return RestResponse.fail("您不是平台用户，也不是系统用户");
	    mp.setUserId(user.getId());
	    mp.setOverTime(DateUtils.currentTime());
	    if(user.getUserRole()==3) {
	    	//平台消息
	    	list=  messPublishMapper.queryAll(mp);
	    	 PageInfo<MessPublish> page = new PageInfo<MessPublish>(list);
	    	 return RestResponse.ok("获取成功", page);
	    } else {
	    	//系统消息
	    	list=	messPublishMapper.queryAllAdmin(mp);
	    	PageInfo<MessPublish> page = new PageInfo<MessPublish>(list);
	    	 return RestResponse.ok("获取成功", page);
	    } 	    
	}
}
