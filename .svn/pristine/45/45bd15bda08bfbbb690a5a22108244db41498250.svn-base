package com.wanjia.infoshopmallmanage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.wanjia.infoshopmallmanage.entity.UserLevel;
import com.wanjia.infoshopmallmanage.service.AdminService;
import com.wanjia.infoshopmallmanage.util.AuthJwtUtil;
import com.wanjia.infoshopmallmanage.util.RestResponse;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	/**
	 * 	获取待审核的企业申请信息
	 * 	@param pageNo:页码
	 * 	@param token:登陆后生成的token
	 */
	@GetMapping("/getExamineCompanyInfo")
	public RestResponse getCompanyExamineInfo(Integer pageNo)
	{
		return adminService.getCompanyExamineInfo(pageNo);
	}
	
	/**
	 * 	审核企业申请
	 * 	@param reviewStatus:审核结果:  0:未通过 1:通过
	 * 	@param failReason:审核未通过的原因
	 * 	@param examineId:待审核记录的id
	 * 	@param token:登陆后生成的token
	 * 	@return
	 */
	@PostMapping("/examineCompanyInfo")
	public RestResponse examineCompanyInfo(@RequestBody JSONObject jsonObject,HttpServletRequest request)
	{
		Long adminId = AuthJwtUtil.getClaims(request.getHeader("Authorization")).get("adminId").asLong();
		return adminService.examineCompanyInfo(adminId,jsonObject.getLong("examineId"),jsonObject.getString("failReason"),jsonObject.getInteger("reviewStatus"));
	}
	
	/**
	 * 	获取当前用户所管理的公司信息
	 * 	@param token:登陆生成的token
	 * 	@return
	 */
	@GetMapping("/getOwnCompanyInfo")
	public RestResponse getOwnCompanyInfo(HttpServletRequest request)
	{
		Long adminId = AuthJwtUtil.getClaims(request.getHeader("Authorization")).get("adminId").asLong();
		return adminService.getOwnCompanyInfo(adminId);
	}
	
	/**
	 * 	获取待处理的加入公司的员工申请信息
	 * 	@param pageNo:页码
	 * 	@param token:登陆生成的token
	 * 	@return
	 */
	@GetMapping("/getJoinCompanyInfo")
	public RestResponse getJoinCompanyInfo(Integer pageNo,HttpServletRequest request)
	{
		Long adminId = AuthJwtUtil.getClaims(request.getHeader("Authorization")).get("adminId").asLong();
		return adminService.getJoinCompanyInfo(pageNo, adminId);
	}
	
	/**
	 * 	审核员工申请
	 *  @param id:员工申请记录的id
	 *  @param res:审核结果: 0:不同意 1:同意
	 *  @param token:登陆后生成的token
	 */
	@PostMapping("/examineJoinCompanyInfo")
	public RestResponse examineJoinCompanyInfo(@RequestBody JSONObject jsonObject)
	{
		return adminService.examineJoinCompanyInfo(jsonObject.getLong("id"), jsonObject.getInteger("res"));
	}
	
	/**
	 * 	获取已加入的员工信息
	 * 	@param token:登陆后生成的token
	 * 	@return
	 */
	@GetMapping("/getStaffs")
	public RestResponse getStaffs(Integer pageNo,HttpServletRequest request)
	{
		Long adminId = AuthJwtUtil.getClaims(request.getHeader("Authorization")).get("adminId").asLong();
		return adminService.getStaffs(pageNo,adminId);
	}
	
	/**
	 * 	管理员工的等级划分
	 * 	@param id:员工记录的id
	 * 	@param staffLevelId:给员工设置的等级
	 * 	@return
	 */
	@PostMapping("/setStaffLevel")
	public RestResponse setStaffLevel(@RequestBody JSONObject jsonObject)
	{
		return adminService.setStaffLevel(jsonObject.getLong("id"), jsonObject.getInteger("staffLevelId"));
	}
	
	/**
	 * 	开除员工
	 * 	@param id:员工记录的id
	 * 	@param staffId:员工的用户id(实际就是用户表id)
	 * 	@return
	 */
	@PostMapping("/expelStaff")
	public RestResponse expelStaff(@RequestBody JSONObject jsonObject)
	{
		return adminService.expelStaff(jsonObject.getLong("id"), jsonObject.getLong("staffId"));
	}
	
	/**
	 * 获取默认文件
	 * @param token:登录后生成的token
	 * @return
	 */
	@GetMapping("/getDefaultImgs")
	public RestResponse getDefaultImgs()
	{
		return adminService.getDefaultImgs();
	}
	
	/**
	 * 	设置默认文件
	 * 	@param defaultHeadImg:默认头像
	 * 	@param defaultBgImg:默认空间背景
	 *  @param token:登录后生成的token
	 * 	@return
	 */
	@PostMapping("/setDefaultImgs")
	public RestResponse setDefaultImgs(MultipartFile defaultHeadImg,MultipartFile defaultBgImg)
	{
		return adminService.setDefaultImgs(defaultHeadImg, defaultBgImg);
	}
	
	/**
	 *	 新增用户默认等级设置记录
	 * 	@param level:等级
	 *  @param levelName:等级名
	 *  @param requireScore:所需积分
	 *  @param remarks:说明
	 *  @param token:登陆生成的token
	 * 	@return
	 */
	@PostMapping("/addUserLevel")
	public RestResponse addUserLevel(@RequestBody JSONObject jsonObject)
	{
		return adminService.addUserLevel(new UserLevel(jsonObject.getInteger("level"),jsonObject.getString("levelName"),jsonObject.getInteger("requireScore"),jsonObject.getString("remarks")));
	}
	
	/**
	 * 	移除用户默认等级设置记录
	 * 	@param id:默认等级设置记录的id
	 *  @param token:登陆生成的token
	 * 	@return
	 */
//	@PostMapping("/removeUserLevel")
//	public RestResponse removeUserLevel(@RequestBody JSONObject jsonObject)
//	{
//		return adminService.removeUserLevel(jsonObject.getLong("id"));
//	}
	
	/**
	 *	 更改用户默认等级设置记录
	 *	@param id:默认等级设置记录的id
	 *  @param levelName:等级名
	 *  @param requireScore:所需积分
	 *  @param remarks:说明
	 *  @param token:登陆生成的token
	 * 	@return
	 */
	@PostMapping("/updateUserLevel")
	public RestResponse updateUserLevel(@RequestBody JSONObject jsonObject)
	{
		return adminService.updateUserLevel(new UserLevel(jsonObject.getLong("id"),jsonObject.getString("levelName"),jsonObject.getInteger("requireScore"),jsonObject.getString("remarks")));
	}
	
	/**
	 * 	获取用户默认等级记录
	 * 	pageNo:页码
	 * 	token:登陆生成的token
	 * 	@return
	 */
	@GetMapping("/getUserLevels")
	public RestResponse getUserLevels(Integer pageNo)
	{
		return adminService.getUserLevels(pageNo);
	}
}
