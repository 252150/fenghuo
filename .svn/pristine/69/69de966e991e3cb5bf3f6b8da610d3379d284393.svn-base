package com.wanjia.infoshopmallmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wanjia.infoshopmallmanage.entity.AddressContact;
import com.wanjia.infoshopmallmanage.service.AddressContactService;
import com.wanjia.infoshopmallmanage.util.RestResponse;

@RestController
@RequestMapping("/advertiseContact")
public class AddressContactController {
	@Autowired
    private AddressContactService addressContactService;
	
	/**
	 * 联系客户
	 * @param id 广告id
	 * @param isContact 是否联系 0（默认）未联系 1已联系
	 * @return
	 */
	@GetMapping("/addressContactIsContact")
	 public RestResponse update(Long id ,Integer isContact) {
		 AddressContact ac=new AddressContact();
		 ac.setId(id);
		 ac.setIsContact(isContact);
		return  addressContactService.addressIsContactUpdate(ac);
	 }
	/**
	 * 联系数据获取
	 * @param addressContact
	 * @return
	 */
	@PostMapping("/addressContactList")
	public RestResponse list(@RequestBody AddressContact addressContact) {
	return	addressContactService.addressContactTree(addressContact);
	}
}
