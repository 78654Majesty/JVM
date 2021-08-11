package com.fang.jvm.test1;

/**
 * @author fanglingxiao
 * @version 1.0
 * @description 根据Test02_CacheLine01和Test03_CacheLine02的执行结果
 * 得到：
 * cpu缓存换读取是以缓存行64字节为单位，
 * Test02_CacheLine01中arr[0].x和arr[1].x在一个缓存行，cpu内部相互影响导致执行时间偏长
 * 而
 * Test02_CacheLine01中arr[0].x和arr[1].x不在一个缓存行中，cpu内部不受影响执行快
 * @date 2021/8/12 12:39 上午
 **/
public class Test03_CacheLine02 {
    private static class Padding {
        public volatile long p1, p2, p3, p4, p5, p6, p7;
    }

    private static class T extends Padding {
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
