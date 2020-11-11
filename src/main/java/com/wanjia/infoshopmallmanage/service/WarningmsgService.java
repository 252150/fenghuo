package com.wanjia.infoshopmallmanage.service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.wanjia.infoshopmallmanage.entity.Admin;
import com.wanjia.infoshopmallmanage.entity.UploadDto;
import com.wanjia.infoshopmallmanage.entity.User;
import com.wanjia.infoshopmallmanage.entity.Warningmsg;
import com.wanjia.infoshopmallmanage.mapper.AdminMapper;
import com.wanjia.infoshopmallmanage.mapper.UserMapper;
import com.wanjia.infoshopmallmanage.mapper.WarningmsgMapper;
import com.wanjia.infoshopmallmanage.util.DateUtils;
import com.wanjia.infoshopmallmanage.util.FileuploadUtil;
import com.wanjia.infoshopmallmanage.util.RestResponse;
import com.wanjia.infoshopmallmanage.util.StringUtil;


@Service
public class WarningmsgService {
	@Autowired
    public WarningmsgMapper warningmsgMapper;
	@Autowired
	public AdminMapper     adminMapper;
	@Autowired
	public FileuploadUtil fileuploadUtil;
	@Autowired
	public UserMapper userMapper;
	@Autowired
	private JPushService jPushService; 
	/**
	 * 灾害信息新增
	 * @param ws 实体类
	 * @param adminId 管理员id
	 * @param userName 当前用户名
	 * @return
	 */
	public RestResponse add(Warningmsg ws, Long adminId) {
		Admin admin=adminMapper.queryBysId(adminId);
	
		ws.setAdminId(adminId);
	     //判断是不是管理员用户
		if(!StringUtil.isNotEmpty(admin))
		{
		return RestResponse.fail("新增失败，该用户不是管理员用户");
		}
		//灾害发生时间
		ws.setCreateTime(DateUtils.currentTime());
		//上传灾害图片
		List<MultipartFile> list=ws.getMessImageMultipartFile();
		
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

      	ws.setMessImage(fileuploadUtil.batchFileUpload(ws.getMessImageMultipartFile(), admin.getAdminAccount()));	
      	}
	
		//组装链接
       
		//新增灾害信息
		int num=warningmsgMapper.insert(ws);
		List<Warningmsg> listws=	warningmsgMapper.queryAllWs(); 
		
		jPushService.sendToAllAndroid(ws.getTitle(),ws.getWarningContent()+"经度："+ws.getLongitude()+"维度："+ws.getLatitude(),listws.get(listws.size()-1).getId()+"",""+ws.getId());
		if(num>0) {
			return RestResponse.ok("新增成功");
		}else {
			return RestResponse.fail("新增失败。服务器问题");
		}

	}
	/**
	 * 修改灾害信息
	 * @param ws 实体类
	 * @param adminId 用户id
	 * @param userName 用户名
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public RestResponse update (Warningmsg ws,Long adminId) {
		
		Admin admin=adminMapper.queryBysId(adminId);
	    
		ws.setAdminId(adminId);

		//根据灾害ID查出信息
		Warningmsg warningmsg=warningmsgMapper.queryById(ws.getId());
		//判断灾害图片是否拥有
	     
		if(ws.getMessImage()!=null&&!"".equals(ws.getMessImage())) {
		
			String []imgs=ws.getMessImage().split(",");

			//删除灾害图片
			for (int i = 0; i < imgs.length; i++) {
				
				fileuploadUtil.removeFile(fileuploadUtil.fileName(imgs[i]));
			}
			

		}
		String messImage="";
		//判断灾害图片是否拥有
		if(warningmsg.getMessImage()!=null&&!"".equals(warningmsg.getMessImage())) {
			 
			String []imgs1=warningmsg.getMessImage().split(",");
		
			//删除灾害图片
			
				if(ws.getMessImage()!=null&&!"".equals(ws.getMessImage())) {
				//匹配灾害图片
					String []imgs=ws.getMessImage().split(",");
					
					List<String> la = new ArrayList(Arrays.asList(imgs1));
              
					List<String> lb = new ArrayList(Arrays.asList(imgs));
				       for(int i=0;i<la.size();i++) {
	                    	 for(int j=0;j<lb.size();j++) {
	                    		 System.out.println(la.get(i).equals(lb.get(j)));
	                    		 if(la.get(i).equals(lb.get(j)))la.remove(i);
	                    	 }
	                     }
					
					if(la!=null&&la.size()>0) {
						for (String string : la) {
							messImage+=string +",";
						}
					}
				}else {
					messImage=warningmsg.getMessImage()+",";
				}
			    

		}
//		//删除视频图片
//		if(warningmsg.getMessVidio()!=null&&!"".equals(warningmsg.getMessVidio())) {
//			fileuploadUtil.removeFile(fileuploadUtil.makeFileName(warningmsg.getMessVidio()));
//		}
		List<MultipartFile> list=ws.getMessImageMultipartFile();
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
      	//组装
      	
      	ws.setMessImage(messImage+fileuploadUtil.batchFileUpload(ws.getMessImageMultipartFile(), admin.getAdminAccount()));	
      	}else {
      		ws.setMessImage(messImage);
      	}
    	
	
	
 
		int num=warningmsgMapper.update(ws);
		jPushService.sendToAllAndroid(ws.getTitle(),ws.getWarningContent()+"经度："+ws.getLongitude()+"维度："+ws.getLatitude(),ws.getId()+"",""+ws.getId());
		return num>0?RestResponse.ok("修改成功"): RestResponse.fail("修改失败。服务器问题");
	}
    /**
     * 灾害消息删除
     * @param adminId 用户id
     * @param id 灾害id
     * @param userName 用户名
     * @return
     */
	public RestResponse delete (Long adminId,Long id ) {
		
		
		Admin admin=adminMapper.queryById(adminId);

		//根据灾害ID查出信息
		Warningmsg warningmsg=warningmsgMapper.queryById(id);
		//判断灾害图片是否拥有
		if(warningmsg.getMessImage()!=null&&!"".equals(warningmsg.getMessImage())) {
		
			String []imgs=warningmsg.getMessImage().split(",");
			//删除灾害图片
			for (int i = 0; i < imgs.length; i++) {
				
				fileuploadUtil.removeFile(fileuploadUtil.fileName(imgs[i]));
			}
			

		}
		//删除视频文件
		if(warningmsg.getMessVidio()!=null&&warningmsg.getMessVidio()!="") {
			fileuploadUtil.removeFile(fileuploadUtil.makeFileName(warningmsg.getMessVidio()));
		}
		//删除信息
		int num=warningmsgMapper.deleteById(id);

		return num>0?RestResponse.ok("删除成功"): RestResponse.fail("删除失败。服务器问题");
	}
	/**
	 * 灾害信息获取
	 * @param userName
	 * @return
	 */
	
	public RestResponse list(Warningmsg ws) {
		PageHelper.startPage(ws.getPageNo(),20);
		Admin admin=adminMapper.queryById(ws.getAdminId());
	     //判断是不是管理员用户
		if(StringUtil.isNotEmpty(admin))
		{
		return RestResponse.fail("获取失败，该用户不是管理员用户");
		}
		//返回集合
		List<Warningmsg> list=	warningmsgMapper.queryAll(ws);
		PageInfo<Warningmsg> page = new PageInfo<Warningmsg>(list);
		return RestResponse.ok("获取成功",page);
	}

}
