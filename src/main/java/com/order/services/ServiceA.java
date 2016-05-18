package com.order.services;

import com.order.common.base.BaseService;

public class ServiceA extends BaseService{

	public ServiceA(){
		
	}
	
	@Override
	public String callService() throws Exception {
		Thread.sleep(3000);
		return "outputA";
	}

	
}
