package com.googlecode.gwtmvc.poc.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PocPlusRPCAsync {

	public void plus(Integer integer, AsyncCallback<Integer> callback);
}
