package com.order.common.base;

import java.util.concurrent.Callable;

public abstract class BaseService implements Callable<String>{

	public String call() throws Exception {
		return callService();
	}

	public abstract String callService() throws Exception;
		
}
