package com.ssc.latte_core.delegate;

/*
 *  项目名：    FastEC
 *  包名:       com.ssc.latte_core.delegate
 *  文件名：    BaseDelegate
 *  创建者：    SSC
 *  创建时间：   2018/8/27 21:27
 *  描述：     一个可滑动Fragment
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

public abstract class BaseDelegate extends SwipeBackFragment{

    private Unbinder mUnbinder = null;

    //让子类传入他的布局
    public abstract Object setLayout();

    public abstract void onBindView(@Nullable Bundle saveInstanceState,View rootView);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = null;
        if (setLayout() instanceof Integer){
            //如果是Id
            rootView = inflater.inflate((Integer) setLayout(),container,false);
        }else if (setLayout() instanceof View){
            rootView = (View) setLayout();
        }
        if (rootView != null){
            mUnbinder = ButterKnife.bind(this,rootView);
            onBindView(savedInstanceState,rootView);
        }

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null){
            mUnbinder.unbind();
        }
    }
}
