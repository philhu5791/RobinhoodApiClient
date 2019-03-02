package com.hissmoo.robinhood.api.client.service;
import com.hissmoo.robinhood.api.client.domain.AccessToken;
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

    @POST("/api-token-auth/")
    Call<AccessToken> login(@Query("username") String userName, @Query("password") String password);


    @POST("/api-token-auth/")
    Call<Void> logout(@Header("Authorization: ") String token);
}
