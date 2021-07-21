package com.fang.jvm.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author fanglingxiao
 * @version 1.0
 * @description 自定义加载器
 * @date 2021/7/13 12:40 上午
 **/
public class Test05_MyClassLoader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        File file = new File("/Users/james/Documents/workspace/JavaStudySpace/jvm", name.replaceAll("\\.", "/").concat(".class"));
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b;
            while ((b = fis.read()) != 0) {
                baos.write(b);
            }
            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.loadClass(name);
    }

    public static void main(String[] args) throws Exception {
        ClassLoader loader = new Test05_MyClassLoader();
        Class clazz = loader.loadClass("com.fang.jvm.test.HelloJVM");
        Class clazz2 = loader.loadClass("com.fang.jvm.test.HelloJVM");
        System.out.println(clazz == clazz2);
        HelloJVM hello = (HelloJVM) clazz.newInstance();
        hello.hello();
        System.out.println(loader.getClass().getClassLoader());
        System.out.println(loader.getParent());
    }
}
