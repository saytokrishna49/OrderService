package orderservice;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.order.services.ServiceB;

public class ServiceBTest {
	
	private static ServiceB serviceBMock;
	
	@BeforeClass
	public static void mockService() throws Exception{
		serviceBMock = mock(ServiceB.class);
		when(serviceBMock.callService()).thenReturn("ServiceB processed");
		
	}
	
	@Test
	public void testServiceBSuccess() throws Exception{
		String response = serviceBMock.callService();
		Assert.assertSame("ServiceB processed", response);
	}
	
	@Test
	public void testServiceBThreadSuccess() throws Exception{
		ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		ServiceB serviceB = new ServiceB();
		Future<String> futureB= poolExecutor.submit(serviceB);
		String outputB = futureB.get(4000, TimeUnit.MILLISECONDS);
		Assert.assertSame("outputB", outputB);
	}
	
	@Test(expected = TimeoutException.class)
	public void testServiceBThreadExceptionSuccess() throws Exception{
		ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		ServiceB serviceB = new ServiceB();
		Future<String> futureB= poolExecutor.submit(serviceB);
		futureB.get(2000, TimeUnit.MILLISECONDS);
	}
	
	@Test
	public void testServiceBFailure() throws Exception{
		String response = serviceBMock.callService();
		Assert.assertSame("ServiceB failed", response);
	}
	
	@Test
	public void testServiceBThreadFailure() throws Exception{
		ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		ServiceB serviceB = new ServiceB();
		Future<String> futureB= poolExecutor.submit(serviceB);
		String outputB = futureB.get(4000, TimeUnit.MILLISECONDS);
		Assert.assertSame("output", outputB);
	}
	
	@Test(expected = TimeoutException.class)
	public void testServiceBThreadExceptionFailure() throws Exception{
		ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		ServiceB serviceB = new ServiceB();
		Future<String> futureB= poolExecutor.submit(serviceB);
		futureB.get(4000, TimeUnit.MILLISECONDS);
	}
}
