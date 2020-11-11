package com.wanjia.infoshopmallmanage.controller;

import com.wanjia.infoshopmallmanage.entity.*;
import com.wanjia.infoshopmallmanage.service.CommodityService;
import com.wanjia.infoshopmallmanage.util.RestResponse;
import com.wanjia.infoshopmallmanage.validated.Groups;
import com.wanjia.infoshopmallmanage.validated.ValidList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;


/**
 * @author: wlj
 * @date: 2020/9/28 10:41
 * @version: 1.0
 */
@Validated
@RestController
@RequestMapping("/commodity")
public class CommodityController {
    @Autowired
    private CommodityService commodityService;

    /**
     * 添加商品
     * @param goods
     * @return
     */
   @PostMapping("/addGoods")
   public RestResponse addGoods(@Validated({Groups.Insert.class}) Goods goods, @NotNull(message = "推荐图不能为空") MultipartFile recommend,
                                @NotEmpty(message = "轮播图不能为空") List<MultipartFile> rotation,  List<MultipartFile> details){
       return commodityService.addGoods(goods,recommend,rotation,details);
   }

    /**
     * 修改商品
     * @param goods
     * @return
     */
    @PostMapping("/updateGoods")
    public RestResponse updateGoods( Goods goods,MultipartFile recommend, List<MultipartFile> rotation, List<MultipartFile> details){
        return commodityService.updateGoods(goods,recommend,rotation,details);
    }

    /**
     * 删除商品
     * @param goodsId
     * @return
     */
    @GetMapping("/delGoods")
    public RestResponse delGoods(Long goodsId){
        return commodityService.delGoods(goodsId);
    }


    /**
     * 添加商品分类
     * @param goodsSort
     * @param file
     * @return
     */
    @PostMapping("/addGoodsSort")
    public RestResponse addGoodsSort(@Validated({Groups.Insert.class}) GoodsSort goodsSort,@RequestParam("file") MultipartFile file){
        return commodityService.addGoodsSort(goodsSort,file);
    }

    /**
     * 修改商品分类
     * @param goodsSort
     * @param file
     * @return
     */
    @PostMapping("/updateGoodsSort")
    public RestResponse updateGoodsSort(GoodsSort goodsSort, MultipartFile file){
        return commodityService.updateGoodsSort(goodsSort,file);
    }

    /**
     * 获取商品分类
     * @param goodsSort
     * @return
     */
    @GetMapping("/getGoodsSort")
    public RestResponse getGoodsSort(GoodsSort goodsSort){
        return commodityService.getGoodsSort(goodsSort);
    }

    /**
     * 添加分类参数模板
     * @param goodsParamModule
     * @return
     */
    @PostMapping("/addParamsTemplate")
    public RestResponse addParamsTemplate(@RequestBody @Validated GoodsParamModule goodsParamModule){
        return commodityService.addParamsTemplate(goodsParamModule);
    }
    /**
     * 修改分类参数模板
     * @param goodsParamModule
     * @return
     */
    @PostMapping("/updateParamsTemplate")
    public RestResponse updateParamsTemplate(@RequestBody GoodsParamModule goodsParamModule){
        return commodityService.updateParamsTemplate(goodsParamModule);
    }
    /**
     * 删除参数分类模板
     * @param id
     * @return
     */
    @GetMapping("/delParamsTemplate")
    public RestResponse delParamsTemplate(Long id){
        return commodityService.delParamsTemplate(id);
    }
    /**
     * 获取当前分类的参数模板
     * @param goodsSortId
     * @return
     */
    @GetMapping("/getParamsTemplate")
    public RestResponse getParamsTemplate(Long goodsSortId){
        return commodityService.getParamsTemplate(goodsSortId);
    }

