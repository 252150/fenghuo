package com.wanjia.infoshopmallmanage.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtil {
	  /**
	  * 判断文件是否为图片<br>
	  * <br>
	  * @param pInput 文件名<br>
	  * @param pImgeFlag 判断具体文件类型<br>
	  * @return 检查后的结果<br>
	  * @throws Exception
	  */
	 public static boolean isPicture(String  pInput
	                           ) throws Exception{

	  // 获得文件后缀名
	  String tmpName = pInput.substring(pInput.lastIndexOf(".") + 1,
	                              pInput.length());
	  // 声明图片后缀名数组
	  String imgeArray [] = {
	    "bmp", "dib",  "gif",
	    "jfif", "jpe","jpeg",
	    "jpg", "png","tif",
	    "tiff", "ico"
	  };
	  // 遍历名称数组
	  for(int i = 0; i<imgeArray.length;i++){
	   // 判断单个类型文件的场合
	   if( imgeArray [i].equals(tmpName)){
	    return true;
	   }

	  }
	  return false;
	 }
	 /**
	  * 包装文件上传字符串
	  * @param fileal 被删除数组
	  * @param filebl 匹配数组
	  * @return
	  */
   public static String fileImages(String[] fileal,String[] filebl) {
		List<String> la = new ArrayList(Arrays.asList(fileal));
		String images="";

		List<String> lb = new ArrayList(Arrays.asList(filebl));
	
	       for(int i=0;i<la.size();i++) {
            	 for(int j=0;j<lb.size();j++) {
            		 
            		 if(la.get(i).equals(lb.get(j)))la.remove(i);
            	 }
             }
		
		if(la!=null&&la.size()>0) {
			for (String string : la) {
				images+=string +",";
			}
		}
		return images;
   }  
}
