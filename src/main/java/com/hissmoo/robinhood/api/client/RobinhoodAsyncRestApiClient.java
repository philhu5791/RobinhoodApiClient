package com.hissmoo.robinhood.api.client;

import com.hissmoo.robinhood.api.client.domain.AccessToken;
import com.hissmoo.robinhood.api.client.domain.Instrument;
import com.hissmoo.robinhood.api.client.service.CallBackAdapter;
import com.hissmoo.robinhood.api.client.service.IRobinhoodApiCallBack;
import com.hissmoo.robinhood.api.client.service.IRobinhoodApiService;


import static com.hissmoo.robinhood.api.client.service.RobinhoodServiceFactory.createService;

public class RobinhoodAsyncRestApiClient implements IRobinhoodAsyncRestApiClient {
    /**
     * The access token is required to call API.
     */
    private String accessToken = null;

    /**
     * The service provided by Robinhood API.
     */
    IRobinhoodApiService robinhoodApiService;

    public RobinhoodAsyncRestApiClient(){
        robinhoodApiService = createService(IRobinhoodApiService.class);
    }

    @Override
    public boolean alreadyLogin() {
        return accessToken != null;
    }

    @Override
    public void login(String userName, String password, IRobinhoodApiCallBack<Void> callback) {
        IRobinhoodApiCallBack<AccessToken> loginCallBack = response -> {
            RobinhoodAsyncRestApiClient.this.accessToken = response.getToken();
            callback.onResponse(null);
        };
        robinhoodApiService.login(userName, password).enqueue(new CallBackAdapter<>(loginCallBack));
    }

    @Override
    public void logout(IRobinhoodApiCallBack<Void> callback) {
        IRobinhoodApiCallBack<Void> logoutCallBack = response -> {
            this.accessToken = null;
            callback.onResponse(null);
        };
        robinhoodApiService.logout("Token "+ accessToken).enqueue(new CallBackAdapter<Void>(logoutCallBack));
    }


}
