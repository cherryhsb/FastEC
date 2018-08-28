package com.ssc.latte_core.net.callback;

/*
 *  项目名：    FastEC
 *  包名:       com.ssc.latte_core.net.callback
 *  文件名：    RequestCallbacks
 *  创建者：    SSC
 *  创建时间：   2018/8/28 20:11
 *  描述：     网络请求回调
 */

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;

import com.ssc.latte_core.ui.LatteLoader;
import com.ssc.latte_core.ui.LoaderStyle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestCallbacks implements Callback<String> {

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final LoaderStyle LOADER_STYLE;
    //handler尽量声明static类型,避免一些内存泄漏
    private static final Handler HANDLER = new Handler();

    public RequestCallbacks(IRequest request, ISuccess success, IFailure failure, IError error,LoaderStyle style) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.LOADER_STYLE = style;
    }

    @Override
    public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body());
                }
            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }

        stopLoading();
    }

    @Override
    public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
        if (FAILURE != null) {
            FAILURE.onFailure();
        }

        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }

        stopLoading();
    }

    private void stopLoading(){
        //请求结束时,取消loading
        if (LOADER_STYLE!=null){
            HANDLER.postDelayed(new Runnable() {
                @Override
                public void run() {
                    LatteLoader.stopLoading();
                }
            }, 1000);
        }
    }
}
