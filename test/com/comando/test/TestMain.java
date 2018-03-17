package com.comando.test;

/**
 * Created by comando on 2018/3/17.
 *
 * 简单通用测试类
 */
public class TestMain {
    public static void main(String[] args) {

        String path = "a.b";
        int pos = path.indexOf(".");
        // Handle nested properties recursively
        String nestedProperty = path.substring(0, pos);
        String nestedPath = path.substring(pos + 1);

        String substring = path.substring(path.lastIndexOf(".") + 1);

        System.out.println(nestedProperty);
        System.out.println(nestedPath);
        System.out.println(substring);
    }
}
