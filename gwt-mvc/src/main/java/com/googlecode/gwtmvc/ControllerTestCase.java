package com.googlecode.gwtmvc;

import junit.framework.TestCase;

import org.jmock.Mockery;
import org.jmock.lib.legacy.ClassImposteriser;

import com.googlecode.gwtmvc.client.IView;

/**
 * This a an abstract test which helps you to test your controllers. It can test
 * the controller behavior, but not the asynchronus update of the view by the
 * model. This Test Case currently use JMock
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

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		// The exception stack trace is cleaner if you place this line at the
		// end of each test.
		// Here is just a keyway
		mockery.assertIsSatisfied();
	}
	
	/**
	 * Give a dynamic mock for a view
	 * @param <T>
	 * @param name
	 * @return
	 */
	protected <T> IView<T> mockView(String name){
		return mockery.mock(IView.class,name);
	}
	
	/**
	 * Give a dynamic mock for a model
	 * @param <M>
	 * @param modelClass
	 * @param name
	 * @return
	 */
	protected <M> M mockModel(Class<M> modelClass, String name){
		return mockery.mock(modelClass,name);
	}
}
