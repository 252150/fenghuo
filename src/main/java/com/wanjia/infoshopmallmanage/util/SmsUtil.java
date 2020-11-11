package com.wanjia.infoshopmallmanage.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;

/*
 * 短信验证码发送工具类
 */

public class SmsUtil 
{
	/**
	 * 	发送验证码
	 * 	@param phone:手机号
	 * 	@param valid_code:验证码
	 * 	@return
	 */
	public static boolean sendSmsTp(String phone,int valid_code) {
        //地址
        String urls = "https://api.mix2.zthysms.com/v2/sendSmsTp";
        //请求入参
        JSONObject requestJson = new JSONObject(new LinkedHashMap<String, Object>());
        //账号
        requestJson.put("username","hjsb");
        //tKey
        long tKey = System.currentTimeMillis() / 1000;
        //明文密码
        requestJson.put("password", DigestUtils.md5DigestAsHex((DigestUtils.md5DigestAsHex("hjsb666".getBytes()) + tKey).getBytes()));
        requestJson.put("tKey", tKey);
        //模板ID
        requestJson.put("tpId", 24553);
        //签名
        requestJson.put("signature", "【渝荟宝】");
        //扩展号
        requestJson.put("ext","");
        //自定义参数
        requestJson.put("extend","");
        //发送记录集合
        JSONArray records = new JSONArray();
        JSONObject record = new JSONObject();
        //手机号
        record.put("mobile", phone);
        //替换变量
        JSONObject param = new JSONObject();
        param.put("valid_code", valid_code);
        record.put("tpContent", param);
        records.add(record);
        requestJson.put("records", records);
        RestTemplate client = new RestTemplate();
        //调用第三方短信平台接口发验证码短信
	    JSONObject result = client.postForEntity(urls,requestJson,JSONObject.class).getBody();
	    //返回短信验证码的发送结果
	    if((int) result.get("code")!=200)
	    {
	    	return false;
	    }
	    return true;
	}
	
	/**
	 * 发送求助短信
	 * @param phone
	 * @param msg
	 * @return
	 */
	public static boolean sendHelpNotify(String phone,String name,String location)
	{
		//地址
        String urls = "https://api.mix2.zthysms.com/v2/sendSmsTp";
        //请求入参
        JSONObject requestJson = new JSONObject(new LinkedHashMap<String, Object>());
        //账号
        requestJson.put("username","hjsb");
        //tKey
        long tKey = System.currentTimeMillis() / 1000;
        //明文密码
        requestJson.put("password", DigestUtils.md5DigestAsHex((DigestUtils.md5DigestAsHex("hjsb666".getBytes()) + tKey).getBytes()));
        requestJson.put("tKey", tKey);
        //模板ID
        requestJson.put("tpId", 24566);
        //签名
        requestJson.put("signature", "【渝荟宝】");
        //扩展号
        requestJson.put("ext","");
        //自定义参数
        requestJson.put("extend","");
        //发送记录集合
        JSONArray records = new JSONArray();
        JSONObject record = new JSONObject();
        //手机号
        record.put("mobile", phone);
        //替换变量
        JSONObject param = new JSONObject();
        param.put("name", name);
        param.put("location", location);
        record.put("tpContent", param);
        records.add(record);
        requestJson.put("records", records);
        RestTemplate client = new RestTemplate();
        //调用第三方短信平台接口发验证码短信
	    JSONObject result = client.postForEntity(urls,requestJson,JSONObject.class).getBody();
	    //返回短信验证码的发送结果
	    if((int) result.get("code")!=200)
	    {
	    	return false;
	    }
	    return true;
	}
	
