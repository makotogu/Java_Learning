package com.makotogu.nio.c1c2c3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class TestFileChannelTransferTo {
    public static void main(String[] args) {
        try (FileChannel from = new FileInputStream("data.txt").getChannel();
             FileChannel to = new FileOutputStream("to.txt").getChannel()
        ) {
            // 效率高，底层会利用操作系统的零拷贝进行优化， 传输数据是有上限的（2GB）
            long size = from.size();
            // left变量代表还剩余多少字节没有输出
            for (long left = size; left>0; ) {
                System.out.println("position: "+(size-left)+" left: "+left);
                left -= from.transferTo((size-left), left, to);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
