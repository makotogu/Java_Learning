package makotogu.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

import static makotogu.n2.util.Sleeper.sleep;

@Slf4j(topic = "c.Test14")
public class Test14 {
    public static void main(String[] args) throws InterruptedException {
        test3();
    }

    private static void test3() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("park...");
            LockSupport.park();
            log.debug("unpark...");
//            log.debug("打断状态: {}",Thread.currentThread().isInterrupted());
            log.debug("打断状态: {}",Thread.interrupted());

            LockSupport.park();
            log.debug("unpark---");
        },"t1");
        t1.start();

        sleep(1);
        t1.interrupt();
    }
}
