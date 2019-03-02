package com.hissmoo.robinhood.api.client.security;

import okhttp3.Interceptor;
import okhttp3.Response;

import java.io.IOException;

public class AuthenticationInterceptor implements Interceptor {

    private final String userName;

    private final String password;

    public AuthenticationInterceptor(String apiKey, String secret) {
        this.userName = apiKey;
        this.password = secret;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }
}
