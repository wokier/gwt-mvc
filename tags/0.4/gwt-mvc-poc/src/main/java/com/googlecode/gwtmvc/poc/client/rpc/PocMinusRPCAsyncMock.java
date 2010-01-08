package com.googlecode.gwtmvc.poc.client.rpc;

import java.util.Date;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.googlecode.gwtmvc.poc.client.exception.PocCheckedException;
import com.googlecode.gwtmvc.poc.client.exception.PocUncheckedException;

/**
 * Allows deploy on a web server
 */
public class PocMinusRPCAsyncMock implements PocMinusRPCAsync {

	public void minus(final Integer integer,final AsyncCallback<Integer> callback) {
		Log.debug("waiting 2s and minus");
		new Timer(){
			@Override
			public void run() {
				callback.onSuccess(integer-1);
			}
		}
		.schedule(2000);
		
	}
	public void throwCheckedException(final AsyncCallback<Void> callback) {
		Log.debug("waiting 1s and throw checked exception");
		new Timer(){
			@Override
			public void run() {
				callback.onFailure(new PocCheckedException("PocCheckedExcetion at "+ new Date()));
			}
		}
		.schedule(1000);
	}
	
	public void throwUncheckedException(final AsyncCallback<Void> callback) {
		Log.debug("waiting 1s and throw unchecked exception");
		new Timer(){
			@Override
			public void run() {
				callback.onFailure(new PocUncheckedException("PocUncheckedException at "+new Date()));
			}
		}
		.schedule(1000);
	}

}
