package com.googlecode.gwtmvc.poc.client.model;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.googlecode.gwtmvc.client.ModelAutoCallback;
import com.googlecode.gwtmvc.client.ModelProxy;
import com.googlecode.gwtmvc.client.MvcEvent;
import com.googlecode.gwtmvc.poc.client.rpc.PocMinusRPC;
import com.googlecode.gwtmvc.poc.client.rpc.PocPlusRPC;

public class PocModelProxy extends ModelProxy<Integer> {

	protected static final int INITIAL_VALUE_10 = 10;

	private boolean useServerRPCCall = false;
	
	public PocModelProxy() {
		super();
	}

	@Override
	public void init() {//public visibility for test
		update(INITIAL_VALUE_10);
	}
	
	public void plus(Integer integer,final MvcEvent causeEvent) {
		PocPlusRPC.Factory.getInstance(useServerRPCCall).plus(integer, new ModelAutoCallback<Integer>(this,causeEvent){
			public void onFailure(Throwable caught) {
				Window.alert("plus failed : " + caught);
			}
		});
	}

	public void minus(Integer integer,final MvcEvent causeEvent) {
		PocMinusRPC.Util.getInstance(useServerRPCCall).minus(integer, new ModelAutoCallback<Integer>(this,causeEvent){
			public void onFailure(Throwable caught) {
				Window.alert("minus failed : " + caught);
			}
		});
	}
	
	public void reinit(final MvcEvent causeEvent) {
		Log.debug("waiting 2s");
		new Timer(){
			@Override
			public void run() {
				update(0,causeEvent);
			}
		}
		.schedule(2000);
	}
	
	public void throwCheckedException(final MvcEvent causeEvent) {
		PocMinusRPC.Util.getInstance(useServerRPCCall).throwCheckedException(new ModelAutoCallback(this));
	}
	
	public void throwUncheckedException(final MvcEvent causeEvent) {
		PocMinusRPC.Util.getInstance(useServerRPCCall).throwUncheckedException(new ModelAutoCallback(this));
	}
	
	@Override
	public void update(Integer value) {
		super.update(value);
	}
	
	@Override
	public void update(Integer value, MvcEvent causeEvent) {
		super.update(value, causeEvent);
	}

}
