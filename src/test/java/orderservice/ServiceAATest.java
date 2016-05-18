package orderservice;

import org.junit.Assert;
import org.junit.Test;

import com.order.services.ServiceAA;

public class ServiceAATest {

	@Test
	public void testServiceAASuccess() throws Exception{
		ServiceAA serviceAA = new ServiceAA("outputA");
		Assert.assertSame("outputA and outputAA", serviceAA.callService());
	}
	
	@Test
	public void testServiceAAFailure() throws Exception{
		ServiceAA serviceAA = new ServiceAA("outputA");
		Assert.assertSame("outputAA and outputAA", serviceAA.callService());
	}
}
