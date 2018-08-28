package com.ssc.latte_core.activities;

/*
 *  项目名：    FastEC
 *  包名:       com.ssc.latte_core.activities
 *  文件名：    ProxyActivity
 *  创建者：    SSC
 *  创建时间：   2018/8/27 21:23
 *  描述：     ProxyActivity
 */

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.ssc.latte_core.R;
import com.ssc.latte_core.delegate.LatteDelegate;

import me.yokeyword.fragmentation.SupportActivity;

public abstract class ProxyActivity extends SupportActivity{

    public abstract LatteDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState){
        @SuppressLint("RestrictedApi") ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);

        setContentView(container);
        if (savedInstanceState==null){
            loadRootFragment(R.id.delegate_container,setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //垃圾回收
        System.gc();
        System.runFinalization();
    }
}
