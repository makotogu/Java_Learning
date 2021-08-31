package com.makotogu.algorithm.test;

import java.io.*;
import java.util.ArrayList;

public class WriteTest {
    public static void main(String[] args) throws IOException {
        File f = new File("resources/reverse_arr.txt");
        OutputStream outputStream = new FileOutputStream(f);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
        for (Integer i = 100000; i >= 0; i--) {
            outputStreamWriter.append((i).toString());
            outputStreamWriter.append("\r\n");
        }
        outputStreamWriter.close();
        outputStream.close();
    }
}
