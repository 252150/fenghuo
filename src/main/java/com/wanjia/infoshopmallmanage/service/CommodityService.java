package com.wanjia.infoshopmallmanage.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanjia.infoshopmallmanage.entity.*;
import com.wanjia.infoshopmallmanage.mapper.*;
import com.wanjia.infoshopmallmanage.util.FileuploadUtil;
import com.wanjia.infoshopmallmanage.util.RestResponse;
import com.wanjia.infoshopmallmanage.util.StringUtil;
import com.wanjia.infoshopmallmanage.util.TreeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

/**
 * @author: wlj
 * @date: 2020/9/28 13:39
 * @version: 1.0
 */
@Service
@Slf4j
public class CommodityService {
    @Autowired
    private FileuploadUtil fileuploadUtil;
    @Autowired
    private GoodsSortMapper goodsSortMapper;
    @Autowired
    private GoodsParamModuleMapper goodsParamModuleMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private GoodsParamsMapper goodsParamsMapper;
    @Autowired
    private GoodsPropertyMapper goodsPropertyMapper;
    @Autowired
    private GoodsSizeMapper goodsSizeMapper;
    @Autowired
    private GoodsPriceMapper goodsPriceMapper;
    /**
     * 添加商品分类
     * @param goodsSort
     * @param file
     * @return
     */
    public RestResponse addGoodsSort(GoodsSort goodsSort, MultipartFile file) {
        goodsSort.setSortImage(fileuploadUtil.fileUpload(file,"goodsSortImg"));
        goodsSort.setAddTime(new Date());
        if(goodsSortMapper.insert(goodsSort)>0){
            return RestResponse.ok("添加成功");
        }
        return RestResponse.fail("添加失败");
    }

    /**
     * 修改商品分类
     * @param goodsSort
     * @param file
     * @return
     */
    public RestResponse updateGoodsSort(GoodsSort goodsSort,MultipartFile file){
          goodsSort.setSortImage(fileuploadUtil.fileUpload(file,"goodsSortImg"));
          //删除原来的图标
          if(!StringUtil.isEmpty(goodsSort.getSortImage())){
              GoodsSort goodsSort1 = goodsSortMapper.queryById(goodsSort.getId());
              fileuploadUtil.removeUserFile(goodsSort1.getSortImage());
          }
        if(goodsSortMapper.update(goodsSort)>0){
            return RestResponse.ok("修改成功");
        }
        return RestResponse.fail("修改失败");
    }

    /**
     * 获取商品分类
     * @return
     */
    public RestResponse getGoodsSort(GoodsSort goodsSort){
        List<GoodsSort> list = TreeUtil.createTree(goodsSortMapper.queryAll(goodsSort));
        return RestResponse.ok("查询成功",list);
    }

    /**
     * 添加分类参数模板
     * @param goodsParamModule
     * @return
     */
    public RestResponse addParamsTemplate(GoodsParamModule goodsParamModule){
        if(goodsParamModuleMapper.insert(goodsParamModule)>0){
            return RestResponse.ok("添加成功",goodsParamModule.getId());
        }
        return RestResponse.fail("添加失败");
    }

    /**
     * 修改分类参数模板
     * @param goodsParamModule
     * @return
     */
    public RestResponse updateParamsTemplate(GoodsParamModule goodsParamModule){
        if(goodsParamModuleMapper.update(goodsParamModule)>0){
            return RestResponse.ok("修改成功");
        }
        return RestResponse.fail("修改失败");
    }

    /**
     * 删除参数分类模板
     * @param id
     * @return
     */
    public RestResponse delParamsTemplate(Long id){
        if(goodsParamModuleMapper.deleteById(id)>0){
            return RestResponse.ok("删除成功");
        }
        return RestResponse.fail("删除失败");
    }

    /**
     * 获取当前分类的参数模板
     * @param goodsSortId
     * @return
     */
    public RestResponse getParamsTemplate(Long goodsSortId){
        GoodsParamModule goodsParamModule = new GoodsParamModule();
        goodsParamModule.setGoodsSortId(goodsSortId);
        List<GoodsParamModule> list = goodsParamModuleMapper.queryAll(goodsParamModule);
        return RestResponse.ok("查询成功",list);
    }

