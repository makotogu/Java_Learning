package makotogu.n2;

import lombok.extern.slf4j.Slf4j;
import makotogu.Constants;
import makotogu.n2.util.FileReader;

@Slf4j(topic = "c.Async")
public class Async {
    public static void main(String[] args) {
        new Thread(()-> FileReader.read(Constants._FULL_PATH)).start();
        log.debug("do other things ...");
    }
}
