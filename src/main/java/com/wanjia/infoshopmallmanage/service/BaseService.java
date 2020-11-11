package com.wanjia.infoshopmallmanage.service;

import com.alibaba.fastjson.JSONObject;
import com.wanjia.infoshopmallmanage.constant.ParamConstant;
import com.wanjia.infoshopmallmanage.entity.EnvParas;
import com.wanjia.infoshopmallmanage.entity.LogisticsCompany;
import com.wanjia.infoshopmallmanage.mapper.EnvParasMapper;
import com.wanjia.infoshopmallmanage.mapper.LogisticsCompanyMapper;
import com.wanjia.infoshopmallmanage.util.HttpUtil;
import com.wanjia.infoshopmallmanage.util.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * @author: wlj
 * @date: 2020/9/27 16:48
 * @version: 1.0
 */
@Slf4j
@Service
public class BaseService {
    @Autowired
    private LogisticsCompanyMapper logisticsCompanyMapper;
    @Autowired
    private EnvParasMapper envParasMapper;
    /**
     * 维护物流公司
     */
    public void maintenanceLogisticsCompany(){
        String host = "http://wuliu.market.alicloudapi.com";
        String path = "/getExpressList";
        Map<String,String> headers = new HashMap<>(1);
        String appcode = "32d5823b74d44442b1e5f28d764331ae";
        headers.put("Authorization","APPCODE " + appcode);
        try {
            HttpResponse response = HttpUtil.doGet(host,path,null,headers,null);
            if(response.getStatusLine().getStatusCode()==200){
                String json = EntityUtils.toString(response.getEntity());
                JSONObject jsonObject = JSONObject.parseObject(json);
                Map<String,String> map = (Map<String, String>) jsonObject.get("result");
                Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
                while(entries.hasNext()){
                    Map.Entry<String, String> entry = entries.next();
                    LogisticsCompany logisticsCompany = new LogisticsCompany();

                    String key = entry.getKey();
                    String value = entry.getValue();
                    logisticsCompany.setExpressCode(key);
                    logisticsCompany.setExpressName(value);
                    if(logisticsCompanyMapper.selectByCode(key) == null){
                        logisticsCompanyMapper.insert(logisticsCompany);
                    }
                }
            }else{
                log.error("调用物流三方接口维护物流公司失败,状态码:{},原因:{}",response.getStatusLine().getStatusCode(),response.getStatusLine().getReasonPhrase());
            }
        } catch (IOException ioException) {
           log.error("维护物流公司失败,异常：{}",ioException.getMessage());
        }
        catch (Exception e){
            log.error("维护物流公司失败,异常：{}",e.getMessage());
        }
    }

    /**
     * 获取物流公司
     * @return
     */
    public RestResponse getLogisticsCompany(){
        List<LogisticsCompany> list = logisticsCompanyMapper.selectAll();
        return RestResponse.ok("查询成功",list);
    }

    /**
     * 设置积分比例
     * @param integralRatio
     * @return
     */
    public RestResponse setIntegralRatio(Integer integralRatio) {
        EnvParas envParas = new EnvParas();
        envParas.setParaKey(ParamConstant.PROPORTION_INTEGRAL_KEY);
        envParas.setParaValue(String.valueOf(integralRatio));
        envParas.setUpdateTime(new Date());
        if(envParasMapper.updateByParaKey(envParas)>0){
            return RestResponse.ok("修改成功");
        }
        return RestResponse.fail("修改失败");
    }

    public RestResponse getIntegralRatio(){
        Integer integralRatio = Integer.valueOf(envParasMapper.selectByKey(ParamConstant.PROPORTION_INTEGRAL_KEY));
        return RestResponse.ok("查询成功",integralRatio);
    }
}
