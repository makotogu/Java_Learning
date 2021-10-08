package com.makotogu.java_interview.map;

import java.util.HashMap;

public class HashMapMissData {
    public static void main(String[] args) throws InterruptedException {

        HashMap<String, Object> map = new HashMap<>();
        Thread t1 = new Thread(() -> {
            map.put("a", new Object());
        }, "t1");

        Thread t2 = new Thread(() -> {
            map.put("1", new Object());
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(map);
    }
}
