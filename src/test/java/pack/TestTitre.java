package pack;

import org.testng.Assert;

import org.testng.annotations.Test;


public class TestTitre extends Base {
	@Test
	public void test4() {
		Assert.assertEquals(driver.getTitle(),"aaaa");
		
		
	}

}
