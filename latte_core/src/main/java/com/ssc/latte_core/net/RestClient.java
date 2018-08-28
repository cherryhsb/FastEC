package com.ssc.latte_core.net;

/*
 *  项目名：    FastEC
 *  包名:       com.ssc.latte_core.net
 *  文件名：    RestClient
 *  创建者：    SSC
 *  创建时间：   2018/8/28 15:37
 *  描述：     TODO
 *  网络请求参数一般有:  url,传入的值,文件,他的回调,loading等待加载圈
 *  使用建造者模式
 */

import com.ssc.latte_core.net.callback.IError;
import com.ssc.latte_core.net.callback.IFailure;
import com.ssc.latte_core.net.callback.IRequest;
import com.ssc.latte_core.net.callback.ISuccess;

import java.util.Map;

import okhttp3.RequestBody;

public class RestClient {

    private final String URL;
    private final Map<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;


    public RestClient(String url, Map<String, Object> params,
                      IRequest request, ISuccess success,
                      IFailure failure, IError error,
                      RequestBody body) {
        this.URL = url;
        PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
    }

    //创建构造者
    public static RestClientBuilder builder(){
        return new RestClientBuilder();
    }
}
