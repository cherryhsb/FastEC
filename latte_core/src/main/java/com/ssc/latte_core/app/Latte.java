package com.ssc.latte_core.app;

/*
 *  项目名：    FastEC
 *  包名:       com.ssc.latte_core.app
 *  文件名：    Latte
 *  创建者：    SSC
 *  创建时间：   2018/8/24 20:20
 *  描述：     TODO
 */

import android.content.Context;

import java.util.HashMap;
import java.util.WeakHashMap;

public final class Latte {

    /**
     *
     * @param context   建议传入Application的context
     * @return
     */
    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static HashMap<String,Object> getConfigurations(){
        return Configurator.getInstance().getLatteConfigs();
    }

    public static Context getApplication(){
        return (Context) getConfigurations().get(ConfigType.APPLICATION_CONTEXT.name());
    }
}
