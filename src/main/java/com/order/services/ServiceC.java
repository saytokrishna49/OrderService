package com.order.services;

import com.order.common.base.BaseService;

public class ServiceC extends BaseService{
	
	private String outputAA;
	private String outputB;
	
	public ServiceC(String outputAA, String outputB){
		this.outputAA = outputAA;
		this.outputB = outputB;
	}

	@Override
	public String callService() throws Exception {
		return outputAA.concat(outputB);
	}

}
