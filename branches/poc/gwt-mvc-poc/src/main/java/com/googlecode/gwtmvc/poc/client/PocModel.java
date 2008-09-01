package com.googlecode.gwtmvc.poc.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.googlecode.gwtmvc.client.Model;
import com.googlecode.gwtmvc.poc.client.rpc.PocMinusRPC;
import com.googlecode.gwtmvc.poc.client.rpc.PocPlusRPC;

public class PocModel extends Model<Integer> {

	public PocModel() {
		super();
	}

	@Override
	protected void init() {
		update(10);
	}
	
	public void plus(Integer integer) {
		AsyncCallback<Integer> callback = new AsyncCallback<Integer>() {
			public void onFailure(Throwable caught) {
				Window.alert("plus failed : " + caught);
			}

			public void onSuccess(Integer result) {
				update(result);
			}
		};
		PocPlusRPC.Util.getInstance().plus(integer, callback);
	}

	public void minus(Integer integer) {
		AsyncCallback<Integer> callback = new AsyncCallback<Integer>() {
			public void onFailure(Throwable caught) {
				Window.alert("minus failed : " + caught);
			}

			public void onSuccess(Integer result) {
				update(result);
			}
		};
		PocMinusRPC.Util.getInstance().minus(integer, callback);
	}

}
