package com.makotogu.algorithm.test;

import com.makotogu.algorithm.linear.Stack;

public class BracketsMatchTest {
    public static void main(String[] args) {
        String str = "(上海(beijing))";
        boolean match = isMatch(str);
        System.out.println(match);
    }

    public static boolean isMatch(String str) {
        Stack<Character> stack = new Stack<Character>();
        char[] chars = str.toCharArray();
        for (Character chr : chars) {
            if (chr == '(') {
                stack.push(chr);
            } else if (chr == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}


