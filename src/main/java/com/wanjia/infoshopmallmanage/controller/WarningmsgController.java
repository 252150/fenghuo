package com.wanjia.infoshopmallmanage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.wanjia.infoshopmallmanage.entity.Warningmsg;
import com.wanjia.infoshopmallmanage.service.WarningmsgService;
import com.wanjia.infoshopmallmanage.util.AuthJwtUtil;
import com.wanjia.infoshopmallmanage.util.RestResponse;

@RestController
@RequestMapping("/warningmsg")
public class WarningmsgController {
	@Autowired
	
    private WarningmsgService   warningmsgService;
	@Autowired
	private HttpServletRequest request;
	/**
	 * 灾害消息新增
	 * @param warningmsg 灾害消息实体类
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "multipart/form-data")
	public RestResponse add(@ModelAttribute Warningmsg warningmsg ,HttpSession session) {
		
		String token = request.getHeader("Authorization");
		Long adminId = AuthJwtUtil.getClaims(token).get("adminId").asLong();
	   
		return warningmsgService.add(warningmsg,adminId );
	}
	/**
	 * 灾害消息修改
	 * @param warningmsg 灾害消息实体类
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "multipart/form-data")
	public RestResponse update(@ModelAttribute Warningmsg warningmsg ,HttpSession session) {
		String token = request.getHeader("Authorization");
		System.out.println(warningmsg.getId());
		Long adminId = AuthJwtUtil.getClaims(token).get("adminId").asLong();
		return warningmsgService.update(warningmsg,adminId );
	}
	/**
	 * 删除灾害消息
	 * @param id
	 * @return
	 */
	@GetMapping("/delete")
	public RestResponse delete(Long id) {
		String token = request.getHeader("Authorization");
		Long adminId = AuthJwtUtil.getClaims(token).get("adminId").asLong();
		return warningmsgService.delete(adminId, id);
	}
	/**
	 * 获取灾害消息集合
	 * @param ws
	 * @return
	 */
	@PostMapping("/list")
	public RestResponse list(@RequestBody Warningmsg ws) {
		return warningmsgService.list(ws);
	}
}
