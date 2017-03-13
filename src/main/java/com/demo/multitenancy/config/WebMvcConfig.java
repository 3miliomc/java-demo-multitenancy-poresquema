package com.demo.multitenancy.config;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Qualifier("tenantInterceptor")
	@Autowired
	  HandlerInterceptor tenantInterceptor;
	
	  @Qualifier("instanceInterceptor")
	  @Autowired
	  HandlerInterceptor instanceInterceptor;
	  
	  @Override
	  public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(tenantInterceptor);
	    registry.addInterceptor(instanceInterceptor);
	  }
}
