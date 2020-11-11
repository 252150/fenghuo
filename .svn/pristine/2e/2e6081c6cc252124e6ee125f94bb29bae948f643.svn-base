package com.wanjia.infoshopmallmanage.util;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IKAnalyzerUtil {
	/**
	 * 
	 * @param msg 过滤句子
	 * @return 过滤后的句子
	 * @throws IOException
	 */
	public static String cut(String msg) throws IOException {
        StringReader sr=new StringReader(msg);
        IKSegmenter ik=new IKSegmenter(sr, true);
        Lexeme lex=null;
        List<String> list=new ArrayList<>();
        while((lex=ik.next())!=null){
            list.add(lex.getLexemeText());
        }
        String returnString ="";
        for (String string : list) {
        	returnString+=string;
		}
        return returnString;
    }

    public static String  specialCharacters(String msg) {
    	String regEx="[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？]";

    	//可以在中括号内加上任何想要替换的字符，实际上是一个正则表达式

    	String aa = " ";//这里是将特殊字符换为aa字符串," "代表直接去掉

    	 Pattern p = Pattern.compile(regEx);

    	  Matcher m = p.matcher(msg);//这里把想要替换的字符串传进来

    	 String newString = m.replaceAll("").trim();
    	 return newString;
    }
    //Ik敏感词过滤器
    public static Boolean Ikbool(String Ikbool) {
    	Boolean bool=false;
    	try {
			if(exChange(specialCharacters(Ikbool)).equals(cut(Ikbool))) {
				bool=true;
				return bool;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      return bool;
    }
//    public static String  ChangeLetter() {
//       
//            String s1 = new String("Hello world");
//            char[] s2 = s1.toCharArray();
//            System.out.println(s2);
//            for(int i=0;i<s2.length;i++){
//                if(Character.isUpperCase(s2[i])){
//                    s2[i] = Character.toLowerCase(s2[i]);
//                }
//                if(Character.isLowerCase(s2[i])){
//                    s2[i] = Character.toUpperCase(s2[i]);
//                }
//            }
//            System.out.println(s2);
//        return s2;
//    }
    public static String exChange(String str){
		StringBuffer sb = new StringBuffer();
		if(str!=null){
			for(int i=0;i<str.length();i++){
				char c = str.charAt(i);
				if(Character.isUpperCase(c)){
					sb.append(Character.toLowerCase(c));
				}else {
					sb.append(c); 
				}
			}
		}
		
		return sb.toString();
	}

    public static void main(String[] args) throws IOException {
        String text="198964";
       System.out.println(exChange(text));
      String list=IKAnalyzerUtil.cut(text);
      System.out.print(exChange(specialCharacters(text)).equals(cut(text)));
    }

}
