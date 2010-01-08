package com.googlecode.gwtmvc.poc.client.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.googlecode.gwtmvc.poc.client.exception.PocCheckedException;

public interface PocMinusRPC extends RemoteService {

	public static class Util {
		private static PocMinusRPCAsync instance;

		public static PocMinusRPCAsync getInstance(boolean useServer) {
			if (instance == null) {
				if(useServer){
					instance = (PocMinusRPCAsync) GWT.create(PocMinusRPC.class);
					ServiceDefTarget endpoint = (ServiceDefTarget) instance;
					endpoint.setServiceEntryPoint(GWT.getModuleBaseURL() + "PocMinusRPC");
				} else {
					instance = new PocMinusRPCAsyncMock();
				}
			}
			return instance;
		}
	}

	/**
	 * Subtract 1 to input
	 * 
	 * @param integer
	 * @return
	 */
	public Integer minus(Integer integer);

	/**
	 * Throws a checked exception
	 * @throws PocCheckedException
	 */
	public void throwCheckedException() throws PocCheckedException;
	
	/**
	 * Throws an unchecked exception
	 * @throws PocCheckedException
	 */
	public void throwUncheckedException();
	
}
