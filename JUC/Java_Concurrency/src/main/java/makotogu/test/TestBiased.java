package makotogu.test;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

@Slf4j(topic = "c.TestBiased")
public class TestBiased {
    public static void main(String[] args) throws InterruptedException {
        Dog d = new Dog();
        log.debug(ClassLayout.parseInstance(d).toPrintable());

        new Thread(() ->{
            log.debug(ClassLayout.parseInstance(d).toPrintable());
            synchronized(d) {
                log.debug(ClassLayout.parseInstance(d).toPrintable());
            }
            log.debug(ClassLayout.parseInstance(d).toPrintable());
            synchronized (TestBiased.class) {
                TestBiased.class.notify();
            }
        }, "t1").start();

        new Thread(() ->{
            synchronized (TestBiased.class) {
                try {
                    TestBiased.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug(ClassLayout.parseInstance(d).toPrintable());
            synchronized(d) {
                log.debug(ClassLayout.parseInstance(d).toPrintable());
            }
            log.debug(ClassLayout.parseInstance(d).toPrintable());
        }, "t2").start();

    }
}

class Dog {

}