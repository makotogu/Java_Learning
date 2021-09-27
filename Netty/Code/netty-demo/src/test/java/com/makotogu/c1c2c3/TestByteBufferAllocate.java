package com.makotogu.c1c2c3;

import java.nio.ByteBuffer;

public class TestByteBufferAllocate {
    public static void main(String[] args) {
        System.out.println(ByteBuffer.allocate(16).getClass());
        System.out.println(ByteBuffer.allocateDirect(16).getClass());
        /**
         * class java.nio.HeapByteBuffer     - java 堆内存，读写效率较低, 会受到GC的影响
         * class java.nio.DirectByteBuffer   - 直接内存，读写效率高(少一次拷贝)，不会受到GC的影响，分配速度比较慢
         */
    }
}

