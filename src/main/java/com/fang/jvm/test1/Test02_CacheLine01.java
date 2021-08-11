package com.fang.jvm.test1;

/**
 * @author fanglingxiao
 * @version 1.0
 * @description TODO
 * @date 2021/8/12 12:39 上午
 **/
public class Test02_CacheLine01 {
    private static class T {
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(() -> {
            for (long i = 0; i < 1000_0000L; i++) {
                arr[0].x = i;
            }
        });
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 1000_0000L; i++) {
                arr[1].x = i;
            }
        });
        final long start = System.nanoTime();
        t0.start();
        t1.start();
        t0.join();
        t1.join();
        System.out.println((System.nanoTime() - start) / 100_0000);
    }
}
