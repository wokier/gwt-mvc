package com.googlecode.gwtmvc.poc.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.gwtmvc.poc.client.rpc.PocPlusRPC;

public class PocPlusRPCImpl extends RemoteServiceServlet implements PocPlusRPC {

	private static final long serialVersionUID = -2812442028972565961L;

	public Integer plus(Integer integer) {
		return integer + 1;
	}

}