    /**
     * 添加商品
     * @param goods
     * @return
     */
    public RestResponse addGoods(Goods goods,MultipartFile recommend, List<MultipartFile> rotation, List<MultipartFile> details) {
        goods.setRecommendImage(fileuploadUtil.fileUpload(recommend,"goodsImg"));
        goods.setRotationImages(fileuploadUtil.batchFileUpload(rotation,"goodsImg"));
        goods.setGoodsDescription(fileuploadUtil.batchFileUpload(details,"goodsImg"));
        goods.setAddTime(new Date());
        if(goodsMapper.insert(goods)>0){
            //添加商品参数
            if(goods.getGoodsParams()!=null && !goods.getGoodsParams().isEmpty()){
                goodsParamsMapper.batchInsert(goods.getGoodsParams(),goods.getId());
            }
            return RestResponse.ok("添加成功",goods.getId());
        }
        return RestResponse.fail("添加失败");
    }

    /**
     * 修改商品
     * @param goods
     * @return
     */
    public RestResponse updateGoods(Goods goods,MultipartFile recommend, List<MultipartFile> rotation, List<MultipartFile> details) {
        Goods goods1 = goodsMapper.queryById(goods.getId());
        goods.setRecommendImage(fileuploadUtil.fileUpload(recommend,"goodsImg"));
        goods.setRotationImages(fileuploadUtil.batchFileUpload(rotation,"goodsImg"));
        goods.setGoodsDescription(fileuploadUtil.batchFileUpload(details,"goodsImg"));
        if(goodsMapper.update(goods)>0){
            //删除原来的推荐图
            if(StringUtil.isNotEmpty(goods.getRecommendImage())){
                fileuploadUtil.removeUserFile(goods1.getRecommendImage());
            }
            //删除原来的轮播图
            if(StringUtil.isNotEmpty(goods.getRotationImages())){
                fileuploadUtil.removeFile(goods1.getRotationImages());
            }
            //删除原来的详情图
            if(StringUtil.isNotEmpty(goods.getGoodsDescription())){
                fileuploadUtil.removeFile(goods1.getGoodsDescription());
            }
            return RestResponse.ok("修改成功");
        }
        return RestResponse.fail("修改失败");
    }

    /**
     * 商品上架或下架
     * @param goods
     * @return
     */
    public RestResponse goodsOnAndOff(Goods goods){
        if(goods.getId()==null||goods.getGoodsStatus()==null){
            return RestResponse.fail("操作失败");
        }
        //上架商品
        if(goods.getGoodsStatus() == 1){
            Integer count = goodsPriceMapper.countByGoodsId(goods.getId());
            if( count < 1){
                return RestResponse.fail("商品价格表未设置完成,不能上架商品");
            }
        }
        if(goodsMapper.update(goods)>0){
            return RestResponse.ok("操作成功");
        }
        return RestResponse.fail("操作失败");
    }
    /**
     * 商品查询
     * @param map
     * @return
     */
    public RestResponse queryGoods(Map<String, Object> map) {
        Integer page = 1;
        Integer pageSize = 20;
        if(map.containsKey("page")){
            page = (Integer) map.get("page");
        }
        if(map.containsKey("pageSize")){
            pageSize = (Integer) map.get("pageSize");
        }
        PageHelper.startPage(page, pageSize);
        List<Goods> list = goodsMapper.queryAll(map);
        int total = (int)new PageInfo<>(list).getTotal();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("list",list);
        map1.put("total",total);
        return RestResponse.ok("查询成功",map1);
    }

    /**
     * 获取商品参数
     * @param goodsId
     * @return
     */
    public RestResponse getGoodsParams(Long goodsId) {
        List<GoodsParams> goodsParams = goodsParamsMapper.selectByGoodsId(goodsId);
        return RestResponse.ok("查询成功",goodsParams);
    }

    /**
     * 添加商品参数
     * @param goodsParams
     * @return
     */
    public RestResponse addGoodsParam(GoodsParams goodsParams) {
        if(goodsParamsMapper.insert(goodsParams)>0){
            return RestResponse.ok("操作成功",goodsParams.getId());
        }
        return RestResponse.fail("操作失败");
    }

