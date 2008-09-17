package com.googlecode.gwtmvc;

import junit.framework.TestCase;

import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
/**
 * This a an abstract test which helps you to test your controllers.
 * It can test the controller behavior, but not the asynchronus update of the view by the model.
 */
public abstract class ControllerTestCase extends TestCase {
	
	protected Mockery mockery = new Mockery() {
		{
			setImposteriser(ClassImposteriser.INSTANCE);
		}
	};
	
	public ControllerTestCase() {
		super("Controller Test Case");
	}
	
	public ControllerTestCase(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		mockery.assertIsSatisfied();
	}

	
	
}
