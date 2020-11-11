package com.wanjia.infoshopmallmanage.controller;

import com.wanjia.infoshopmallmanage.entity.Order;
import com.wanjia.infoshopmallmanage.service.OrderGoodsService;
import com.wanjia.infoshopmallmanage.util.RestResponse;
import com.wanjia.infoshopmallmanage.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: wlj
 * @date: 2020/10/9 15:42
 * @version: 1.0
 */
@RestController
@RequestMapping("/orderGoods")
public class OrderGoodsController {
    @Autowired
    private OrderGoodsService orderGoodsService;


    /**
     * 查询订单
     * @param order
     * @return
     */
    @PostMapping("/queryOrder")
    public RestResponse queryOrder(@RequestBody Order order){
        return orderGoodsService.queryOrder(order);
    }

    /**
     * 发货
     * @param order
     * @return
     */
    @PostMapping("/deliverGoods")
    public RestResponse deliverGoods(@RequestBody Order order){
        if(StringUtil.isEmpty(order.getExpressOddnumbers())){
            return RestResponse.fail("快递单号不能为空");
        }
        return orderGoodsService.deliverGoods(order);
    }


    /**
     * 物流信息
     * @param number
     * @return
     */
    @GetMapping("/logisticsInfo")
    public RestResponse logisticsInfo(String number){
        return orderGoodsService.logisticsInfo(number);
    }

}
