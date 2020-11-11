package com.wanjia.infoshopmallmanage.util;


import com.wanjia.infoshopmallmanage.entity.OperationLog;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/*
解析归档的用户操作日志文件并封装日志内容为List集合的工具类
*/

public class LogResolveUtil 
{
	//读取日志转化为List集合，以便将日志批量插入数据库中
	public static List<OperationLog> logConvertList()
	{
		List<OperationLog> list = new ArrayList<OperationLog>();
		//根据当前日期获取前一天的归档日志文件
		List<File> files = getFiles("E:/springworkspace/infoshopmall/logs/userOperation/"+getBeforeDate());
		//遍历取到的文件集合
		for (File file : files) 
		{
			 try 
			 {
				  //使用 ApacheCommonsIO流逐行读取文件文件
				  String line = "";
			      LineIterator iterator = FileUtils.lineIterator(file, "UTf-8");
			      while (iterator.hasNext()) 
			      {
			    	//取出日志每一行进行解析并封装成对象，最后将对象添加到list集合中
			        line = iterator.nextLine();
			        String[] s = line.split(" - ");
			        // list.add(new OperationLog(Long.parseLong(s[0]),s[1],stringConvertDate(s[2]),s[3],s[4],s[5]));
			      }
			 }
			 catch (IOException e) 
			 {
			      e.printStackTrace();
			 }
		}
		return list;
	}
	
	//获取前一天的日期，以便读取相关日志
	public static String getBeforeDate()
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = (Date) calendar.getTime();
		String format = df.format(date);
		return format;
	}
	
	//将指定格式的字符串转化为date类型，以便存入数据库
	public static Date stringConvertDate(String dateStr)
	{
		Date date = null;
        //获得SimpleDateFormat类，我们转换为yyyy-MM-dd的时间格式
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try 
        {
            //使用SimpleDateFormat的parse()方法生成指定格式的Date
            date = sdf.parse(dateStr);
        } 
        catch (ParseException e) 
        {
            e.printStackTrace();
        }
        return date;
	}
	
	//获取前一天的归档的用户操作日志文件
	public static List<File> getFiles(String path)
	{
        File root = new File(path);
        List<File> files = new ArrayList<File>();
        File[] subFiles = root.listFiles();
        for(File file : subFiles)
        {
           files.add(file);
        }    
        return files;
    }
}
