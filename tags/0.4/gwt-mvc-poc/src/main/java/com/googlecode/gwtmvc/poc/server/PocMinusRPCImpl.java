package com.googlecode.gwtmvc.poc.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.gwtmvc.poc.client.exception.PocCheckedException;
import com.googlecode.gwtmvc.poc.client.exception.PocUncheckedException;
import com.googlecode.gwtmvc.poc.client.rpc.PocMinusRPC;

public class PocMinusRPCImpl extends RemoteServiceServlet implements PocMinusRPC {

	private static final long serialVersionUID = -2812442028972565961L;

	public Integer minus(Integer integer) {
		return integer - 1;
	}
	
	public void throwCheckedException() throws PocCheckedException {
		throw new PocCheckedException("PocCheckedException");
	}
	
	public void throwUncheckedException() {
		throw new PocUncheckedException("PocUncheckedException");
	}

}
