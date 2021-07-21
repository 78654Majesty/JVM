package com.fang.jvm.test;

/**
 * @author fanglingxiao
 * @version 1.0
 * @description 手动加载
 * @date 2021/7/13 12:40 上午
 **/
public class Test03_LoadClass {

    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Test03_LoadClass.class.getClassLoader().loadClass("com.fang.jvm.test.Test02_ClassLoaderScope");
        System.out.println(clazz.getName());
    }
}
