package com.hissmoo.robinhood.api.client.service;
import com.hissmoo.robinhood.api.client.domain.Instrument;
import retrofit2.Call;
import retrofit2.http.*;

public interface IRobinhoodApiService {

    @Headers({
            "Accept: application/json",
    })
    @GET("/midlands/tags/tag/100-most-popular/")
    //@GET("/api/v1/time")
    Call<Instrument> ping();
}
