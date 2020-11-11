package com.wanjia.infoshopmallmanage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.wanjia.infoshopmallmanage.entity.Advertise;
import com.wanjia.infoshopmallmanage.service.AdvertiseService;
import com.wanjia.infoshopmallmanage.util.AuthJwtUtil;
import com.wanjia.infoshopmallmanage.util.RestResponse;

@RestController
@RequestMapping("/advertise")
public class AdvertiseController {
	@Autowired
	AdvertiseService advertiseService;
	@Autowired
	private HttpServletRequest request;
	/**
	 * 广告新增
	 * @param advertise 广告实体类
	 * @param session session流
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "multipart/form-data")
	public RestResponse add(@ModelAttribute Advertise advertise,HttpSession session) {
		String token = request.getHeader("Authorization");

		Long adminId = AuthJwtUtil.getClaims(token).get("adminId").asLong();
		advertise.setAdminId(adminId);
		return advertiseService.add(advertise, advertise.getMultipartFile());
	}
	/**
	 * 广告修改
	 * @param advertise 广告实体类
	 * @param session session流
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "multipart/form-data")
	public RestResponse update(@ModelAttribute Advertise advertise,HttpSession session) {
		String token = request.getHeader("Authorization");


		Long adminId = AuthJwtUtil.getClaims(token).get("adminId").asLong();
		advertise.setAdminId(adminId);
		
		return advertiseService.update(advertise, advertise.getMultipartFile());
	}
	/**
	 * 
	 * @param advertise 实体类
	 * @return
	 */
	@PostMapping("/select")
	public RestResponse select(@RequestBody Advertise advertise) {
		return advertiseService.selectState(advertise, advertise.getPageNo());
	}
	/**
	 * 审核状态
	 * @param id 广告id
	 * @param state 审核状态
	 * @return
	 */
	@GetMapping("/updateState")
	public RestResponse updateState(Long id,Integer state) {
		Advertise advertise =new Advertise();
		advertise.setId(id);
		advertise.setAdvertiseStatus(state);
		return advertiseService.updateState(advertise);
	}
	/**
	 * 积分给定与修改
	 * @param id
	 * @param ADPoints
	 * @return
	 */
	@GetMapping("/updateADpoints")
	public RestResponse updateADPoints(Long id,Integer adPoints) {
	
		return advertiseService.updateLise(adPoints,id);
	}
	@GetMapping("/delete")
	public RestResponse delete(Long id) {
		return advertiseService.delete(id);
	}
}
