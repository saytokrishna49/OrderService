package com.order.services;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.order.exception.OrderException;



public class OrderService {
	
	private long threadWaitTime;
	
	public String processOrder() throws Exception{
		ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		ServiceA serviceA = new ServiceA();
		Future<String> futureA= poolExecutor.submit(serviceA);
		ServiceB serviceB = new ServiceB();
		Future<String> futureB = poolExecutor.submit(serviceB);
		String outputA = null;
		String outputB = null;
		try {
			outputA = futureA.get(threadWaitTime, TimeUnit.MILLISECONDS);
			outputB = futureB.get(threadWaitTime, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			throw new OrderException("Exception invoking services ",e);
		} 
		
		ServiceAA serviceAA = new ServiceAA(outputA);
		String outputAA = serviceAA.callService();
		
		ServiceC serviceC = new ServiceC(outputAA, outputB);
		String outputC = serviceC.callService();
		
		return "success";
		
	}

	public long getThreadWaitTime() {
		return threadWaitTime;
	}

	public void setThreadWaitTime(long threadWaitTime) {
		this.threadWaitTime = threadWaitTime;
	}
}
