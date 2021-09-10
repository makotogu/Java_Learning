package makotogu.test;

import lombok.extern.slf4j.Slf4j;
import makotogu.n2.util.Sleeper;

@Slf4j(topic = "c.Test16")
public class Test16 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("洗水壶");
            Sleeper.sleep(2);
            log.debug("烧开水");
            Sleeper.sleep(10);
            log.debug("烧好啦");
        },"老王");
        Thread t2 = new Thread(() -> {
            log.debug("洗茶壶");
            Sleeper.sleep(1);
            log.debug("洗茶杯");
            Sleeper.sleep(2);
            log.debug("拿茶叶");
            Sleeper.sleep(1);
            try {   
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("泡茶");
        },"老李");
        t1.start();
        t2.start();
    }
}
