package com.makotogu.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo1 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("add", "bb", "cc", "adc", "apple","electric");

        List<String> a = strings.stream()
                .filter(s -> s.startsWith("a"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(a);
        List<String> c = strings.stream()
                .filter(s -> s.endsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(c);
        List<String> s = Arrays.asList("hello","world");

    }
}
