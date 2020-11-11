package com.wanjia.infoshopmallmanage.service;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.impl.client.CloseableHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wanjia.infoshopmallmanage.entity.Order;
import com.wanjia.infoshopmallmanage.mapper.OrderMapper;
import com.wanjia.infoshopmallmanage.model.WxModel;
import com.wanjia.infoshopmallmanage.util.AesUtil;
import com.wanjia.infoshopmallmanage.util.RandomCodeUtil;
import com.wanjia.infoshopmallmanage.util.WxPayUtil;

@Service
public class WxPayService {
	
	@Autowired
	OrderMapper orderMapper;
	
	@Autowired
	WxModel wxModel;
	
	/**
	 * 	向微信官方发送微信退款请求
	 * 	@param orderNo:订单号
	 *  @param mchId:商家的商户号(必须和app官方的appid绑定)
	 * 	@param apiKey:商家的api密匙
	 *  @param certificatePath:商家在微信商户平台的API安全选项中设置的API证书
	 * 	@return
	 * 	@throws Exception 
	 */
	@Transactional
	public void wxRefund(String orderNo,String mchId,String apiKey,String certificatePath) throws Exception
	{
		//校验订单信息
		Order order = orderMapper.selectByOrderNumber(orderNo);
		if (order!=null&&order.getOrderState()==-1) {
			//准备微信退款所需参数
			Map<String, Object> params = new HashMap<String, Object>();
			//公众账号ID
			params.put("appid", wxModel.getAppId());
			// 商户号
	        params.put("mch_id",mchId);
	        // 随机字符串
	        params.put("nonce_str", RandomCodeUtil.createNonceStr());
	        // 商户订单号
	        params.put("out_trade_no", order.getOrderName());
	        // 商户退款单号:商户系统内部的退款单号，商户系统内部唯一(此处就用商户订单号代替)
	        params.put("out_refund_no", order.getOrderName());
	        // 订单金额
	        params.put("total_fee",(order.getPracticalPrice().divide(new BigDecimal(0.01),2,BigDecimal.ROUND_DOWN)).intValue());
	        //退款金额
	        params.put("refund_fee",(order.getPracticalPrice().divide(new BigDecimal(0.01),2,BigDecimal.ROUND_DOWN)).intValue());
	        //微信退款通知url
	        params.put("notify_url",wxModel.getRefundNotifyUrl());
	        //签名
	        params.put("sign", WxPayUtil.sign(params, apiKey));
	        //数据转xml格式
	        String data = WxPayUtil.mapToXml(params);
	        //获取微信退款所需的证书
			CloseableHttpClient httpClient = WxPayUtil.sslHttpsClient(certificatePath, wxModel.getApiKey());
	        //向微信发起退款并获取返回的xml数据
	        String reXml = WxPayUtil.sendSslXmlPost(wxModel.getRefundUrl(), data, null, httpClient);
	        //xml数据转为map
	        Map<String, String> reMap = WxPayUtil.xmlToMap(reXml);
	        //更改订单状态
	        if ("SUCCESS".equals(reMap.get("return_code"))&&"SUCCESS".equals(reMap.get("result_code"))) 
	        {
	        	orderMapper.updateOrderStateByOrderName(orderNo,new Byte((byte) -3));
			}
	        orderMapper.updateOrderStateByOrderName(orderNo,new Byte((byte) -5));
		}
	}
	
	/**
	 * 	微信退款通知
	 * 	@param request
	 * 	@param response
	 * @throws Exception 
	 */
	public void wxRefundNotify(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		//微信回调的xml数据
		String xmlData = WxPayUtil.getRequestData(request);
		Map<String, String> data = WxPayUtil.xmlToMap(xmlData);
		if ("SUCCESS".equals(data.get("return_code"))) {
			try 
			{
            	// 通知微信收到回调
                String resXml = "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
                BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
				out.write(resXml.getBytes());
				out.flush();
	            out.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			//解析加密信息
			//step1:对加密串A做base64解码，得到加密串B
			//step2:对商户apiKey做md5，得到32位小写key
			//step3：用key对加密串B做AES-256-ECB解密(PKCS7Padding)
			//注1：商户apiKey需要通过mchId去数据库中取，此处暂时写死
			//注2：AES加密需要替换JDK的local_policy.jar和US_export_policy.jar
			String apiKey = "qzwerhgjksd";
			String decodeXml = AesUtil.decryptData((String) data.get("req_info"), apiKey);
			Map<String, String> decodeData = WxPayUtil.xmlToMap(decodeXml);
			if ("SUCCESS".equals(decodeData.get("refund_status"))) {
				//更新订单状态
				orderMapper.updateOrderStateByOrderName((String) decodeData.get("out_trade_no"), new Byte((byte) -4));
			}
			orderMapper.updateOrderStateByOrderName((String) decodeData.get("out_trade_no"), new Byte((byte) -5));
		}
	}
}
