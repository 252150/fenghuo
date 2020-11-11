package com.wanjia.infoshopmallmanage.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 主动设置URL匹配路径
 *
 * @author JustryDeng
 * @date 2018年8月4日 上午1:36:38
 */
@Configuration
public class MyURLPatternConfiguration extends WebMvcConfigurationSupport {
	@Value("${file.staticAccessPath}")
	private String staticAccessPath;
	@Value("${file.uploadFolder}")
	private String uploadFolder;
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler(staticAccessPath).addResourceLocations("file:"+uploadFolder);
		super.addResourceHandlers(registry);
	}
}
