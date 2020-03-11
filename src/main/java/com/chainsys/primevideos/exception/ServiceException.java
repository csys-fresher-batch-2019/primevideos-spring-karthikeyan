package com.chainsys.primevideos.exception;

@SuppressWarnings("serial")
public class ServiceException extends Exception {

	public ServiceException(Throwable e) {
		super(e);
	}

	public ServiceException(String msg, Throwable e) {
		super(msg, e);
	}
}

