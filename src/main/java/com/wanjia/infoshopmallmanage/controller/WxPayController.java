package com.wanjia.infoshopmallmanage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wanjia.infoshopmallmanage.service.WxPayService;

@RequestMapping("/wx")
@RestController
public class WxPayController {
	
	@Autowired
	WxPayService wxPayService;
	
	@GetMapping("/wxRefundNotify")
	public void wxRefundNotify(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		wxPayService.wxRefundNotify(request,response);
	}
}
