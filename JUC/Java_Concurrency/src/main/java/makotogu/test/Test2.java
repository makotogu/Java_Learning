package makotogu.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test2")
public class Test2 {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                log.debug("running");
            }
        };
        Runnable r2 = () -> {
            log.debug("running");
        };
        Thread t1 = new Thread(r1,"t1");
        Thread t2 = new Thread(r2, "t2");
        t1.start();
        t2.start();
    }
}
