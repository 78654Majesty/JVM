package com.fang.jvm.gc;

import java.util.LinkedList;
import java.util.List;

/**
 * @author fanglingxiao
 * @version 1.0
 * @description 模拟oom
 * @date 2021/9/12 6:59 下午
 **/
public class Test01_OOM {
    /**
     * -Xms10m -Xmx10m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails
     */
    public static void main(String[] args) {
        System.out.println("HeloGC!");
        List<Byte[]> list = new LinkedList<>();
        for (; ; ) {
            // 1024*1024 = 1M
            Byte[] b = new Byte[1024 * 1024];
            list.add(b);
        }
    }
}
