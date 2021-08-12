package com.fang.jvm.loader;

/**
 * @author fanglingxiao
 * @version 1.0
 * @description TODO
 * @date 2021/7/13 12:40 上午
 **/
public class Test02_ClassLoaderLevel {
    public static void main(String[] args){
        System.out.println(String.class.getClassLoader());
        System.out.println(Test02_ClassLoaderLevel.class.getClassLoader());
        System.out.println(Test02_ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader());
    }
}
