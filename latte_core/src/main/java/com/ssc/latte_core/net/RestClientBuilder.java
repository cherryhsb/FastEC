package com.ssc.latte_core.net;

/*
 *  项目名：    FastEC
 *  包名:       com.ssc.latte_core.net
 *  文件名：    RestClientBuilder
 *  创建者：    SSC
 *  创建时间：   2018/8/28 18:29
 *  描述：     Builder一般进行传值的操作
 */

import android.content.Context;

import com.ssc.latte_core.net.callback.IError;
import com.ssc.latte_core.net.callback.IFailure;
import com.ssc.latte_core.net.callback.IRequest;
import com.ssc.latte_core.net.callback.ISuccess;
import com.ssc.latte_core.ui.LoaderStyle;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RestClientBuilder {

    //类变量最好加上m
    private String mUrl = null;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private IRequest mIRequest = null;
    private ISuccess mISuccess = null;
    private IFailure mIFailure = null;
    private IError mIError = null;
    private RequestBody mBody = null;
    private File mFile = null;
    private Context mContext = null;
    private LoaderStyle mLoaderStyle = null;

    //只允许同包的RestClient去new
    RestClientBuilder() {

    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    //直接传入文件
    public final RestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }

    //传入文件地址
    public final RestClientBuilder file(String filePath) {
        this.mFile = new File(filePath);
        return this;
    }

    //原始数据
    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mIError = iError;
        return this;
    }

    public final RestClientBuilder loader(Context context, LoaderStyle style) {
        this.mContext = context;
        this.mLoaderStyle = style;
        return this;
    }

    public final RestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mIRequest, mISuccess, mIFailure, mIError, mBody, mFile, mContext, mLoaderStyle);
    }
}
