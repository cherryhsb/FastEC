package com.ssc.latte_core.net;

/*
 *  项目名：    FastEC
 *  包名:       com.ssc.latte_core.net
 *  文件名：    RestService
 *  创建者：    SSC
 *  创建时间：   2018/8/28 17:00
 *  描述：     TODO
 */

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface RestService {

    @GET
    Call<String> get(@Url String url, @QueryMap Map<String, Object> params);

    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap Map<String, Object> params);

    @FormUrlEncoded
    @PUT
    Call<String> put(@Url String url, @FieldMap Map<String, Object> params);

    @DELETE
    Call<String> delete(@Url String url, @QueryMap Map<String, Object> params);

    //retrofit默认的download方式是把文件一次性下载到内存里,然后当下载完毕后统一写到硬盘里
    //当文件过大容易出现内存溢出.@Streaming 边下载边写入,解决问题
    @Streaming
    @GET
    Call<ResponseBody> download(@Url String url, @QueryMap Map<String, Object> params);

    @Multipart
    @POST
    Call<String> upload(@Url String url, @Part MultipartBody.Part file);
}
