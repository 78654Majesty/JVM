package com.fang.jvm.test1;

/**
 * @author fanglingxiao
 * @version 1.0
 * @description class加载过程 linking+init步骤
 * @date 2021/8/11 11:33 下午
 **/
public class Test01_ClassLoading {
    /**
     * 1.T.class加载到内存
     * 2.preparation过程为静态变量赋默认值
     * 3.init过程为静态变量赋初始值
     */
    public static void main(String[] args) {
        System.out.println(T.count);
    }
}

class T {
    public static T t = new T();
    public static int count = 2;

    private T() {
        count++;
    }
}
