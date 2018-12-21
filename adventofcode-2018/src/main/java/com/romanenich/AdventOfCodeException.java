package com.romanenich;

public class AdventOfCodeException extends RuntimeException {

    public AdventOfCodeException() {
        super();
    }

    public AdventOfCodeException(String message) {
        super(message);
    }

    public AdventOfCodeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AdventOfCodeException(Throwable cause) {
        super(cause);
    }

    protected AdventOfCodeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
