package fr.wokier.client;

import junit.framework.Assert;

import org.junit.Test;

import com.google.gwt.core.client.GWT;
import com.google.gwt.junit.client.GWTTestCase;
import com.google.gwt.user.client.ui.Widget;

public class SimpleGwtTest extends GWTTestCase {

	@Override
	public String getModuleName() {
		return "fr.wokier.Gwt_maven_plugin_test";
	}

	@Test
	public void testWidget() throws Exception {
		System.out.println("GWTTESTCASE");
		new Widget();
		Assert.assertTrue(true);
	}

	@Test
	public void testGreetingService() throws Exception {
		System.out.println("GWTTESTCASE");
		new Widget();
		GreetingServiceAsync greetingService = GWT
				.create(GreetingService.class);
	}
}
