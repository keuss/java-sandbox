package com.cgi.test.test_cxf_spring.interceptors;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class WSSISesameCallBack implements CallbackHandler {



	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		String user = "kess"; 
		String passCode = "pass kess"; 
		pc.setIdentifier(user);
		pc.setPassword(passCode);
	}

}
