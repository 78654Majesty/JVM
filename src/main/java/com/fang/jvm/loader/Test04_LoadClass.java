package com.fang.jvm.loader;

/**
 * @author fanglingxiao
 * @version 1.0
 * @description 手动加载
 * @date 2021/7/13 12:40 上午
 **/
public class Test04_LoadClass {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Test04_LoadClass.class.getClassLoader().loadClass("com.fang.jvm.loader.Test03_ClassLoaderScope");
        System.out.println(clazz.getName());
    }
}
