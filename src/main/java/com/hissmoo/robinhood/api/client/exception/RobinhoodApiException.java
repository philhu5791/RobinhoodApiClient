package com.hissmoo.robinhood.api.client.exception;

import com.hissmoo.robinhood.api.client.service.RobinhoodApiError;

/**
 * An exception which can occur while invoking methods of the Robinhood API.
 */
public class RobinhoodApiException extends RuntimeException {
    /**
     * Error response object returned by Robinhood API.
     */
    private RobinhoodApiError error;

    /**
     * Instantiates a new binance api exception.
     *
     * @param error an error response object
     */
    public RobinhoodApiException(RobinhoodApiError error) {
        this.error = error;
    }

    /**
     * Instantiates a new binance api exception.
     */
    public RobinhoodApiException() {
        super();
    }

    /**
     * Instantiates a new binance api exception.
     *
     * @param message the message
     */
    public RobinhoodApiException(String message) {
        super(message);
    }

    /**
     * Instantiates a new binance api exception.
     *
     * @param throwable the throwable
     */
    public RobinhoodApiException(Throwable throwable) {
        super(throwable);
    }

}
