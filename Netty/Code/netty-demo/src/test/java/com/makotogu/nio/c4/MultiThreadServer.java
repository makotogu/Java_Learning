package com.makotogu.nio.c4;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

import static com.makotogu.nio.c1c2c3.ByteBufferUtil.debugAll;

@Slf4j(topic = "c.MultiThreadServer")
public class MultiThreadServer {
    public static void main(String[] args) throws IOException {
        Thread.currentThread().setName("boss");
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        Selector boss = Selector.open();
        SelectionKey bossKey = serverSocketChannel.register(boss, 0, null);
        bossKey.interestOps(SelectionKey.OP_ACCEPT);
        serverSocketChannel.bind(new InetSocketAddress(9999));
        // 创建固定数量的worker 并初始化
        Worker[] workers = new Worker[Runtime.getRuntime().availableProcessors()];
        for (int i = 0; i < workers.length; i++) {
            workers[i] = new Worker("worker_"+i);
        }
//        Worker worker = new Worker("worker_0");
//        worker.register();
        AtomicInteger index = new AtomicInteger();
        while (true) {
            boss.select();
            Iterator<SelectionKey> iterator = boss.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isAcceptable()) {
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    log.debug("connected...{}", socketChannel.getRemoteAddress());
                    // 关联Selector
                    log.debug("before register...{}", socketChannel.getRemoteAddress());
//                    socketChannel.register(worker.selector, SelectionKey.OP_READ, null);
                    // round robin 轮询
                    workers[index.getAndIncrement() % workers.length].register(socketChannel);
                    log.debug("after register...{}", socketChannel.getRemoteAddress());
                }
            }
        }
    }
    static class Worker implements Runnable {
        private Thread thread;
        private Selector selector;
        private String name;
        private volatile boolean start = false; // 还未初始化

        public Worker(String name) {
            this.name = name;
        }

        /**
         * 初始化线程和selector
         */
        public void register(SocketChannel socketChannel) throws IOException {
            if (!start) {
                thread = new Thread(this, name);
                selector = Selector.open();
                thread.start();
                start = true;
            }
            selector.wakeup();
            socketChannel.register(selector, SelectionKey.OP_READ, null);
        }

        @Override
        public void run() {
            while(true) {
                try {
                    selector.select();
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isReadable()) {
                            ByteBuffer byteBuffer = ByteBuffer.allocate(16);
                            SocketChannel socketChannel = (SocketChannel) key.channel();
                            log.debug("read...{}",socketChannel.getRemoteAddress());
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
