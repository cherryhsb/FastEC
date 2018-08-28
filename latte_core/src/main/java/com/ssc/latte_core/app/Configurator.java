package com.ssc.latte_core.app;

/*
 *  项目名：    FastEC
 *  包名:       com.ssc.latte_core.app
 *  文件名：    Configurator
 *  创建者：    SSC
 *  创建时间：   2018/8/25 0:09
 *  描述：     进行配置文件的存储和获取
 */

import android.support.v4.view.animation.FastOutLinearInInterpolator;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/*Configurator 名词*/
public class Configurator {

    //存储配置信息.   WeakHashMap在不使用时可以回收
    private static final HashMap<String, Object> LATTE_CONFIGS = new HashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList<>();

    private Configurator() {
        //初始化
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    /*线程安全的懒汉模式单例:
            1.静态内部类Holder
            2.getInstance*/
    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final HashMap<String, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    /*最终的初始化动作
    configure 动词*/
    public final void configure() {
        //初始化字体
        initIcons();
        //初始化初始化状态
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    //初始化的输入
    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    //初始化字体库    Iconify
    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i > ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }

    //检查配置项是否完成
    private void checkConfiguration() {
        //写类变量或方法变量时,如果在以后的程序开发中不再需要更改他,最好使他的不可变性达到最大化
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    //输出
    //获取某一项配置信息
    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }

}
