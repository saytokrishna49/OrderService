package orderservice;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;

import com.order.exception.OrderException;
import com.order.services.OrderService;

public class OrderServiceTest {
	
	private static OrderService orderServiceMock;
	
	@BeforeClass
	public static void mockService() throws Exception{
		orderServiceMock = mock(OrderService.class);
		orderServiceMock.setThreadWaitTime(4000);
		
	}
	
	@Test
	public void processOrderSuccess() throws Exception{
		when(orderServiceMock.processOrder()).thenReturn("order processed");
		String output = orderServiceMock.processOrder();
		assertSame("order processed", output);
	}
	
	@Test
	public void processOrderFailure() throws Exception{
		when(orderServiceMock.processOrder()).thenReturn("order processed");
		String output = orderServiceMock.processOrder();
		assertSame("failure", output);
		
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected = OrderException.class)
	public void processOrderExceptionSuccess() throws Exception{
		orderServiceMock.setThreadWaitTime(2000);
		when(orderServiceMock.processOrder()).thenThrow(OrderException.class);
		String output = orderServiceMock.processOrder();
		assertSame("success", output);
		
	}
	
	@Test(expected = OrderException.class)
	public void processOrderExceptionFailure() throws Exception{
		
		orderServiceMock.setThreadWaitTime(4000);
		when(orderServiceMock.processOrder()).thenReturn("order processed");
		String output = orderServiceMock.processOrder();
		assertSame("order processed", output);
		
	}
	


}
