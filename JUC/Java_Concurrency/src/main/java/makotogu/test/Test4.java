package makotogu.test;

import lombok.extern.slf4j.Slf4j;
import makotogu.Constants;
import makotogu.n2.util.FileReader;

@Slf4j(topic = "c.Test4")
public class Test4 {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                FileReader.read(Constants._FULL_PATH);
                log.debug("running----");
            }
        };
        t1.run();
        log.debug("do other things---");
    }
}
