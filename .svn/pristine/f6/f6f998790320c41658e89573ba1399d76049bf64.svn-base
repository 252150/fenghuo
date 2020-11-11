package com.wanjia.infoshopmallmanage.util;

/*
 * 随机数生成工具
*/

public class RandomCodeUtil {
		//随机生成6位数字验证码
		public static int createRangeNo()
		{
		    return (int) ((Math.random()*9+1)*100000);
		}
		
		//随机生成9位的推荐码
		public static int createRecommendCode()
		{
		    return (int) ((Math.random()*9+1)*100000000);
		}
		
		//随机生成16位的nonce_str字符串
		public static String createNonceStr()
		{
		    return createRangeNo()+"8888"+createRangeNo();
		}
		
		public static void main(String[] args) {
			System.out.println(createRecommendCode());
		}
}
