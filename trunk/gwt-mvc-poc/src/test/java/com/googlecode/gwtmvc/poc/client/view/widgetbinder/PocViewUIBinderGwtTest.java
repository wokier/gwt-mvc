package com.googlecode.gwtmvc.poc.client.view.widgetbinder;

import com.googlecode.gwtmvc.client.Controller;
import com.googlecode.gwtmvc.client.IView;
import com.googlecode.gwtmvc.client.MvcEvent;
import com.googlecode.gwtmvc.poc.client.PocGWTTestCase;
import com.googlecode.gwtmvc.poc.client.model.PocModelProxy;
import com.googlecode.gwtmvc.poc.client.view.widgetbinder.PocViewUIBinder;

public class PocViewUIBinderGwtTest extends PocGWTTestCase {

	public class DummyController extends Controller {

		@Override
		protected void handleEvent(MvcEvent event) {
		}

		@Override
		protected void init() {
		}

		@Override
		protected void renderView(IView view) {
		}

		@Override
		public void showHomeView() {
		}

	}

	public void testRender() {
		PocModelProxy pocModelProxy = new PocModelProxy();
		PocViewUIBinder view = new PocViewUIBinder(new DummyController(),pocModelProxy);
		view.render();
		pocModelProxy.update(12);
		assertEquals("12", view.uiBinderSpan.getInnerText());
	}

}
