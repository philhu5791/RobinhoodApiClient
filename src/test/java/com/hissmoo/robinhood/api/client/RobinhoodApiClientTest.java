package com.hissmoo.robinhood.api.client;

import com.hissmoo.robinhood.api.client.service.IRobinhoodApiCallBack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobinhoodApiClientTest {

    private RobinhoodAsyncRestApiClient robinhoodApiClient;
    @Before
    public void setUp(){
        robinhoodApiClient = new RobinhoodAsyncRestApiClient();
    }

    @Test
    public void login() {
        IRobinhoodApiCallBack<Void> loginCallBack = response -> {
            System.out.println("log in is done.");
            assertTrue(robinhoodApiClient.alreadyLogin());
        };
        robinhoodApiClient.login("your username", "your password", loginCallBack);
    }

    @Test
    public void logout(){
        IRobinhoodApiCallBack<Void> logoutCallBack = response -> {
            System.out.println("log out is done.");
            assertFalse(robinhoodApiClient.alreadyLogin());
        };
        robinhoodApiClient.logout(logoutCallBack);

    }
}