package com.company.exceptions;

public class Matrix3Exceptions extends Exception {
    public Matrix3Exceptions() {
    }

    public Matrix3Exceptions(String message) {
        super(message);
    }

    public Matrix3Exceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public Matrix3Exceptions(Throwable cause) {
        super(cause);
    }

    public Matrix3Exceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
