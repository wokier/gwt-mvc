package com.googlecode.gwtmvc.poc.client.rpc;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface PocPlusRPC extends RemoteService {

	public static class Factory {
		private static PocPlusRPCAsync instance;

		public static PocPlusRPCAsync getInstance(boolean useServer) {
			if (instance == null) {
				if(useServer) {
					instance = (PocPlusRPCAsync) GWT.create(PocPlusRPC.class);
					ServiceDefTarget endpoint = (ServiceDefTarget) instance;
					endpoint.setServiceEntryPoint(GWT.getModuleBaseURL() + "PocPlusRPC");
				} else {
					instance = new PocPlusRPCAsyncMock();
				}
			}
			return instance;
		}
	}

	/**
	 * Adds 1 to input
	 * 
	 * @param integer
	 * @return
	 */
	public Integer plus(Integer integer);

}