    /**
     * 查询商品
     * @param map
     * @return
     */
    @PostMapping("/queryGoods")
    public RestResponse queryGoods(@RequestBody Map<String,Object> map){
        return commodityService.queryGoods(map);
    }
    /**
     * 获取商品参数
     * @param goodsId
     * @return
     */
    @GetMapping("/getGoodsParams")
    public RestResponse getGoodsParams(Long goodsId){
        return commodityService.getGoodsParams(goodsId);
    }

    /**
     * 添加商品参数
     * @param goodsParams
     * @return
     */
    @PostMapping("/addGoodsParam")
    public RestResponse addGoodsParam(@RequestBody @Validated GoodsParams goodsParams){
        return commodityService.addGoodsParam(goodsParams);
    }

    /**
     * 批量添加商品参数
     * @param goodsParams
     * @return
     */
    @PostMapping("/batchAddGoodsParam")
    public RestResponse batchAddGoodsParam(@RequestBody @Validated ValidList<GoodsParams> goodsParams){
        return commodityService.batchAddGoodsParam(goodsParams);
    }

    /**
     * 修改商品参数
     * @param goodsParams
     * @return
     */
    @PostMapping("/updateGoodsParam")
    public RestResponse updateGoodsParam(@RequestBody GoodsParams goodsParams){
        return commodityService.updateGoodsParam(goodsParams);
    }

    /**
     * 删除商品参数
     * @param id
     * @return
     */
    @GetMapping("/delGoodsParam")
    public RestResponse delGoodsParam(Long id){
        return commodityService.delGoodsParam(id);
    }

    /**
     * 添加商品属性
     * @param goodsPropertyList
     * @return
     */
    @PostMapping("/addGoodsProperty")
    public RestResponse addGoodsProperty(@RequestBody @Validated ValidList<GoodsProperty> goodsPropertyList){
        return commodityService.addGoodsProperty(goodsPropertyList);
    }

    /**
     * 删除商品属性
     * @param id
     * @return
     */
    @GetMapping("/delGoodsProperty")
    public RestResponse delGoodsProperty(Long id){
        return commodityService.delGoodsProperty(id);
    }

    /**
     * 添加商品规格
     * @param goodsSize
     * @return
     */
    @PostMapping("/addGoodsSize")
    public RestResponse addGoodsSize(@RequestBody @Validated GoodsSize goodsSize){
        return commodityService.addGoodsSize(goodsSize);
    }

    /**
     * 删除商品规格
     * @param id
     * @return
     */
    @GetMapping("/delGoodsSize")
    public RestResponse delGoodsSize(Long id){
        return commodityService.delGoodsSize(id);
    }

    /**
     * 获取商品的属性
     * @param goodsId
     * @return
     */
    @GetMapping("/getGoodsProperty")
    public RestResponse getGoodsProperty(Long goodsId){
        return commodityService.getGoodsProperty(goodsId);
    }

    /**
     * 生成价格表
     * @param goodsId
     * @return
     */
    @GetMapping("/ProduceGoods")
    public RestResponse ProduceGoods(Long goodsId){
        return commodityService.produceGoods(goodsId);
    }

    /**
     * 提交价格表
     * @param goodsPriceList
     * @return
     */
    @PostMapping("/submitPriceList")
    public RestResponse submitPriceList(@RequestBody @Validated ValidList<GoodsPrice> goodsPriceList){
        return commodityService.submitPriceList(goodsPriceList);
    }

    /**
     * 获取商品价格表
     * @param goodsId
     * @return
     */
    @GetMapping("/getPriceList")
    public RestResponse getPriceList(Long goodsId){
        return commodityService.getPriceList(goodsId);
    }

    /**
     * 删除商品分类
     * @param id
     * @return
     */
    @GetMapping("/delGoodsSort")
    public RestResponse delGoodsSort(Long id){
        return commodityService.delGoodsSort(id);
    }


    /**
     * 商品上架或下架
     * @param goods
     * @return
     */
    @PostMapping("/goodsOnAndOff")
    public RestResponse goodsOnAndOff(@RequestBody Goods goods){
        return commodityService.goodsOnAndOff(goods);
    }
}
