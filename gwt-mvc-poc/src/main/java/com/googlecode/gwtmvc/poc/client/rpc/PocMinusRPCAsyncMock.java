package com.googlecode.gwtmvc.poc.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Allows deploy on a web server
 */
public class PocMinusRPCAsyncMock implements PocMinusRPCAsync {

	public void minus(Integer integer, AsyncCallback<Integer> callback) {
		callback.onSuccess(integer-1);
	}

}
