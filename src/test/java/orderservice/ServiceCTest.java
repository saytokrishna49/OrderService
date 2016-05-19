package orderservice;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.order.services.ServiceC;

public class ServiceCTest {
	
	private static ServiceC serviceCMock;
	
	@BeforeClass
	public static void mockService() throws Exception{
		serviceCMock = mock(ServiceC.class);
		when(serviceCMock.callService()).thenReturn("ServiceC processed");
		
	}
	
	@Test
	public void testServiceCSuccess() throws Exception{
		String response = serviceCMock.callService();
		Assert.assertSame("ServiceC processed", response);
	}
	
	@Test
	public void testServiceCFailure() throws Exception{
		String response = serviceCMock.callService();
		Assert.assertSame("ServiceC failed", response);
	}
}
