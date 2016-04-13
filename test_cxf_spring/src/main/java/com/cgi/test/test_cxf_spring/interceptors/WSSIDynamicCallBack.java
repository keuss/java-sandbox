package com.cgi.test.test_cxf_spring.interceptors;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class WSSIDynamicCallBack implements CallbackHandler {

	/**
	 * thread specific username initalized to null
	 */
	private static ThreadLocal<String> username = new ThreadLocal<String>()
	{
		protected synchronized String initialValue()
		{
			return null;
		}
	};

	/**
	 * thread specific password, also initialized to null
	 */
	private static ThreadLocal<String> password = new ThreadLocal<String>()
	{
		protected synchronized String initialValue()
		{
			return null;
		}
	};

	/**
	 * set user id
	 * 
	 * @param user the user
	 * @param passw the password
	 */
	public static void setThreadIdentity(String user, String passw) { 
		username.set(user); 
		password.set(passw); 
	} 
	 
	/**
	 * 
	 * {@inheritDoc}
	 * 
	 */
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
		String user = username.get(); 
		String passCode = password.get(); 
		pc.setIdentifier(user);
		pc.setPassword(passCode);
	}

}
