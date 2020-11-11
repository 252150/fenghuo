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

import com.wanjia.infoshopmallmanage.entity.MessPublish;
import com.wanjia.infoshopmallmanage.service.MessPublishService;
import com.wanjia.infoshopmallmanage.util.AuthJwtUtil;
import com.wanjia.infoshopmallmanage.util.RestResponse;

@RestController
@RequestMapping("/messPublish")
public class MessPublishController {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private MessPublishService messPublishService;

	/**
	 * 平台消息新增
	 * 
	 * @param messPublish 消息实体类
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "multipart/form-data")
	public RestResponse add(@ModelAttribute MessPublish messPublish, HttpSession session) {
		// 获取token
		String token = request.getHeader("Authorization");
		// 获取管理员id
		Long adminId = AuthJwtUtil.getClaims(token).get("adminId").asLong();
		messPublish.setAdmin(adminId);
		return messPublishService.add(messPublish);
	}

	/**
	 * 平台消息修改
	 * 
	 * @param messPublish 消息实体类
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "multipart/form-data")
	public RestResponse update(@ModelAttribute MessPublish messPublish, HttpSession session) {

		// 获取token
		String token = request.getHeader("Authorization");
		// 获取管理员id
		Long adminId = AuthJwtUtil.getClaims(token).get("adminId").asLong();
		messPublish.setAdmin(adminId);
		return messPublishService.update(messPublish);
	}
    /**
     * 删除消息
     * @param id 删除id
     * @return
     */
	@GetMapping("/delete")
	public RestResponse delete(Long id) {
		
		// 获取token
		String token = request.getHeader("Authorization");
		// 获取管理员id
		Long adminId = AuthJwtUtil.getClaims(token).get("adminId").asLong();
		return messPublishService.delete(adminId, id);
	}
	/**
	 * 消息集合获取
	 * @param messPublish
	 * @return
	 */
	@PostMapping("/list")
	public RestResponse list(@RequestBody MessPublish messPublish) {
		// 获取token
		String token = request.getHeader("Authorization");
		// 获取管理员id
		Long adminId = AuthJwtUtil.getClaims(token).get("adminId").asLong();
		messPublish.setAdmin(adminId);
		return messPublishService.list(messPublish);
	}
}
