package orderservice;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;

import com.order.services.ServiceAA;

public class ServiceAATest {
	
	private static ServiceAA serviceAA;
	
	@BeforeClass
	public static void mockService() throws Exception{
		serviceAA = mock(ServiceAA.class);
		when(serviceAA.callService()).thenReturn("ServiceAA processed");
		
	}

	@Test
	public void testServiceAASuccess() throws Exception{
		String response = serviceAA.callService();
		assertSame("ServiceAA processed", response);
	}
	
	@Test
	public void testServiceAAFailure() throws Exception{
		String response = serviceAA.callService();
		assertSame("failure serviceAA", response);
	}
}
