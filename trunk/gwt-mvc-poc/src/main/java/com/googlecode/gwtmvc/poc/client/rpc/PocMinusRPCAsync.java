package com.googlecode.gwtmvc.poc.client.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PocMinusRPCAsync {

	public void minus(Integer integer, AsyncCallback<Integer> callback);
	
	public void throwCheckedException(AsyncCallback<Void> callback);
	
	public void throwUncheckedException(AsyncCallback<Void> callback);
}
