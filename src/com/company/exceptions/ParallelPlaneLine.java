package com.company.exceptions;

public class ParallelPlaneLine extends Exception {
    public ParallelPlaneLine() {
    }

    public ParallelPlaneLine(String message, Throwable cause) {
        super(message, cause);
    }

    public ParallelPlaneLine(String message) {
        super(message);
    }

    public ParallelPlaneLine(Throwable cause) {
        super(cause);
    }

    public ParallelPlaneLine(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
