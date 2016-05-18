package com.order.services;

import com.order.common.base.BaseService;

public class ServiceB extends BaseService{

	public ServiceB(){
	}

	@Override
	public String callService() throws Exception {
		return "OutputB";
	}

}
