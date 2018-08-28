package com.ssc.fastec.example;

/*
 *  项目名：    FastEC
 *  包名:       com.ssc.fastec.example
 *  文件名：    ExampleDelagete
 *  创建者：    SSC
 *  创建时间：   2018/8/28 2:11
 *  描述：     TODO
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.ssc.latte_core.delegate.LatteDelegate;
import com.ssc.latte_core.net.RestClient;
import com.ssc.latte_core.net.callback.IError;
import com.ssc.latte_core.net.callback.IFailure;
import com.ssc.latte_core.net.callback.ISuccess;

public class ExampleDelagete extends LatteDelegate{
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle saveInstanceState, View rootView) {

        testRestClient();
    }

    private void testRestClient(){
        RestClient.builder()
                .url("http://news.baidu.com/")
                //.params("", "")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        //Toast.makeText(getContext(), response,Toast.LENGTH_SHORT).show();
                        Log.i("哈哈哈","哈哈哈");
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .loader(getContext())
                .build()
                .get();
    }
}
