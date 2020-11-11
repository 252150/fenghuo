package com.wanjia.infoshopmallmanage.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.wanjia.infoshopmallmanage.entity.Order;
import com.wanjia.infoshopmallmanage.mapper.OrderMapper;
import com.wanjia.infoshopmallmanage.util.HttpUtil;
import com.wanjia.infoshopmallmanage.util.RedisUtil;
import com.wanjia.infoshopmallmanage.util.RestResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: wlj
 * @date: 2020/10/9 15:43
 * @version: 1.0
 */
@Slf4j
@Service
public class OrderGoodsService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private JPushService jPushService;
    /**
     * 查询订单
     * @param order
     * @return
     */
    public RestResponse queryOrder(Order order){
        int page = 1;
        int pageSize = 20;
        if(order.getPage() != null){
            page = order.getPage();
        }
        if(order.getPageSize() != null){
            pageSize = order.getPageSize();
        }
        PageMethod.startPage(page,pageSize);
        List<Order> list = orderMapper.queryAll(order);
        int total =(int) new PageInfo<Order>(list).getTotal();
        return RestResponse.ok("查询成功",list).put("total",total);
    }

    /**
     * 订单发货
     * @param order
     * @return
     */
    public RestResponse deliverGoods(Order order) {
        Order order1 = orderMapper.queryById(order.getId());
        if(order1 == null){
            return RestResponse.fail("订单不存在");
        }
        //订单状态从待发货改为已发货
        if(order1.getOrderState()==0){
            order.setDeliveryTime(new Date());
            order.setOrderState(1);
            if(orderMapper.update(order)>0){
                List<String> alias = new ArrayList<>();
                alias.add(order1.getUserId().toString());
                Map<String,String> map = new HashMap<>(2);
                map.put("type","1");
                map.put("orderNo",order.getOrderName());
                jPushService.sendToAliasList(alias,"订单发货通知","你的购买的商品已发货", map);
                return logisticsInfo(order1.getOrderName());
            }
        }//已发货的订单可以重新修改快递
         else if(order1.getOrderState()==1){
            if(orderMapper.update(order)>0){
                return RestResponse.ok("修改快递成功");
            }
        }
        return logisticsInfo(order1.getOrderName());
    }


    /**
     * 物流信息
     * @param number 订单号
     * @return
     */
    public RestResponse logisticsInfo(String number){

        Order order = orderMapper.selectByOrderNumber(number);
        if(order == null){
            return RestResponse.fail("订单不存在");
        }
        if(redisUtil.hasKey(order.getExpressOddnumbers())){
            return (RestResponse)redisUtil.get(order.getExpressOddnumbers());
        }
        if(order.getExpressOddnumbers() == null){
            return RestResponse.fail("还未发货,请耐心等待");
        }
        String host = "http://wuliu.market.alicloudapi.com";
        String path = "/kdi";
        Map<String,String> headers = new HashMap<>(1);
        String appcode = "32d5823b74d44442b1e5f28d764331ae";
        headers.put("Authorization","APPCODE " + appcode);
        Map<String,String> params = new HashMap<>(2);
        String no = order.getExpressOddnumbers();
        String type = order.getExpressCode();
        //顺丰快递需要手机号后四位
        if("SFEXPRESS".equals(type)){
            no += ":"+order.getUserPhone().substring(order.getUserPhone().length()-4);
        }
        params.put("no",no);
        params.put("type",type);
        try {
            HttpResponse response = HttpUtil.doGet(host,path,null,headers,params);
            if(response.getStatusLine().getStatusCode()!=200){
                log.error("调用物流三方接口失败,状态码:{},原因:{}",response.getStatusLine().getStatusCode(),response.getStatusLine().getReasonPhrase());
                return RestResponse.fail("查询物流信息失败,请稍后再试");
            }
            String json = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = JSON.parseObject(json);
            if(((String)jsonObject.get("status")).equals("0")){
                RestResponse restResponse = RestResponse.ok("查询成功",jsonObject.get("result"));
                //缓存到redis中key快递号，时间30分钟
                redisUtil.set(order.getExpressOddnumbers(),restResponse,30*60L);
                return restResponse;
            }else{
                return RestResponse.fail("未查到物流信息,请检查快递单号是否正确或稍后查看物流信息");
            }
        }catch (Exception e){
            log.error("调物流接口,出现异常,参数{},异常：{number}",e.getMessage());
        }
        return RestResponse.fail("查询物流信息失败,请稍后再试");
    }
}