	/**
	 * 发送改密通知
	 * @param phone
	 * @param date
	 * @return
	 */
	public static boolean sendPasswordNotify(String phone,String date)
	{
		//地址
        String urls = "https://api.mix2.zthysms.com/v2/sendSmsTp";
        //请求入参
        JSONObject requestJson = new JSONObject(new LinkedHashMap<String, Object>());
        //账号
        requestJson.put("username","hjsb");
        //tKey
        long tKey = System.currentTimeMillis() / 1000;
        //明文密码
        requestJson.put("password", DigestUtils.md5DigestAsHex((DigestUtils.md5DigestAsHex("hjsb666".getBytes()) + tKey).getBytes()));
        requestJson.put("tKey", tKey);
        //模板ID
        requestJson.put("tpId", 24557);
        //签名
        requestJson.put("signature", "【渝荟宝】");
        //扩展号
        requestJson.put("ext","");
        //自定义参数
        requestJson.put("extend","");
        //发送记录集合
        JSONArray records = new JSONArray();
        JSONObject record = new JSONObject();
        //手机号
        record.put("mobile", phone);
        //替换变量
        JSONObject param = new JSONObject();
        param.put("date", date);
        record.put("tpContent", param);
        records.add(record);
        requestJson.put("records", records);
        RestTemplate client = new RestTemplate();
        //调用第三方短信平台接口发验证码短信
	    JSONObject result = client.postForEntity(urls,requestJson,JSONObject.class).getBody();
	    //返回短信验证码的发送结果
	    if((int) result.get("code")!=200)
	    {
	    	return false;
	    }
	    return true;
	}
	
	/**
	 * 公司注销通知
	 * @param phone
	 * @param company
	 * @return
	 */
	public static boolean sendCancelCompanyNotify(String phone,String company)
	{
		//地址
        String urls = "https://api.mix2.zthysms.com/v2/sendSmsTp";
        //请求入参
        JSONObject requestJson = new JSONObject(new LinkedHashMap<String, Object>());
        //账号
        requestJson.put("username","hjsb");
        //tKey
        long tKey = System.currentTimeMillis() / 1000;
        //明文密码
        requestJson.put("password", DigestUtils.md5DigestAsHex((DigestUtils.md5DigestAsHex("hjsb666".getBytes()) + tKey).getBytes()));
        requestJson.put("tKey", tKey);
        //模板ID
        requestJson.put("tpId", 24568);
        //签名
        requestJson.put("signature", "【渝荟宝】");
        //扩展号
        requestJson.put("ext","");
        //自定义参数
        requestJson.put("extend","");
        //发送记录集合
        JSONArray records = new JSONArray();
        JSONObject record = new JSONObject();
        //手机号
        record.put("mobile", phone);
        //替换变量
        JSONObject param = new JSONObject();
        param.put("company", company);
        record.put("tpContent", param);
        records.add(record);
        requestJson.put("records", records);
        RestTemplate client = new RestTemplate();
        //调用第三方短信平台接口发验证码短信
	    JSONObject result = client.postForEntity(urls,requestJson,JSONObject.class).getBody();
	    //返回短信验证码的发送结果
	    if((int) result.get("code")!=200)
	    {
	    	return false;
	    }
	    return true;
	}
	
	/**
	 * 员工退出公司的通知
	 * @param phone
	 * @param name
	 * @param company
	 * @return
	 */
	public static boolean sendQuitCompanyNotify(String phone,String name,String company)
	{
		//地址
        String urls = "https://api.mix2.zthysms.com/v2/sendSmsTp";
        //请求入参
        JSONObject requestJson = new JSONObject(new LinkedHashMap<String, Object>());
        //账号
        requestJson.put("username","hjsb");
        //tKey
        long tKey = System.currentTimeMillis() / 1000;
        //明文密码
        requestJson.put("password", DigestUtils.md5DigestAsHex((DigestUtils.md5DigestAsHex("hjsb666".getBytes()) + tKey).getBytes()));
        requestJson.put("tKey", tKey);
        //模板ID
        requestJson.put("tpId", 24567);
        //签名
        requestJson.put("signature", "【渝荟宝】");
        //扩展号
        requestJson.put("ext","");
        //自定义参数
        requestJson.put("extend","");
        //发送记录集合
        JSONArray records = new JSONArray();
        JSONObject record = new JSONObject();
        //手机号
        record.put("mobile", phone);
        //替换变量
        JSONObject param = new JSONObject();
        param.put("name", name);
        param.put("company", company);
        record.put("tpContent", param);
        records.add(record);
        requestJson.put("records", records);
        RestTemplate client = new RestTemplate();
        //调用第三方短信平台接口发验证码短信
	    JSONObject result = client.postForEntity(urls,requestJson,JSONObject.class).getBody();
	    //返回短信验证码的发送结果
	    if((int) result.get("code")!=200)
	    {
	    	return false;
	    }
	    return true;
	}
	
