package com.wanjia.infoshopmallmanage.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanjia.infoshopmallmanage.entity.Admin;
import com.wanjia.infoshopmallmanage.entity.AdminRole;
import com.wanjia.infoshopmallmanage.entity.Company;
import com.wanjia.infoshopmallmanage.entity.CompanyStaff;
import com.wanjia.infoshopmallmanage.entity.CompanyStaffNHS;
import com.wanjia.infoshopmallmanage.entity.EnvParas;
import com.wanjia.infoshopmallmanage.entity.Examine;
import com.wanjia.infoshopmallmanage.entity.User;
import com.wanjia.infoshopmallmanage.entity.UserLevel;
import com.wanjia.infoshopmallmanage.mapper.AdminMapper;
import com.wanjia.infoshopmallmanage.mapper.AdminRoleMapper;
import com.wanjia.infoshopmallmanage.mapper.CompanyMapper;
import com.wanjia.infoshopmallmanage.mapper.CompanyStaffMapper;
import com.wanjia.infoshopmallmanage.mapper.EnvParasMapper;
import com.wanjia.infoshopmallmanage.mapper.ExamineMapper;
import com.wanjia.infoshopmallmanage.mapper.UserLevelMapper;
import com.wanjia.infoshopmallmanage.mapper.UserMapper;
import com.wanjia.infoshopmallmanage.util.FileuploadUtil;
import com.wanjia.infoshopmallmanage.util.RandomCodeUtil;
import com.wanjia.infoshopmallmanage.util.RestResponse;
import com.wanjia.infoshopmallmanage.util.SmsUtil;
import com.wanjia.infoshopmallmanage.util.StringUtil;

@Service
public class AdminService {
	
	@Autowired
	ExamineMapper examineMapper;
	
	@Autowired
	CompanyMapper companyMapper;
	
	@Autowired
	CompanyStaffMapper companyStaffMapper;
	
	@Autowired
	EnvParasMapper envParasMapper;
	
	@Autowired
	FileuploadUtil fileUploadUtil;
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	AdminMapper adminMapper;
	
	@Autowired
	AdminRoleMapper adminRoleMapper;
	
	@Autowired
	UserLevelMapper userLevelMapper;
	
	/**
	 * 	获取待审核的企业申请信息
	 * 	@param pageNo
	 * 	@return
	 */
	@Transactional
	public RestResponse getCompanyExamineInfo(Integer pageNo)
	{
		if (pageNo==null) {
			return RestResponse.fail("非法访问!");
		}
		//获取待审核的企业申请信息
		//分页
		PageHelper.startPage(pageNo,10);
		List<Examine> examines = examineMapper.getExamines();
		PageInfo<Examine> pageInfo =new PageInfo<Examine>(examines);
		long recordNum = pageInfo.getTotal();
		//封装返回的数据
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("examines", examines);
		map.put("recordNum", recordNum);
		return RestResponse.ok("获取待审核企业申请信息成功!",map);
	}
	
