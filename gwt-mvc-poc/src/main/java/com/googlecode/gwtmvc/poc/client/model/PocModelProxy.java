package com.googlecode.gwtmvc.poc.client.model;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
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
		AsyncCallback<Integer> callback = new AsyncCallback<Integer>() {
			public void onFailure(Throwable caught) {
				Window.alert("plus failed : " + caught);
			}

			public void onSuccess(Integer result) {
				update(result, causeEvent);
			}
		};
		PocPlusRPC.Factory.getInstance(useServerRPCCall).plus(integer, callback);
	}

	public void minus(Integer integer,final MvcEvent causeEvent) {
		AsyncCallback<Integer> callback = new AsyncCallback<Integer>() {
			public void onFailure(Throwable caught) {
				Window.alert("minus failed : " + caught);
			}

			public void onSuccess(Integer result) {
				update(result, causeEvent);
			}
		};
		PocMinusRPC.Util.getInstance(useServerRPCCall).minus(integer, callback);
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
		PocMinusRPC.Util.getInstance(useServerRPCCall).throwCheckedException(new AsyncCallback<Void>(){
			public void onSuccess(Void result) {
				
			}
			public void onFailure(Throwable caught) {
				update(caught);
			}
		});
	}
	
	public void throwUncheckedException(final MvcEvent causeEvent) {
		PocMinusRPC.Util.getInstance(useServerRPCCall).throwUncheckedException(new AsyncCallback<Void>(){
			public void onSuccess(Void result) {
				
			}
			public void onFailure(Throwable caught) {
				update(caught);
			}
		});
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
