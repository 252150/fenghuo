package com.wanjia.infoshopmallmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wanjia.infoshopmallmanage.entity.MessType;
import com.wanjia.infoshopmallmanage.service.MessTypeService;
import com.wanjia.infoshopmallmanage.util.RestResponse;

@RestController
@RequestMapping("/messType")
public class MessTypeController {
	@Autowired
    private MessTypeService messTypeService;
	/**
	 * 圈子新增
	 * @param my
	 * @return
	 */
	@PostMapping("/add")
	public RestResponse add(@RequestBody MessType my) {
		return messTypeService.add(my);
	}
	/**
	 * 圈子修改
	 * @param my
	 * @return
	 */
	@PostMapping("/update")
	public RestResponse update(@RequestBody MessType my) {
		return messTypeService.update(my);
	}
	/**
	 * 圈子删除
	 * @param id
	 * @return
	 */
	@GetMapping("/delete")
	public RestResponse delete(Long id) {
		return messTypeService.delete(id);
	}
	@PostMapping("/tree")
	public RestResponse tree(@RequestBody MessType my) {
		return messTypeService.select(my,my.getPageNo());
	}
	
}
