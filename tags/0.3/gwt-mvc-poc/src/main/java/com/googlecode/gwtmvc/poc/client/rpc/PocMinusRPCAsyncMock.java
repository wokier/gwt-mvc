package com.googlecode.gwtmvc.poc.client.rpc;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Allows deploy on a web server
 */
public class PocMinusRPCAsyncMock implements PocMinusRPCAsync {

	public void minus(final Integer integer,final AsyncCallback<Integer> callback) {
		Log.debug("waiting 2s");
		new Timer(){
			@Override
			public void run() {
				callback.onSuccess(integer-1);
			}
		}
		.schedule(2000);
		
	}

}