	/**
	 * 企业申请成功的通知
	 * @param phone
	 * @param adminAccount
	 * @param adminPassword
	 * @return
	 */
	public static boolean sendExamineCompanySuccessNotify(String phone,String adminAccount,String adminPassword)
	{
		//地址
        String urls = "https://api.mix2.zthysms.com/v2/sendSmsTp";
        //请求入参
        JSONObject requestJson = new JSONObject(new LinkedHashMap<String, Object>());
        //账号
        requestJson.put("username","hjsb");
        //tKey
        long tKey = System.currentTimeMillis() / 1000;
        //明文密码
        requestJson.put("password", DigestUtils.md5DigestAsHex((DigestUtils.md5DigestAsHex("hjsb666".getBytes()) + tKey).getBytes()));
        requestJson.put("tKey", tKey);
        //模板ID
        requestJson.put("tpId", 24571);
        //签名
        requestJson.put("signature", "【渝荟宝】");
        //扩展号
        requestJson.put("ext","");
        //自定义参数
        requestJson.put("extend","");
        //发送记录集合
        JSONArray records = new JSONArray();
        JSONObject record = new JSONObject();
        //手机号
        record.put("mobile", phone);
        //替换变量
        JSONObject param = new JSONObject();
        param.put("adminAccount", adminAccount);
        param.put("adminPassword", adminPassword);
        record.put("tpContent", param);
        records.add(record);
        requestJson.put("records", records);
        RestTemplate client = new RestTemplate();
        //调用第三方短信平台接口发验证码短信
	    JSONObject result = client.postForEntity(urls,requestJson,JSONObject.class).getBody();
	    //返回短信验证码的发送结果
	    if((int) result.get("code")!=200)
	    {
	    	return false;
	    }
	    return true;
	}
	
	/**
	 * 员工申请审核成功的通知
	 * @param phone
	 * @param company
	 * @return
	 */
	public static boolean sendJoinCompanySuccessNotify(String phone,String company)
	{
		//地址
        String urls = "https://api.mix2.zthysms.com/v2/sendSmsTp";
        //请求入参
        JSONObject requestJson = new JSONObject(new LinkedHashMap<String, Object>());
        //账号
        requestJson.put("username","hjsb");
        //tKey
        long tKey = System.currentTimeMillis() / 1000;
        //明文密码
        requestJson.put("password", DigestUtils.md5DigestAsHex((DigestUtils.md5DigestAsHex("hjsb666".getBytes()) + tKey).getBytes()));
        requestJson.put("tKey", tKey);
        //模板ID
        requestJson.put("tpId", 24586);
        //签名
        requestJson.put("signature", "【渝荟宝】");
        //扩展号
        requestJson.put("ext","");
        //自定义参数
        requestJson.put("extend","");
        //发送记录集合
        JSONArray records = new JSONArray();
        JSONObject record = new JSONObject();
        //手机号
        record.put("mobile", phone);
        //替换变量
        JSONObject param = new JSONObject();
        param.put("company", company);
        record.put("tpContent", param);
        records.add(record);
        requestJson.put("records", records);
        RestTemplate client = new RestTemplate();
        //调用第三方短信平台接口发验证码短信
	    JSONObject result = client.postForEntity(urls,requestJson,JSONObject.class).getBody();
	    //返回短信验证码的发送结果
	    if((int) result.get("code")!=200)
	    {
	    	return false;
	    }
	    return true;
	}
	
