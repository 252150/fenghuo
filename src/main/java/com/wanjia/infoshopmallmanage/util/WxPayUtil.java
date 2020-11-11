package com.wanjia.infoshopmallmanage.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WxPayUtil {
	
	private static CloseableHttpClient httpClient;
	
	/**
     * 支付参数生成签名
     *
     * @param params
     * @param apiKey
     * @return
     */
    public static String sign(Map<String, Object> params, String apiKey) {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, Object>> set = new TreeMap<>(params).entrySet();
        for (Map.Entry<String, Object> entry : set) {
            String k = entry.getKey();
            Object v = entry.getValue();
            sb.append(k).append("=").append(v).append("&");
        }
        sb.append("key=").append(apiKey);
        return Objects.requireNonNull(MD5(sb.toString())).toUpperCase();
    }
    
    /**
     * 判断签名是否正确
     *
     * @param xml XML格式数据
     * @param key API密钥
     * @return 签名是否正确
     * @throws Exception
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean isSignatureValid(String xml, String key){
        Map<String, String> data = xmlToMap(xml);
        Map tempMap = data;
        Map<String,Object> destMap = tempMap;
        String sign = data.get("sign");
        destMap.remove("sign");
        return sign.equals(sign(destMap, key));
    }
    
    public static void main(String[] args) {
    	Map<String, String> data = xmlToMap("<xml><coupon_fee><![CDATA[10]]></coupon_fee><appid>wx2421b1c4370ec43b</appid><mehid>1900000109</mehid><sign>57496CCD3524AD9BA531F60102FB3B3D</sign></xml>");
    	// 遍历map中的值
        for (String value : data.values()) {
            System.out.println(value);
        }
    }
    
    /**
     * 生成md5摘要
     *
     * @param content
     * @return
     */
    public static String MD5(String content) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(content.getBytes(StandardCharsets.UTF_8));
            byte[] hashCode = messageDigest.digest();
            return new HexBinaryAdapter().marshal(hashCode).toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * map转换为xml格式
     *
     * @param params
     * @return
     */
    public static String mapToXml(Map<String, Object> params) {
        StringBuilder sb = new StringBuilder();
        Set<Map.Entry<String, Object>> es = params.entrySet();
        Iterator<Map.Entry<String, Object>> it = es.iterator();
        sb.append("<xml>");
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            String k = entry.getKey();
            Object v = entry.getValue();
            sb.append("<").append(k).append(">").append(v).append("</").append(k).append(">");
        }
        sb.append("</xml>");
        return sb.toString();
    }
    
    /**
     * XML格式字符串转换为Map
     *
     * @param xmlStr
     * @return
     */
    public static Map<String, String> xmlToMap(String xmlStr) {
        try (InputStream inputStream = new ByteArrayInputStream(xmlStr.getBytes(StandardCharsets.UTF_8))) {
            Map<String, String> data = new HashMap<>();
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document doc = documentBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getDocumentElement().getChildNodes();
            for (int idx = 0; idx < nodeList.getLength(); ++idx) {
                Node node = nodeList.item(idx);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    data.put(element.getNodeName(), element.getTextContent());
                }
            }
            return data;
        } catch (Exception ex) {
            log.warn("xml convert to map failed message: {}", ex.getMessage());
            return null;
        }
    }
    
    /**
     * 发送post请求请求体为xml
     *
     * @param url
     * @param xml
     * @param headers
     * @return
     */
    public static String sendPostXml(String url, String xml, Map<String, Object> headers) {
        String result = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            setHeaders(headers, httpPost);
            StringEntity entity = new StringEntity(xml, StandardCharsets.UTF_8);
            httpPost.addHeader("Content-Type", "text/xml");
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity responseData = response.getEntity();
            result = EntityUtils.toString(responseData, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 设置请求头信息
     *
     * @param headers
     * @param request
     * @return
     */
    private static void setHeaders(Map<String, Object> headers, HttpRequest request) {
        if (null != headers && headers.size() > 0) {
            for (Map.Entry<String, Object> entry : headers.entrySet()) {
                request.addHeader(entry.getKey(), entry.getValue().toString());
            }
        }
    }
    
    /**
     * 	将request中的数据读取为String字符串(xml)
     *
     * @param request
     * @return
     */
    public static String getRequestData(HttpServletRequest request) {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;
        String line;
        try {
            // 接收request数据流，并指定编码格式接收
            br = new BufferedReader(new InputStreamReader(request.getInputStream(), StandardCharsets.UTF_8));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
    
    /**
     * @param certPath
     * @param password
     * @return
     * @throws Exception
     */
    public static CloseableHttpClient sslHttpsClient(String certPath, String password) throws Exception {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        try (InputStream inputStream = new FileInputStream(new File(certPath))) {
            keyStore.load(inputStream, password.toCharArray());
        }
        SSLContext sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, password.toCharArray()).build();
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        return HttpClients.custom().setSSLSocketFactory(sslConnectionSocketFactory).build();
    }
    
    /**
     * 	发送https的post请求
     * 	@param url
     * 	@param xml
     * 	@param headers
     * 	@param httpClient
     * 	@return
     */
    public static String sendSslXmlPost(String url, String xml, Map<String, Object> headers, CloseableHttpClient httpClient) {
        String result = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            setHeaders(headers, httpPost);
            StringEntity entity = new StringEntity(xml, StandardCharsets.UTF_8);
            httpPost.addHeader("Content-Type", "text/xml");
            httpPost.setEntity(entity);
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity responseData = response.getEntity();
            result = EntityUtils.toString(responseData, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