	/**
	 * 	审核企业申请
	 * 	@param adminId
	 * 	@param failReason
	 * 	@param reviewStatus
	 * 	@return
	 */
	@Transactional
	public RestResponse examineCompanyInfo(Long adminId,Long examineId,String failReason,Integer reviewStatus)
	{
		//校验数据
		if (examineId==null||reviewStatus==null||(reviewStatus==0&&!StringUtil.checkStringNull(failReason))) {
			return RestResponse.fail("非法访问!");
		}
		//更新申请表记录
		examineMapper.update(new Examine(examineId,adminId, failReason, reviewStatus));
		if (reviewStatus==1) {
			//获取申请记录
			Examine examine = examineMapper.queryById(examineId);
			
			//添加企业记录
			Company company = new Company(examine.getUserId(), examine.getCompanyNature(), examine.getCompanyName(), examine.getBusinessNum(), examine.getBusinessLicense(), examine.getIdcardName(), examine.getIdcardNum(), examine.getIdcardImages(), examine.getCompanyAddr(), new Date());
			companyMapper.insert(company);
			
			//获取用户记录
			User user = userMapper.queryById(examine.getUserId());
			//把企业的掌控人添加到员工表
			companyStaffMapper.insert(new CompanyStaff(null,0, examine.getUserId(), company.getId(),1,new Date()));
			
			//更新用户角色
			userMapper.updateUserRole(examine.getUserId(), 2);
			
			//给企业的掌控人分配一个管理员账户(角色就是企业掌控人)
			//生成一个唯一的管理员账户名
			String adminName = "Admin"+user.getUsername();
			//随机一个密码
			String password = RandomCodeUtil.createRangeNo()+"";
			//分配角色
			Admin admin = new Admin(examine.getUserId(), adminName, password, user.getPhone(),"企业管理员");
			adminMapper.insert(admin);
			adminRoleMapper.insert(new AdminRole(admin.getId(), (long) 2));
			//使用短信通知用户企业申请成功,并将初始用户名和密码告知用户
			SmsUtil.sendExamineCompanySuccessNotify(user.getPhone(), adminName, password);
		}
		if (reviewStatus==0) {
			//获取申请记录
			Examine examine = examineMapper.queryById(examineId);
			//删除营业执照文件
		    fileUploadUtil.removeUserFile(examine.getBusinessLicense());
		    //删除身份证照文件
		    String[] idCardImages = examine.getIdcardImages().split(",");
		    for (String idCardImage : idCardImages) {
		    	fileUploadUtil.removeUserFile(idCardImage);
			}
			//使用短信通知用户企业申请失败
			SmsUtil.sendExamineCompanyFailNotify(userMapper.queryById(examineMapper.queryById(examineId).getUserId()).getPhone(), failReason);
		}
		return RestResponse.ok("审核结果提交成功!");
	}
	
	/**
	 * 	获取当前用户所管理的公司信息
	 * 	@param adminId:管理员id
	 */
	@Transactional
	public RestResponse getOwnCompanyInfo(Long adminId)
	{
		Company company = companyMapper.getCompanyInfoByAdminId(adminId);
		List<Company> list = new ArrayList<Company>();
		list.add(company);
		return RestResponse.ok("获取公司信息成功!",list);
	}
	
	/**
	 * 	获取待处理的加入公司的申请信息
	 * 	@param pageNo
	 * 	@param adminId
	 * 	@return
	 */
	@Transactional
	public RestResponse getJoinCompanyInfo(Integer pageNo,Long adminId)
	{
		if (pageNo==null) {
			return RestResponse.fail("非法访问!");
		}
		//获取待处理的加入公司的申请信息
		PageHelper.startPage(pageNo, 10);
		List<CompanyStaffNHS> list = companyStaffMapper.getCompanyStaffs(adminId);
		PageInfo<CompanyStaffNHS> pageInfo =new PageInfo<CompanyStaffNHS>(list);
		long recordNum = pageInfo.getTotal();
		//封装返回的数据
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("list", list);
		map.put("recordNum", recordNum);
		if (list==null) {
			return RestResponse.ok("当前没有待处理的申请!", map);
		}
		return RestResponse.ok("获取员工申请信息成功", map);
	}
	
	/**
	 * 	审核员工申请
	 *  @param id:员工申请记录的id
	 *  @param res:审核结果: 0:不同意 1:同意
	 */
	@Transactional
	public RestResponse examineJoinCompanyInfo(Long id,Integer res)
	{
		if (id==null||res==null) {
			return RestResponse.fail("非法访问!");
		}
		//更新员工申请记录
		companyStaffMapper.update(new CompanyStaff(id, res));
		if (res==1) {
			//更新员工的用户角色
			userMapper.updateUserRole(companyStaffMapper.queryById(id).getStaffId(), 2);
			
			//短信通知员工申请审核成功
			//获取员工记录
			CompanyStaff companyStaff = companyStaffMapper.queryById(id);
			SmsUtil.sendJoinCompanySuccessNotify(userMapper.queryById(companyStaff.getStaffId()).getPhone(), companyMapper.queryById(companyStaff.getCompanyId()).getCompanyName());
		}
		if (res==0) {
			//获取员工记录
			CompanyStaff companyStaff = companyStaffMapper.queryById(id);
			//短信通知员工申请审核未通过
			SmsUtil.sendJoinCompanyFailNotify(userMapper.queryById(companyStaff.getStaffId()).getPhone(), companyMapper.queryById(companyStaff.getCompanyId()).getCompanyName());
		}
		return RestResponse.ok("审核结果提交成功!");
	}
	
