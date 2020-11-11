package com.wanjia.infoshopmallmanage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanjia.infoshopmallmanage.entity.AddressContact;
import com.wanjia.infoshopmallmanage.mapper.AddressContactMapper;
import com.wanjia.infoshopmallmanage.util.RestResponse;

@Service
public class AddressContactService {
	@Autowired
	private AddressContactMapper addressContactMapper;
	/**
	 * 广告联系
	 * @param addressContact 实体类
	 * @return
	 */
      public RestResponse addressIsContactUpdate(AddressContact addressContact) {
    	 //录入数据
    	int num=  addressContactMapper.update(addressContact);
    	return num>0?RestResponse.ok("联系成功"):RestResponse.fail("联系失败");
      }
      /**
       * 广告联系集合
       * @param addressContact 实体类
       * @return
       */
      public RestResponse addressContactTree(AddressContact addressContact) {
 		 PageHelper.startPage(addressContact.getPageNo(),20);
 		List<AddressContact>list=	addressContactMapper.conditionQuery(addressContact);
 		
 			
 		
 		 PageInfo<AddressContact> page = new PageInfo<AddressContact>(list);
 	    return 	RestResponse.ok("获取成功", page);
      }
}
