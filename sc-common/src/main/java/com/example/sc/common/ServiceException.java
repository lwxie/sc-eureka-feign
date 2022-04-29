package com.example.sc.common;

import lombok.Getter;

@Getter
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 2288338520177369674L;

    private final int status;
    private final String errorCode;
    private final String errorMessage;

    public ServiceException(int status, String errorCode, String errorMessage) {
        this(status, errorCode, errorMessage, null);
    }

    public ServiceException(String errorCode, String errorMessage) {
        this(400, errorCode, errorMessage);
    }

    public ServiceException(String errorCode, String errorMessage, Throwable cause) {
        this(500, errorCode, errorMessage, cause);
    }

    public ServiceException(int status, String errorCode, String errorMessage, Throwable cause) {
        super(cause);

        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