	/**
	 * 	获取已加入的员工信息
	 * 	@param adminId
	 * 	@return
	 */
	@Transactional
	public RestResponse getStaffs(Integer pageNo,Long adminId) 
	{
		//分页
		PageHelper.startPage(pageNo, 10);
		List<CompanyStaffNHS> list = companyStaffMapper.getStaffs(adminId);
		PageInfo<CompanyStaffNHS> pageInfo =new PageInfo<CompanyStaffNHS>(list);
		long recordNum = pageInfo.getTotal();
		//封装返回的数据
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("list", list);
		map.put("recordNum", recordNum);
		return RestResponse.ok("获取已加入的员工信息成功!", map);
	}
	
	/**
	 * 	管理员工等级
	 * 	@param id:员工记录id
	 * 	@param staffLevelId:员工等级id(实际就是员工等级)
	 * 	@return
	 */
	@Transactional
	public RestResponse setStaffLevel(Long id,Integer staffLevelId)
	{
		if (id==null||staffLevelId==null) {
			return RestResponse.fail("非法访问!");
		}
		//更新员工等级
		companyStaffMapper.update(new CompanyStaff(id, staffLevelId, null, null, null));
		return RestResponse.ok("设置员工等级成功!");
	}
	
	/**
	 * 	开除员工
	 * 	@param id
	 * 	@param staffId
	 * 	@return
	 */
	@Transactional
	public RestResponse expelStaff(Long id,Long staffId)
	{
		if (id==null||staffId==null) {
			return RestResponse.fail("非法访问!");
		}
		//获取员工记录
		CompanyStaff companyStaff = companyStaffMapper.queryById(id);
		//删除员工记录
		companyStaffMapper.deleteById(id);
		//更新员工的用户角色
		userMapper.updateUserRole(staffId,0);
		//短信通知员工被开除
		SmsUtil.sendExpelNotify(userMapper.queryById(companyStaff.getStaffId()).getPhone(), companyMapper.queryById(companyStaff.getCompanyId()).getCompanyName());
		return RestResponse.ok("开除员工成功!");
	}
	
	/**
	 * 获取默认文件
	 * @return
	 */
	public RestResponse getDefaultImgs()
	{
		//封装返回的数据
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		//获取默认头像文件url
		map.put("defaultHeadImg", envParasMapper.selectByKey("defaultHeadImg"));
		//获取默认空间背景文件的url
		map.put("defaultBgImg", envParasMapper.selectByKey("defaultBgImg"));
		return RestResponse.ok("获取默认文件成功!", map);
	}
	
	/**
	 * 	设置默认文件
	 * 	@param defaultHeadImg:默认头像
	 * 	@param defaultBgImg:默认空间背景
	 */
	public RestResponse setDefaultImgs(MultipartFile defaultHeadImg,MultipartFile defaultBgImg)
	{
		if ((defaultHeadImg==null||"".equals(defaultHeadImg.getOriginalFilename()))&&(defaultBgImg==null||"".equals(defaultBgImg.getOriginalFilename()))) {
			return RestResponse.fail("非法访问!");
		}
		if ((defaultHeadImg!=null&&!"".equals(defaultHeadImg.getOriginalFilename()))) {
			//删除旧的默认头像
			fileUploadUtil.removeFile("defaultFile/defaultHeadImg.jpg");
			//上传新的默认头像
			fileUploadUtil.uploadDefaultFile(defaultHeadImg, "defaultFile/defaultHeadImg.jpg");
			//更新基础数据表
			envParasMapper.updateRecordByParaKey("defaultHeadImg", new Date());
		}
		if ((defaultBgImg!=null&&!"".equals(defaultBgImg.getOriginalFilename()))) {
			//删除旧的默认头像
			fileUploadUtil.removeFile("defaultFile/defaultBgImage.jpg");
			//上传新的默认头像
			fileUploadUtil.uploadDefaultFile(defaultBgImg, "defaultFile/defaultBgImage.jpg");
			//更新基础数据表
			envParasMapper.updateRecordByParaKey("defaultBgImg", new Date());
		}
		return RestResponse.ok("更改默认文件成功!");
	}
	
