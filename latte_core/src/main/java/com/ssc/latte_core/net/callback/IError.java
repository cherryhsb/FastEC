package com.ssc.latte_core.net.callback;

/*
 *  项目名：    FastEC
 *  包名:       com.ssc.latte_core.net.callback
 *  文件名：    IError
 *  创建者：    SSC
 *  创建时间：   2018/8/28 18:44
 *  描述：     TODO
 */

public interface IError {

    void onError(int code,String msg);
}
