package com.googlecode.gwtmvc.client;

import junit.framework.TestCase;

import org.junit.Test;

import com.googlecode.gwtmvc.client.exception.UnavailableActionException;

public class ControllerTest extends TestCase{

	class NoActionsController extends Controller{
		public NoActionsController() {
			super();
		}
		@Override
		protected void init() {}
		@Override
		protected void handleEvent(MvcEvent event) {}
		@Override
		protected void renderView(IView view) {}
		@Override
		public void showHomeView() {}
	}
	
	enum Action {DO}
	
	@Test
	public void testCall() {
		try{
			Controller controller = new NoActionsController();
			controller.call(new MvcEvent(Action.DO));
			fail();
		}catch (UnavailableActionException e) {
			//success
		}
	}

}
