package com.fang.jvm.rda;

/**
 * @author fanglingxiao
 * @version 1.0
 * @description JVM 运行时数据区01—面试题
 * @date 2021/8/22 10:24 下午
 **/
public class Test01_Interview {
    public static void main(String[] args) {
        int i = 8;
//        i = i++;
        i = ++i;
        System.out.println(i);
    }
}
