package orderservice;

import org.junit.Assert;
import org.junit.Test;

import com.order.exception.OrderException;
import com.order.services.OrderService;

public class OrderServiceTest {
	
	@Test
	public void processOrderSuccess() throws Exception{
		
		OrderService order = new OrderService(4000);
		String output = order.processOrder();
		Assert.assertSame("success", output);
		
	}
	
	@Test
	public void processOrderFailure() throws Exception{
		
		OrderService order = new OrderService(4000);
		String output = order.processOrder();
		Assert.assertSame("failure", output);
		
	}
	
	@Test(expected = OrderException.class)
	public void processOrderExceptionSuccess() throws Exception{
		
		OrderService order = new OrderService(2000);
		String output = order.processOrder();
		Assert.assertSame("success", output);
		
	}
	
	@Test(expected = OrderException.class)
	public void processOrderExceptionFailure() throws Exception{
		
		OrderService order = new OrderService(4000);
		String output = order.processOrder();
		Assert.assertSame("success", output);
		
	}
	


}
