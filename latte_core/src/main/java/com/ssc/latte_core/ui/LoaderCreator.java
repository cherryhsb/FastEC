package com.ssc.latte_core.ui;

/*
 *  项目名：    FastEC
 *  包名:       com.ssc.latte_core.ui
 *  文件名：    LoaderCreator
 *  创建者：    SSC
 *  创建时间：   2018/8/28 23:26
 *  描述：     LoaderCreator
 */

import android.content.Context;

import com.wang.avi.AVLoadingIndicatorView;
import com.wang.avi.Indicator;

import java.util.WeakHashMap;

public class LoaderCreator {

    private static final WeakHashMap<String,Indicator> LOADING_MAP = new WeakHashMap<>();

    static AVLoadingIndicatorView create(String type, Context context){

        final AVLoadingIndicatorView avLoadingIndicatorView = new AVLoadingIndicatorView(context);
        if (LOADING_MAP.get(type)==null){
            //如果是null,创建他.做了一个缓存
            final Indicator indicator = getIndicator(type);
            LOADING_MAP.put(type,indicator);
        }
        avLoadingIndicatorView.setIndicator(LOADING_MAP.get(type));
        //如果不为null,直接使用.
        return avLoadingIndicatorView;
    }

    private static Indicator getIndicator(String name){
        if (name ==null||name.isEmpty()){
            return null;
        }
        final StringBuilder drawableClassName = new StringBuilder();
        if (!name.contains(".")){
            //如果name包含".",就说明是个类名
            final String defaultPackageName = AVLoadingIndicatorView.class.getPackage().getName();
            drawableClassName.append(defaultPackageName)
                    .append(".indicators")
                    .append(".");
        }
        drawableClassName.append(name);
        try {
            final Class<?> drawableClass = Class.forName(drawableClassName.toString());
            return (Indicator) drawableClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
