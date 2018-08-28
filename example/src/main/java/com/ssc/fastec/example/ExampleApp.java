package com.ssc.fastec.example;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.ssc.latte_core.app.Latte;
import com.ssc.latte_ec.icon.FontEcModule;


/*
 *  项目名：    FastEC
 *  包名:       com.ssc.fastec.example
 *  文件名：    ExampleApp
 *  创建者：    SSC
 *  创建时间：   2018/8/25 18:58
 *  描述：     Application
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())//初始化自定义字体库
                .withApiHost("http://127.0.0.1/")
                .configure();

    }
}
