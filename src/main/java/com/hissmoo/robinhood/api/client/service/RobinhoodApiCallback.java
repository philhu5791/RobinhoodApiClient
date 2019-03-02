package com.hissmoo.robinhood.api.client.service;

@FunctionalInterface
public interface RobinhoodApiCallback<T> {
    /**
     * Called whenever a response comes back from the Binance API.
     *
     * @param response the expected response object
     */
    void onResponse(T response);

    /**
     * Called whenever an error occurs.
     *
     * @param cause the cause of the failure
     */
    default void onFailure(Throwable cause) {}
}
