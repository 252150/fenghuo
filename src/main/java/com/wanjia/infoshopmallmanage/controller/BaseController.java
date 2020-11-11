package com.wanjia.infoshopmallmanage.controller;

import com.wanjia.infoshopmallmanage.service.BaseService;
import com.wanjia.infoshopmallmanage.util.FileuploadUtil;
import com.wanjia.infoshopmallmanage.util.RestResponse;
import com.wanjia.infoshopmallmanage.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * @author wlj
 */
@Validated
@RestController
@RequestMapping("/base")
public class BaseController {
	@Autowired
	private BaseService baseService;
	@Autowired
	private FileuploadUtil fileuploadUtil;
	/**
	 * 物流公司维护
	 * @return
	 */
	@GetMapping("/logistics")
	public RestResponse logistics(){
		baseService.maintenanceLogisticsCompany();
		return RestResponse.ok("成功");
	}
	@PostMapping("/upload")
	public RestResponse upload(List<MultipartFile> file){
		String url = fileuploadUtil.batchFileUpload(file,"uploadFile");
		if(StringUtil.isEmpty(url)){
			return RestResponse.fail("上传失败");
		}
		return RestResponse.ok("上传成功",url) ;
	}

	/**
	 * 删除文件
	 * @param url
	 * @return
	 */
	@GetMapping("/delFile")
	public RestResponse delFile(String url){
		if(fileuploadUtil.removeFile(url)){
			return RestResponse.ok("删除成功");
		}else{
			return RestResponse.fail("删除失败");
		}
	}
	/**
	 * 获取物流公司
	 * @return
	 */
	@GetMapping("/getLogisticsCompany")
	public RestResponse getLogisticsCompany(){
		return baseService.getLogisticsCompany();
	}

	/**
	 * 设置积分比例
	 * @param integralRatio
	 * @return
	 */
	@GetMapping("/setIntegralRatio")
	public RestResponse setIntegralRatio(@Min(value = 1,message = "只能设置大于0的整数") Integer integralRatio){
		return baseService.setIntegralRatio(integralRatio);
	}
	/**
	 * 获取积分比例
	 * @return
	 */
	@GetMapping("/getIntegralRatio")
	public RestResponse getIntegralRatio(){
		return baseService.getIntegralRatio();
	}
}