    /**
     * 修改商品参数
     * @param goodsParams
     * @return
     */
    public RestResponse updateGoodsParam(GoodsParams goodsParams) {
        if(goodsParamsMapper.update(goodsParams)>0){
            return RestResponse.ok("操作成功");
        }
        return RestResponse.fail("操作失败");
    }
    /**
     * 删除商品参数
     * @param id
     * @return
     */
    public RestResponse delGoodsParam(Long id) {
        if(goodsParamsMapper.deleteById(id)>0){
            return RestResponse.ok("操作成功");
        }
        return RestResponse.fail("操作失败");
    }

    /**
     * 添加商品属性
     * @param goodsPropertyList
     * @return
     */
    public RestResponse addGoodsProperty(List<GoodsProperty> goodsPropertyList) {
        if(goodsPropertyList == null || goodsPropertyList.isEmpty()){
            return RestResponse.fail("提交数据不能为空");
        }
        for(GoodsProperty goodsProperty:goodsPropertyList) {
            if (goodsProperty.getGoodsSizes() == null || goodsProperty.getGoodsSizes().isEmpty()) {
                return RestResponse.fail(goodsProperty.getGoodsPropertyName()+"属性规格至少设置一个");
            }
        }
        Long goodsId = goodsPropertyList.get(0).getGoodsId();
        //添加属性之前先清空
        goodsPropertyMapper.deleteByGoodsId(goodsId);
        goodsSizeMapper.deleteByGoodsId(goodsId);
        for(GoodsProperty goodsProperty:goodsPropertyList){
            if(goodsPropertyMapper.insert(goodsProperty)>0){
                goodsSizeMapper.batchInsert(goodsProperty.getGoodsSizes(),goodsProperty.getId());
            }
        }
        //清空商品价格表
        goodsPriceMapper.deleteByGoodsId(goodsId);
        return RestResponse.ok("操作成功",produceGoods(goodsId));
    }

    /**
     * 删除商品属性
     * @param id
     * @return
     */
    public RestResponse delGoodsProperty(Long id) {
        if(goodsPropertyMapper.deleteById(id)>0){
            //删除规格
            goodsSizeMapper.deleteByPropertyId(id);
            return RestResponse.ok("操作成功");
        }
        return RestResponse.fail("操作失败");
    }

    /**
     * 添加商品规格
     * @param goodsSize
     * @return
     */
    public RestResponse addGoodsSize(GoodsSize goodsSize){
        if(goodsSizeMapper.insert(goodsSize)>0){
            return RestResponse.ok("操作成功",goodsSize.getId());
        }
        return RestResponse.fail("操作失败");
    }

    /**
     * 删除商品规格
     * @param id
     * @return
     */
    public RestResponse delGoodsSize(Long id){
        if(goodsSizeMapper.deleteById(id)>0){
            return RestResponse.ok("操作成功");
        }
        return RestResponse.fail("操作失败");
    }

    /**
     * 查询商品属性
     * @param goodsId
     * @return
     */
    public RestResponse getGoodsProperty(Long goodsId) {
        List<GoodsProperty> goodsProperties = goodsPropertyMapper.selectByGoodsId(goodsId);
        return RestResponse.ok("查询成功",goodsProperties);
    }

    /**
     * 生成价格表
     * @param goodsId
     * @return
     */
    public RestResponse produceGoods(Long goodsId){
        List<GoodsProperty> goodsProperties = goodsPropertyMapper.selectByGoodsId(goodsId);
        return RestResponse.ok("生成成功",descartes(goodsProperties));
    }

