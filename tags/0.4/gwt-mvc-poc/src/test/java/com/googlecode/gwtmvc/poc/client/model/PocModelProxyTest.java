package com.googlecode.gwtmvc.poc.client.model;

import com.googlecode.gwtmvc.client.Maskable;
import com.googlecode.gwtmvc.client.MvcEvent;
import com.googlecode.gwtmvc.poc.client.PocGWTTestCase;
import com.googlecode.gwtmvc.poc.client.controller.PocController.PocAction;

public class PocModelProxyTest extends PocGWTTestCase {

	PocModelProxy pocModelProxy = new PocModelProxy();

	public void testInit() throws Exception {
		pocModelProxy.init();
		assertEquals(10, pocModelProxy.getValue().intValue());
	}

	public void testPlus() throws Exception {
		delayTestFinish(3000);
		pocModelProxy.plus(10, new MvcEvent(PocAction.DO_PLUS_A,new Maskable(){
			public void mask() {
				
			}
			public void unmask() {
				assertEquals(11, pocModelProxy.getValue().intValue());
				finishTest();
			};
			
		}));
	}

}
