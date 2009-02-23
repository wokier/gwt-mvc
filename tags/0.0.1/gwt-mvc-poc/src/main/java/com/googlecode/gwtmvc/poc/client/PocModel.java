package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.googlecode.gwtmvc.client.Event;
import com.googlecode.gwtmvc.client.Model;
import com.googlecode.gwtmvc.poc.client.rpc.PocMinusRPC;
import com.googlecode.gwtmvc.poc.client.rpc.PocPlusRPC;

public class PocModel extends Model<Integer> {

	protected static final int INITIAL_VALUE_10 = 10;

	private boolean useServerRPCCall = false;
	
	public PocModel() {
		super();
	}

	@Override
	protected void init() {
		update(INITIAL_VALUE_10);
	}
	
	public void plus(Integer integer,final Event causeEvent) {
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

	public void minus(Integer integer,final Event causeEvent) {
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

}
