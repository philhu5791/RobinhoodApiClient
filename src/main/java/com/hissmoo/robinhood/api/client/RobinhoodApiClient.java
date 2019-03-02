package com.hissmoo.robinhood.api.client;

import com.hissmoo.robinhood.api.client.domain.Instrument;
import com.hissmoo.robinhood.api.client.service.CallBackAdapter;
import com.hissmoo.robinhood.api.client.service.IRobinhoodApiCallBack;
import com.hissmoo.robinhood.api.client.service.IRobinhoodApiService;


import static com.hissmoo.robinhood.api.client.service.RobinhoodServiceFactory.createService;

public class RobinhoodApiClient implements  IRobinhoodApiClient{


    public static void main(String[] args) {
        IRobinhoodApiService binanceApiService = createService(IRobinhoodApiService.class);
        IRobinhoodApiCallBack<Instrument> callbackTime = response -> System.out.println(response.toString());

        binanceApiService.ping().enqueue(new CallBackAdapter<Instrument>(callbackTime));
    }

}
