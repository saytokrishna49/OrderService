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

import com.order.services.ServiceA;

public class ServiceATest {

	private static ServiceA serviceAMock;
	
	@BeforeClass
	public static void mockService() throws Exception{
		serviceAMock = mock(ServiceA.class);
		when(serviceAMock.callService()).thenReturn("ServiceA processed");
		
	}
	@Test
	public void testServiceASuccess() throws Exception{
		String reponse = serviceAMock.callService();
		Assert.assertSame("ServiceA processed", reponse);
	}
	
	@Test
	public void testServiceAThreadSuccess() throws Exception{
		ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		ServiceA serviceA = new ServiceA();
		Future<String> futureA= poolExecutor.submit(serviceA);
		String outputA = futureA.get(4000, TimeUnit.MILLISECONDS);
		Assert.assertSame("outputA", outputA);
	}
	
	@Test(expected = TimeoutException.class)
	public void testServiceAThreadExceptionSuccess() throws Exception{
		ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		ServiceA serviceA = new ServiceA();
		Future<String> futureA= poolExecutor.submit(serviceA);
		futureA.get(2000, TimeUnit.MILLISECONDS);
	}
	
	@Test
	public void testServiceAFailure() throws Exception{
		String reponse = serviceAMock.callService();
		Assert.assertSame("ServiceA processed failure", reponse);
	}
	
	@Test
	public void testServiceAThreadFailure() throws Exception{
		ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		ServiceA serviceA = new ServiceA();
		Future<String> futureA= poolExecutor.submit(serviceA);
		String outputA = futureA.get(4000, TimeUnit.MILLISECONDS);
		Assert.assertSame("output", outputA);
	}
	
	@Test(expected = TimeoutException.class)
	public void testServiceAThreadExceptionFailure() throws Exception{
		ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		ServiceA serviceA = new ServiceA();
		Future<String> futureA= poolExecutor.submit(serviceA);
		futureA.get(4000, TimeUnit.MILLISECONDS);
	}
}
