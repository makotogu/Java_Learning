package com.makotogu.test;

/**
 * 说一下ThreadLocal
 * 1. ThreadLocal是Java中提供的线程本地存储机制，可以利用该机制将数据缓存在某个线程内部，
 * 该线程可以在任意时刻、任意方法中获取缓存的数据
 * 2. ThreadLocal底层通过TreadLocalMap来实现的，每个Thread对象(注意不是TreadLocal对象—）
 * 中都存在一个ThreadLocalMap对象，Map的key值为ThreadLocal对象，Map的value为需要缓存的值
 */
public class Test03 {
}
