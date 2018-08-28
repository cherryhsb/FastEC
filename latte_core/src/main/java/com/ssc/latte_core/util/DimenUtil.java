package com.ssc.latte_core.util;

/*
 *  项目名：    FastEC
 *  包名:       com.ssc.latte_core.util
 *  文件名：    DimenUtil
 *  创建者：    SSC
 *  创建时间：   2018/8/29 1:49
 *  描述：     获取屏幕宽高
 */

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.ssc.latte_core.app.Latte;

public class DimenUtil {

    public static int getScreenWidth(){
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(){
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