    /**
     * 提交价格表
     * @param goodsPriceList
     * @return
     */
    public RestResponse submitPriceList(List<GoodsPrice> goodsPriceList){
        if(goodsPriceList.isEmpty()){
            return RestResponse.fail("提交失败");
        }
        goodsPriceMapper.deleteByGoodsId(goodsPriceList.get(0).getGoodsId());
        if(goodsPriceMapper.batchInsert(goodsPriceList)>0){
            //设置商品价格和库存
            goodsMapper.updateMinPrice(goodsPriceList.get(0).getGoodsId());
            return RestResponse.ok("提交成功");
        }
        return RestResponse.fail("提交失败");
    }
    /**
     * 计算 多个集合的笛卡尔积
     * @param dimValues 存储多个集合的 二维list
     * @return
     */
    private static List<GoodsPrice> descartes(List<GoodsProperty> dimValues) {
        List<GoodsPrice> result = new ArrayList<>();
        for (int i = 0 ; i < dimValues.size() ; i++){
            List<GoodsSize> curList = dimValues.get(i).getGoodsSizes();
            //如果是首个集合，直接放输入到结果集中
            if(0 == i){
                for (GoodsSize goodsSize : curList){
                    GoodsPrice goodsPrice = new GoodsPrice();
                    goodsPrice.setGoodsId(goodsSize.getGoodsId());
                    goodsPrice.setGoodsPropertyValue(goodsSize.getGoodsPropertyName()+":"+goodsSize.getGoodsPropertyValue());
                    goodsPrice.setGoodsPropertyOnlyValue(goodsSize.getId().toString());
                    goodsPrice.setGoodsPropertySaleNum(0);
                    result.add(goodsPrice);
                }
                continue;
            }
            //将前一个集合的乘积 result，自我复制 curListCount 份，并将当前集合的元素追加到上边
            selfCopy(result,curList);
        }
        //规格id小的排在前面
        for(GoodsPrice goodsPrice:result){
            String [] array = goodsPrice.getGoodsPropertyOnlyValue().split(",");
            Integer[] goodsSizeId = new Integer[array.length];
            for(int i = 0;i<array.length;i++){
                goodsSizeId[i] = Integer.valueOf(array[i]);
            }
            Arrays.sort(goodsSizeId);
            //Integer[]转成用逗号隔开的字符串
            String str2 = ArrayUtils.toString(goodsSizeId);
            goodsPrice.setGoodsPropertyOnlyValue(str2.substring(1,str2.length()-1));
        }
        return result;
    }

    /**
     * 获取商品价格表
     * @param goodsId
     * @return
     */
    public RestResponse getPriceList(Long goodsId) {
        List<GoodsPrice> list = goodsPriceMapper.selectByGoodsId(goodsId);
        return RestResponse.ok("查询成功",list);
    }

    /**
     * 根据当前的集合，将之前的结果集复制
     * @param result　　之前的集合相称的结果集
     * @param curList　　当前集合
     */
    private static void selfCopy(List<GoodsPrice> result,List<GoodsSize> curList) {
        List<GoodsPrice> tempList = new ArrayList<>();
        for (GoodsSize goodsSize : curList){
            for (GoodsPrice goodsPrice1: result){
                GoodsPrice goodsPrice = new GoodsPrice();
                goodsPrice.setGoodsId(goodsPrice1.getGoodsId());
                goodsPrice.setGoodsPropertyValue(goodsPrice1.getGoodsPropertyValue()+","+goodsSize.getGoodsPropertyName()+":"+goodsSize.getGoodsPropertyValue());
                goodsPrice.setGoodsPropertyOnlyValue(goodsPrice1.getGoodsPropertyOnlyValue()+","+goodsSize.getId().toString());
                tempList.add(goodsPrice);
            }
        }
        result.clear();
        for (GoodsPrice goodsPrice : tempList){
            result.add(goodsPrice);
        }
    }

    /**
     * 批量添加商品参数
     * @param goodsParams
     * @return
     */
    public RestResponse batchAddGoodsParam(List<GoodsParams> goodsParams) {
        if(goodsParams!=null && !goodsParams.isEmpty()){
            goodsParamsMapper.batchInsert(goodsParams,goodsParams.get(0).getGoodsId());
            return RestResponse.ok("添加成功");
        }
        return RestResponse.fail("添加失败");
    }

    /**
     * 删除商品分类
     * @param id
     * @return
     */
    public RestResponse delGoodsSort(Long id) {
        if(goodsSortMapper.deleteChildById(id)>0){
            return RestResponse.ok("删除成功");
        }
        return RestResponse.fail("删除失败");
    }

    /**
     * 删除商品
     * @param goodsId
     * @return
     */
    public RestResponse delGoods(Long goodsId) {
        Goods goods = new Goods();
        goods.setId(goodsId);
        goods.setIsDelete(1);
        if(goodsMapper.update(goods)>0){
            return RestResponse.ok("删除成功");
        }else{
            return RestResponse.fail("删除失败");
        }
    }
}