	/**
	 * 开除员工的通知
	 * @param phone
	 * @param company
	 * @return
	 */
	public static boolean sendExpelNotify(String phone,String company)
	{
		//地址
        String urls = "https://api.mix2.zthysms.com/v2/sendSmsTp";
        //请求入参
        JSONObject requestJson = new JSONObject(new LinkedHashMap<String, Object>());
        //账号
        requestJson.put("username","hjsb");
        //tKey
        long tKey = System.currentTimeMillis() / 1000;
        //明文密码
        requestJson.put("password", DigestUtils.md5DigestAsHex((DigestUtils.md5DigestAsHex("hjsb666".getBytes()) + tKey).getBytes()));
        requestJson.put("tKey", tKey);
        //模板ID
        requestJson.put("tpId", 24585);
        //签名
        requestJson.put("signature", "【渝荟宝】");
        //扩展号
        requestJson.put("ext","");
        //自定义参数
        requestJson.put("extend","");
        //发送记录集合
        JSONArray records = new JSONArray();
        JSONObject record = new JSONObject();
        //手机号
        record.put("mobile", phone);
        //替换变量
        JSONObject param = new JSONObject();
        param.put("company", company);
        record.put("tpContent", param);
        records.add(record);
        requestJson.put("records", records);
        RestTemplate client = new RestTemplate();
        //调用第三方短信平台接口发验证码短信
	    JSONObject result = client.postForEntity(urls,requestJson,JSONObject.class).getBody();
	    //返回短信验证码的发送结果
	    if((int) result.get("code")!=200)
	    {
	    	return false;
	    }
	    return true;
	}
	
	/**
	 * 员工申请未通过的通知
	 * @param phone
	 * @param company
	 * @return
	 */
	public static boolean sendJoinCompanyFailNotify(String phone,String company)
	{
		//地址
        String urls = "https://api.mix2.zthysms.com/v2/sendSmsTp";
        //请求入参
        JSONObject requestJson = new JSONObject(new LinkedHashMap<String, Object>());
        //账号
        requestJson.put("username","hjsb");
        //tKey
        long tKey = System.currentTimeMillis() / 1000;
        //明文密码
        requestJson.put("password", DigestUtils.md5DigestAsHex((DigestUtils.md5DigestAsHex("hjsb666".getBytes()) + tKey).getBytes()));
        requestJson.put("tKey", tKey);
        //模板ID
        requestJson.put("tpId", 24637);
        //签名
        requestJson.put("signature", "【渝荟宝】");
        //扩展号
        requestJson.put("ext","");
        //自定义参数
        requestJson.put("extend","");
        //发送记录集合
        JSONArray records = new JSONArray();
        JSONObject record = new JSONObject();
        //手机号
        record.put("mobile", phone);
        //替换变量
        JSONObject param = new JSONObject();
        param.put("company", company);
        record.put("tpContent", param);
        records.add(record);
        requestJson.put("records", records);
        RestTemplate client = new RestTemplate();
        //调用第三方短信平台接口发验证码短信
	    JSONObject result = client.postForEntity(urls,requestJson,JSONObject.class).getBody();
	    //返回短信验证码的发送结果
	    if((int) result.get("code")!=200)
	    {
	    	return false;
	    }
	    return true;
	}
	
	/**
	 * 	企业申请失败的通知
	 * 	@param phone
	 * 	@param reason
	 * 	@return
	 */
	public static boolean sendExamineCompanyFailNotify(String phone,String reason)
	{
		//地址
        String urls = "https://api.mix2.zthysms.com/v2/sendSmsTp";
        //请求入参
        JSONObject requestJson = new JSONObject(new LinkedHashMap<String, Object>());
        //账号
        requestJson.put("username","hjsb");
        //tKey
        long tKey = System.currentTimeMillis() / 1000;
        //明文密码
        requestJson.put("password", DigestUtils.md5DigestAsHex((DigestUtils.md5DigestAsHex("hjsb666".getBytes()) + tKey).getBytes()));
        requestJson.put("tKey", tKey);
        //模板ID
        requestJson.put("tpId", 24638);
        //签名
        requestJson.put("signature", "【渝荟宝】");
        //扩展号
        requestJson.put("ext","");
        //自定义参数
        requestJson.put("extend","");
        //发送记录集合
        JSONArray records = new JSONArray();
        JSONObject record = new JSONObject();
        //手机号
        record.put("mobile", phone);
        //替换变量
        JSONObject param = new JSONObject();
        param.put("reason", reason);
        record.put("tpContent", param);
        records.add(record);
        requestJson.put("records", records);
        RestTemplate client = new RestTemplate();
        //调用第三方短信平台接口发验证码短信
	    JSONObject result = client.postForEntity(urls,requestJson,JSONObject.class).getBody();
	    //返回短信验证码的发送结果
	    if((int) result.get("code")!=200)
	    {
	    	return false;
	    }
	    return true;
	}
}
