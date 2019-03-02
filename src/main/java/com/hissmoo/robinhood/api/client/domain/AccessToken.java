package com.hissmoo.robinhood.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The authorize token for accessing Robinhood API.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessToken {
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;

}
