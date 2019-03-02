package com.hissmoo.robinhood.api.client;

import com.hissmoo.robinhood.api.client.service.IRobinhoodApiCallBack;

public interface IRobinhoodAsyncRestApiClient {
    boolean alreadyLogin();
    void login(String userName, String password, IRobinhoodApiCallBack<Void> callback);
    void logout(IRobinhoodApiCallBack<Void> callback);
}
