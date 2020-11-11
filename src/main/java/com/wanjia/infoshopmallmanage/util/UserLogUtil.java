package com.wanjia.infoshopmallmanage.util;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
拼接用户操作日志的工具类
*/

@Component
public class UserLogUtil 
{
	//用户日志拼接的格式："userId - userName - operationTime - ip - operationContent - remarks"
	//拼接用户操作日志的方法
	//assignAction：用户调用接口时的操作(由后端通过自定义注解写死)
	//fullMethodName：全方法名：控制器名+方法名
	public static String montageUserLog(String token,String fullMethodName,String assignAction,HttpServletRequest request,String remarks)
	{
		//初始化一个operationContent，拼接操作内容
		String operationContent = "调用了"+fullMethodName+"方法,"+"完成了"+assignAction;
		//Auth0JwtUtils.getClaims(token).get("userName").asString():获取token中携带的userName
		//Auth0JwtUtils.getClaims(token).get("userId").asLong():获取token中携带的userId
		return AuthJwtUtil.getClaims(token).get("userId").asLong()+""
				+" - "+AuthJwtUtil.getClaims(token).get("userName").asString()
				+" - "+DateToStr(new Date())
				+" - "+IpUtil.getIpAddr(request)
				+" - "+operationContent
				+" - "+remarks;
	}
	
	//将Date类型转为String以便记录到日志中
	public static String DateToStr(Date date)
	{
		//给定日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = sdf.format(date);
		return str;
	}
}
