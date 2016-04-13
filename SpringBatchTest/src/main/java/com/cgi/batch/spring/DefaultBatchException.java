package com.cgi.batch.spring;

/**
 * @author galloisg
 *
 */
public class DefaultBatchException extends Exception {

	private static final long serialVersionUID = 7857585519755932836L;
	private String errorCode;


	public DefaultBatchException(String message, Throwable cause, String errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public DefaultBatchException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public DefaultBatchException(String message, Throwable cause) {
		super(message, cause);
	}

	public DefaultBatchException(String message) {
		super(message);
	}

	public String getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString() {
		if(errorCode != null) {
			return "DefaultBatchException [errorCode=" + errorCode + "], [message=" + this.getMessage() + "]";
		} else {
			return "DefaultBatchException [message=" + this.getMessage() + "]";
		}
	}


}
