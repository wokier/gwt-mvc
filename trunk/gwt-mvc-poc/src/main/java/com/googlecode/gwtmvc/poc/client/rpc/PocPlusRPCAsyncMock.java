package com.googlecode.gwtmvc.poc.client.rpc;

import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class PocPlusRPCAsyncMock implements PocPlusRPCAsync {

	public void plus(final Integer integer, final AsyncCallback<Integer> callback) {
		new Timer() {
			@Override
			public void run() {
				callback.onSuccess(integer + 1);
			}
		}.schedule(200);
	}

}
