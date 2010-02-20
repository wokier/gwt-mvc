package fr.wokier.client;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.junit.Test;

public class SimpleTest extends TestCase {

	private static final Logger logger = Logger.getLogger(SimpleTest.class);
	
	@Test
	public void testAlwaysGreen() throws Exception {
		logger.debug("TESTCASE");
		Assert.assertTrue(true);
	}
	
}
