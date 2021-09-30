package com.makotogu.nio.c4;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

import static com.makotogu.nio.c1c2c3.ByteBufferUtil.debugRead;

@Slf4j(topic = "c.Sever")
public class Server {
    public static void main(String[] args) throws IOException {
        // 使用nio来理解阻塞模式 单线程
        // 0. ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(16);
        // 1. 创建了服务器
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false); // 切换到非阻塞模式 影响accept
        // 2. 绑定监听端口
        serverSocketChannel.bind(new InetSocketAddress(8888));
        // 3. 连接集合
        List<SocketChannel> channelList = new ArrayList<>();
        while(true) {
            // 4. accept 建立与客户端链接，SocketChannel用来与客户端之间通信
            SocketChannel socketChannel = serverSocketChannel.accept();
            log.debug("connected--- {}", socketChannel);
            socketChannel.configureBlocking(false);
            channelList.add(socketChannel);
            for (SocketChannel channel : channelList) {
                // 5. 接收
                channel.read(buffer); // 阻塞方法，线程停止运行
                buffer.flip();
                debugRead(buffer);
                buffer.clear();
                log.debug("after read--- {}", socketChannel);
            }

        }
    }
}
