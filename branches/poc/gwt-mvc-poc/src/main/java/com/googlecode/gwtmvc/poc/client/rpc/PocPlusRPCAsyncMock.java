package com.googlecode.gwtmvc.poc.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class PocPlusRPCAsyncMock implements PocPlusRPCAsync {

	public void plus(Integer integer, AsyncCallback<Integer> callback) {
		callback.onSuccess(integer +1 );
	}

}
