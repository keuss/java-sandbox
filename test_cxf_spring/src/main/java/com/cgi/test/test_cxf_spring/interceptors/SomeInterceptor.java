package com.cgi.test.test_cxf_spring.interceptors;

import java.io.IOException;
import java.util.Date;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class SomeInterceptor implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException,
	UnsupportedCallbackException {

		System.out.println("Call for " + this.getClass().getSimpleName() + " at : " + new Date());
		// recuperation du callback
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		String login = pc.getIdentifier();
		String pass = pc.getPassword();
		System.out.println("About to connect : ["+login+"], with pass ["+pass+"]");
		
		// test exception from Callback
		if(true) {
			throw new IOException("TEST IOException from Callback ...");
		}
	}


}
