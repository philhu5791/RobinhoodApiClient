package com.hissmoo.robinhood.api.client.service;

import com.hissmoo.robinhood.api.client.exception.RobinhoodApiException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.hissmoo.robinhood.api.client.service.RobinhoodServiceFactory.getRobinhoodApiError;

public class CallBackAdapter<T> implements Callback<T> {

    private final IRobinhoodApiCallBack<T> mCallBack;

    public CallBackAdapter(IRobinhoodApiCallBack<T> callBack){
        this.mCallBack = callBack;
    }

    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            mCallBack.onResponse(response.body());
        } else {
            if (response.code() == 504) {
                // HTTP 504 return code is used when the API successfully sent the message but not get a response within the timeout period.
                // It is important to NOT treat this as a failure; the execution status is UNKNOWN and could have been a success.
                return;
            }
            try {
                RobinhoodApiError apiError = getRobinhoodApiError(response);
                onFailure(call, new RobinhoodApiException(apiError));
            } catch (Exception e) {
                onFailure(call, new RobinhoodApiException(e));
            }
        }
    }




    public void onFailure(Call<T> call, Throwable throwable) {
        if (throwable instanceof RobinhoodApiException) {
            mCallBack.onFailure(throwable);
        } else {
            mCallBack.onFailure(new RobinhoodApiException(throwable));
        }
    }
}
