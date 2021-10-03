package com.makotogu.java_interview.list;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastVsFailSafe {
    // fail-fast 一旦发现遍历的同时有人修改跑出一场
    // fail-safe 发现遍历的同时有人修改，应当能有应对策略，例如牺牲一致性来让遍历完成

    private static void failFast() {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("A"));
        list.add(new Student("B"));
        list.add(new Student("C"));
        list.add(new Student("D"));
        list.add(new Student("E"));
        for (Student student : list) {
            System.out.println(student);
        }
    }

    private static void failSafe() {
        CopyOnWriteArrayList<Student> list = new CopyOnWriteArrayList<>();
        list.add(new Student("A"));
        list.add(new Student("B"));
        list.add(new Student("C"));
        list.add(new Student("D"));
        list.add(new Student("E"));
        for (Student student : list) {
            System.out.println(student);
        }
        System.out.println(list);
    }

    static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }


    }

    public static void main(String[] args) {
//        failFast();
        failSafe();
    }
}
