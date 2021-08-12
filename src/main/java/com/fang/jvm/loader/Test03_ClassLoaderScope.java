package com.fang.jvm.loader;

/**
 * @author fanglingxiao
 * @version 1.0
 * @description classLoader范围
 * @date 2021/7/13 12:40 上午
 **/
public class Test03_ClassLoaderScope {
    /**
     * Launcher 启动器定义classLoader的范围
     */
    public static void main(String[] args){
        String bootProperty = System.getProperty("sun.boot.class.path");
        System.out.println(bootProperty.replaceAll(":",System.lineSeparator()));
        System.out.println("--------------------------");
        String extProperty = System.getProperty("java.ext.dirs");
        System.out.println(extProperty.replaceAll(":",System.lineSeparator()));
        System.out.println("--------------------------");
        String appProperty = System.getProperty("java.class.path");
        System.out.println(appProperty.replaceAll(":",System.lineSeparator()));
    }
}
