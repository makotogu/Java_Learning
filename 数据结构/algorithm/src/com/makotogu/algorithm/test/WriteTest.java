package com.makotogu.algorithm.test;

import java.io.*;
import java.util.Random;

public class WriteTest {
    public static void main(String[] args) throws IOException {
        File f = new File("resources/reverse_arr.txt");
        OutputStream outputStream = new FileOutputStream(f);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
        for (int i = 50_000; i >= 1; i--) {
            int anInt = new Random().nextInt();
//            int anInt = i % 2 == 0 ? i : 1000000-i;
            outputStreamWriter.append((new Integer(anInt)).toString());
            outputStreamWriter.append("\r\n");
        }
        outputStreamWriter.close();
        outputStream.close();
    }
}
