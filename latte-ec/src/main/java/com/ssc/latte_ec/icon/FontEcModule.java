package com.ssc.latte_ec.icon;

/*
 *  项目名：    FastEC
 *  包名:       com.ssc.latte_ec.icon
 *  文件名：    FontEcModule
 *  创建者：    SSC
 *  创建时间：   2018/8/27 11:30
 *  描述：     FontEcModule
 */

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

public class FontEcModule implements IconFontDescriptor{
    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        //枚举.values 返回枚举类型的数组
        return EcIcons.values();
    }
}
