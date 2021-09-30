package com.makotogu.nio.c1c2c3;

import java.nio.ByteBuffer;

import static com.makotogu.nio.c1c2c3.ByteBufferUtil.debugAll;

public class TestByteBufferExam {
    public static void main(String[] args) {
        /**
         * 网络上有多条数据发送给服务端，数据之间使用 \n 进行分隔
         * 但由于某种原因这些数据在接收时，被进行了重新组合，例如原始数据有3条为
         *
         * * Hello,world\n
         * * I'm zhangsan\n
         * * How are you?\n
         *
         * 变成了下面的两个 byteBuffer (黏包，半包)
         *
         * * Hello,world\nI'm zhangsan\nHo
         * * w are you?\n
         *
         * 现在要求你编写程序，将错乱的数据恢复成原始的按 \n 分隔的数据
         */
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello,world\nI'm zhangsan\nHo".getBytes());
        split(source);
        source.put("w are you?\n".getBytes());
        split(source);
    }

    /**
     * 解决粘包半包问题
     * @param source
     */
    private static void split(ByteBuffer source) {
        source.flip(); // 切换到读模式
        for (int i = 0; i < source.limit(); i++) {
            // 找到分割符号
            if (source.get(i) == '\n') {
                int length = i - source.position() + 1;
                // 把这条消息完整存入新的ByteBuffer
                ByteBuffer target = ByteBuffer.allocate(length);
                // 从source读, 向target写
                for (int j = 0; j < length; j++) {
                    target.put(source.get());
                }
                debugAll(target);
            }
        }
        source.compact();
    }
}
