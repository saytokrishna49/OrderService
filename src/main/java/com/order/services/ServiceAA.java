package com.order.services;

import com.order.common.base.BaseService;

public class ServiceAA extends BaseService{

	private String outputA;
	
	public ServiceAA(String outputA){
		this.outputA = outputA;
	}

	@Override
	public String callService() throws Exception {
		return outputA + " and outputAA";
	}

}
