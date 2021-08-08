package makotogu.jvm_gc;

import java.util.ArrayList;

public class GCAnalyze {
    private static final int _512KB = 512*1024;
    private static final int _1MB = 1*1024*1024;
    private static final int _6MB = 6*1024*1024;
    private static final int _7MB = 7*1024*1024;
    private static final int _8MB = 8*1024*1024;

    //-Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
    public static void main(String[] args) throws InterruptedException {
        //ArrayList<byte[]> list = new ArrayList<>(); 测试线程时关闭
        /*
        list.add(new byte[_7MB]); //大对象在内存有限的情况下，动态晋升
        list.add(new byte[_512KB]);
        list.add(new byte[_512KB]);
        */
        /*
        list.add(new byte[_8MB]); //根本放不下伊甸园(新生代空间不够，老年代足够)，会直接存入老年代，不触发垃圾回收
        */
        /*
        list.add(new byte[_8MB]);
        list.add(new byte[_8MB]);
        */
        new Thread(()->{
            ArrayList<byte[]> list = new ArrayList<>();
            list.add(new byte[_8MB]);
            list.add(new byte[_8MB]);
        }).start();

        System.out.println("asleep");
        Thread.sleep(1000);
        System.out.println("awake");
    }
}
