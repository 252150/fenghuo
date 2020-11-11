package com.wanjia.infoshopmallmanage.util;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AesUtil {
	/** 
     *	 密钥算法 
     */  
    private static final String ALGORITHM = "AES";
    
    /** 
     * 	加解密算法/工作模式/填充方式 
     */  
    private static final String ALGORITHM_MODE_PADDING = "AES/ECB/PKCS7Padding";  
    
    /** 
     * 	生成key 
     */
    private static SecretKeySpec createSecretKey(String apiKey)
    {
    	return new SecretKeySpec(MD5Utils.MD5Encode(apiKey).toLowerCase().getBytes(), ALGORITHM);
    }
  
    /** 
     * AES加密 
     *  
     * @param data 
     * @return 
     * @throws Exception 
     */  
    public static String encryptData(String data,String apiKey) throws Exception {  
        // 创建密码器  
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);  
        // 初始化  
        cipher.init(Cipher.ENCRYPT_MODE, createSecretKey(apiKey));
        Base64.Encoder encoder = Base64.getEncoder();
        return new String(encoder.encode(cipher.doFinal(data.getBytes())));  
    }  
  
    /** 
     * AES解密 
     *  
     * @param base64Data 
     * @return 
     * @throws Exception 
     */  
    public static String decryptData(String base64Data,String apiKey) throws Exception {  
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING);  
        cipher.init(Cipher.DECRYPT_MODE, createSecretKey(apiKey));
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(cipher.doFinal(decoder.decode(base64Data)));  
    }
}
