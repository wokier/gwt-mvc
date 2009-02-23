package com.googlecode.gwtmvc.poc.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.gwtmvc.poc.client.rpc.PocMinusRPC;

public class PocMinusRPCImpl extends RemoteServiceServlet implements PocMinusRPC {

	private static final long serialVersionUID = -2812442028972565961L;

	public Integer minus(Integer integer) {
		return integer - 1;
	}

}
