package com.wanjia.infoshopmallmanage.util;

public class DefaultFileUtil {
	//defaultHeadImgUrl:默认头像的映射路径
	public static final String defaultHeadImgUrl = "/defaultFile/defaultHeadImg.jpg";
	//defaultBgImageUrl:默认的个人空间背景图映射路径
	public static final String defaultBgImageUrl = "/defaultFile/defaultBgImage.jpg";

	private static FileuploadUtil fileuploadUtil = ContextUtil.getBean(FileuploadUtil.class);

	/**
	 * 获取用户头像
	 * @param userHeadImg
	 */
	public static String  getUserHeadImg(String userHeadImg){
		if(StringUtil.isEmpty(userHeadImg)){
			return defaultHeadImgUrl;
		}else{
			return fileuploadUtil.filePath(userHeadImg);
		}
	}
}
