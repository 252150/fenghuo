package com.wanjia.infoshopmallmanage.util;

import java.awt.image.BufferedImage;
import  java.io.FileInputStream;
import  java.io.IOException;
import  java.io.InputStream;
import  java.util.HashMap;
import  java.util.Map;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import  org.apache.commons.fileupload.FileItem;
import org.apache.poi.util.StringUtil;
import org.springframework.web.multipart.MultipartFile;



 

/**
  * @Description: 处理上传附件,校验是否合法
  * 在服务器端判断文件类型的问题，故用获取文件头的方式，
  * 
  * @author: huangyawei
  * @Created 2013 2013-8-19下午18:58:15
  */
public  class  CheckoutFileType {
	 

	private static boolean checkImageFile(String fileName) {



        String fileType=fileName.substring(fileName.lastIndexOf(".") + 1);
        String extUpp =fileType.toLowerCase();
       System.out.println(extUpp);  

        //根据扩展名判断是否为要求的视频

       if (!extUpp.matches("^[(mp4)|(flv)|(avi)|(rm)|(rmvb)|(wmv)]+$")) {

            return false;
        }
       

        return true;
    }
	public static void main(String[] args) {
	
		System.out.println(checkImageFile("1.mp4"));
	}
}
