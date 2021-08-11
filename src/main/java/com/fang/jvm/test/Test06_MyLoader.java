package com.fang.jvm.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author fanglingxiao
 * @version 1.0
 * @description TODO
 * @date 2021/8/11 11:19 下午
 **/
public class Test06_MyLoader extends ClassLoader {
    /**
     * 重写loadClass 破坏双亲委派
     *
     * @author fanglingxiao
     * @createDateTime 2021/8/11 11:20 下午
     */
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        File file = new File("/Users/james/Documents/workspace/JavaStudySpace/jvm", name.replaceAll("\\.", "/").concat(".class"));
        if (!file.exists()) return super.loadClass(name);
        try {
            InputStream is = new FileInputStream(file);
            byte[] b = new byte[is.available()];
            is.read(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.loadClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Test06_MyLoader loader = new Test06_MyLoader();
        Class clazz1 = loader.loadClass("com.fang.jvm.test.HelloJVM");
        Class clazz2 = loader.loadClass("com.fang.jvm.test.HelloJVM");
        System.out.println(clazz1 == clazz2);
        System.out.println("------------------");
        loader = new Test06_MyLoader();
        Class clazz3 = loader.loadClass("com.fang.jvm.test.HelloJVM");
        // 如果true 则还是走的双亲委派，未找到该文件，所以还是走父类loadClass方法
        System.out.println(clazz2 == clazz3);
    }
}
