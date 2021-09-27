package com.makotogu.c4;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import static com.makotogu.c1c2c3.ByteBufferUtil.debugAll;

public class MultiThreadServer {
    public static void main(String[] args) throws IOException {
        Thread.currentThread().setName("boss");
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        Selector boss = Selector.open();
        SelectionKey bossKey = serverSocketChannel.register(boss, 0, null);
        bossKey.interestOps(SelectionKey.OP_ACCEPT);
        serverSocketChannel.bind(new InetSocketAddress(8080));
        while (true) {
            boss.select();
            Iterator<SelectionKey> iterator = boss.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    new Worker("worker_0");
                }
            }
        }
    }
    static class Worker implements Runnable {
        private Thread thread;
        private Selector worker;
        private String name;
        private volatile boolean start = false; // 还未初始化

        public Worker(String name) {
            this.name = name;
        }

        /**
         * 初始化线程和selector
         */
        public void register() throws IOException {
            if (!start) {
                thread = new Thread(this, name);
                thread.start();
                worker = Selector.open();
                start = true;
            }
        }

        @Override
        public void run() {
            while(true) {
                try {
                    worker.select();
                    Iterator<SelectionKey> iterator = worker.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isReadable()) {
                            ByteBuffer byteBuffer = ByteBuffer.allocate(16);
                            SocketChannel socketChannel = (SocketChannel) key.channel();
                            socketChannel.read(byteBuffer);
                            byteBuffer.flip();
                            debugAll(byteBuffer);
                         }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
