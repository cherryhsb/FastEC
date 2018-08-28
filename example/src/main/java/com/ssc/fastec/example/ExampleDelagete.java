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
import android.view.View;

import com.ssc.latte_core.delegate.LatteDelegate;

public class ExampleDelagete extends LatteDelegate{
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle saveInstanceState, View rootView) {

    }
}
