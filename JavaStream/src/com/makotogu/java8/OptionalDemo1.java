package com.makotogu.java8;

import java.util.Optional;

public class OptionalDemo1 {
    public static void main(String[] args) {
//        Optional<Object> optionalString = Optional.empty();
        Optional<String> test = Optional.of("test");
        String string = (String) test.orElse("");
        System.out.println(test.toString());
        System.out.println(string);
    }
}
