package com.wanjia.infoshopmallmanage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wanjia.infoshopmallmanage.entity.MessType;
import com.wanjia.infoshopmallmanage.mapper.MessTypeMapper;
import com.wanjia.infoshopmallmanage.util.RestResponse;

@Service
public class MessTypeService {
	  @Autowired
      private MessTypeMapper messTypeMapper;
	  /**
		 * 消息分组新增
		 * 
		 * @param my            MessType实体类
		 * @param multipartFile 文件上传服务器
		 * @return int
		 */
		public RestResponse add(MessType my) {
			my.setCreateTime(new Date());
			if (my.getPid() == null) {
				my.setPid(0l);
			}
			Date date = new Date(System.currentTimeMillis());
			my.setCreateTime(date);
			int num = messTypeMapper.insert(my);
			return num>0?RestResponse.ok("新增成功"):RestResponse.fail("新增失败");
		}

		/**
		 * 
		 * @param my            MessType实体类
		 * @param multipartFile 文件上传服务器
		 * @return int
		 */
		public RestResponse update(MessType my) {
		
			my.setCreateTime(new Date());
			if (my.getPid() == null) {
				my.setPid(0l);
			}
			int num = 0;
			num = messTypeMapper.update(my);
			
			return num>0?RestResponse.ok("修改成功"):RestResponse.fail("修改失败");
		}

		/**
		 * 
		 * @param id  根据id（uid）删除 0（根据id获取文件并删除）
		 * @param uid
		 * @return int
		 */
		public RestResponse delete(Long id) {
			MessType mt = new MessType();
			
			mt.setId(id);

			int num = messTypeMapper.deleteById(id);
			return num>0?RestResponse.ok("删除成功"):RestResponse.fail("删除失败");
		}
		public RestResponse select(MessType my,Integer pageNo) {
			PageHelper.startPage(pageNo,20); 
			List<MessType> list=	messTypeMapper.queryAll(my);
			PageInfo<MessType> page = new PageInfo<MessType>(list);
	    	 return RestResponse.ok("获取成功", page);
		}
}