	/**
	 *	 新增用户默认等级设置记录
	 * 	@param level:等级
	 *  @param levelName:等级名
	 *  @param requireScore:所需积分
	 *  @param remarks:说明
	 *  
	*/
	@Transactional
	public RestResponse addUserLevel(UserLevel userLevel)
	{
		if (userLevel.getLevel()==null||!StringUtil.checkStringNull(userLevel.getLevelName())||userLevel.getRequireScore()==null) {
			return RestResponse.fail("非法访问!");
		}
		Integer level = userLevel.getLevel();
		String levelName = userLevel.getLevelName();
		Integer requireScore = userLevel.getRequireScore();
		//校验记录合法性(高等级所需积分必须比低等级高，且等级和等级名不能重复)
		if ((level!=null&&userLevelMapper.getCountByLevel(level)!=0)||(StringUtil.checkStringNull(levelName)&&userLevelMapper.getCountByLevelName(levelName)!=0)||((level!=null&&requireScore!=null)&&(userLevelMapper.getHighLevelLowScoreCount(level, requireScore)!=0||userLevelMapper.getLowLevelHighScoreCount(level, requireScore)!=0))) {
			return RestResponse.fail("新增的记录存在不合法，存在重复的属性或积分设置有误。");
		}
		//插入用户等级设置记录
		userLevelMapper.insert(userLevel);
		return RestResponse.ok("新增用户等级设置记录成功");
	}
	
	/**
	 * 	移除用户默认等级设置记录
	 * 	@param id:默认等级设置记录的id
	 * 	@return
	 */
//	@Transactional
//	public RestResponse removeUserLevel(Long id)
//	{
//		if (id==null) {
//			return RestResponse.fail("非法访问!");
//		}
//		//删除记录
//		userLevelMapper.deleteById(id);
//		return RestResponse.ok("移除用户默认等级设置记录成功!");
//	}
	
	/**
	 * 	更改用户默认等级设置记录
	 * 	@param id:默认等级设置记录的id
	 *  @param levelName:等级名
	 *  @param requireScore:所需积分
	 *  @param remarks:说明
	 * 	@return
	 */
	@Transactional
	public RestResponse updateUserLevel(UserLevel userLevel)
	{
		if (userLevel.getId()==null||(!StringUtil.checkStringNull(userLevel.getLevelName())&&userLevel.getRequireScore()==null&&!StringUtil.checkStringNull(userLevel.getRemarks()))) {
			return RestResponse.fail("非法访问!");
		}
		UserLevel ul = userLevelMapper.queryById(userLevel.getId());
		Integer level = ul.getLevel();
		String levelName = userLevel.getLevelName();
		Integer requireScore = userLevel.getRequireScore();
		//校验记录合法性(高等级所需积分必须比低等级高，且等级和等级名不能重复)
		if ((StringUtil.checkStringNull(levelName)&&!ul.getLevelName().equals(levelName)&&userLevelMapper.getCountByLevelName(levelName)!=0)||((requireScore!=null)&&(userLevelMapper.getHighLevelLowScoreCount(level, requireScore)!=0||userLevelMapper.getLowLevelHighScoreCount(level, requireScore)!=0))) {
			return RestResponse.fail("更改的记录存在重复的属性或积分设置有误。");
		}
		//更新记录
		userLevelMapper.update(userLevel);
		return RestResponse.ok("更改用户默认等级设置记录成功");
	}
	
	/**
	 * 	获取用户默认等级记录
	 * 	pageNo:页码
	 * 	@return
	 */
	@Transactional
	public RestResponse getUserLevels(Integer pageNo)
	{
		if (pageNo==null) {
			return RestResponse.fail("非法访问!");
		}
		//分页
		PageHelper.startPage(pageNo, 10);
		//获取等级记录
		List<UserLevel> list = userLevelMapper.getAllUserLevels();
		PageInfo<UserLevel> pageInfo =new PageInfo<UserLevel>(list);
		long recordNum = pageInfo.getTotal();
		//封装返回的数据
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("list", list);
		map.put("recordNum", recordNum);
		return RestResponse.ok("获取默认等级设置成功", map);
	}
}
