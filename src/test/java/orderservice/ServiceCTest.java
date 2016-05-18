package orderservice;

import org.junit.Assert;
import org.junit.Test;

import com.order.services.ServiceC;

public class ServiceCTest {
	@Test
	public void testServiceCSuccess() throws Exception{
		ServiceC serviceC = new ServiceC("outputAA","outputC");
		Assert.assertSame("outputAAoutputC", serviceC.callService());
	}
	
	@Test
	public void testServiceCFailure() throws Exception{
		ServiceC serviceC = new ServiceC("outputAA","outputC");
		Assert.assertSame("outputAA and outputAA", serviceC.callService());
	}
}
