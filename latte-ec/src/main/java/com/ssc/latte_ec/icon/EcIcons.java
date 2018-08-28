package com.ssc.latte_ec.icon;

/*
 *  项目名：    FastEC
 *  包名:       com.ssc.latte_ec.icon
 *  文件名：    EcIcons
 *  创建者：    SSC
 *  创建时间：   2018/8/27 11:37
 *  描述：     TODO
 */

import com.joanzapata.iconify.Icon;

public enum  EcIcons implements Icon{
    icon_scan('\ue60f'),
    icon_alipay('\ue601');

    private char character;

    EcIcons(char character) {
        this.character = character;
    }

    @Override
    public String key() {
        return name().replace('_', '-');
    }

    @Override
    public char character() {
        return character;
    }
}
