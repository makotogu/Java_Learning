package com.makotogu.netty.c3;

import io.netty.channel.EventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.DefaultPromise;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

@Slf4j(topic = "c.TestNettyPromise")
public class TestNettyPromise {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NioEventLoopGroup nioEventLoopGroup = new NioEventLoopGroup();
        EventLoop eventLoop = nioEventLoopGroup.next();
        // 可以主动创建promise对象
        DefaultPromise<Object> defaultPromise = new DefaultPromise<>(eventLoop);

        new Thread(() -> {
            log.debug("开始计算");
            try {
                Thread.sleep(1000);
                int i = 1 / 0;
                defaultPromise.setSuccess(80);
            } catch (Exception e) {
                e.printStackTrace();
                defaultPromise.setFailure(e);
            }
        }).start();

        log.debug("等待结果");
        log.debug("结果：{}", defaultPromise.get());
    }
}
