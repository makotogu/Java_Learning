package makotogu.n2;

import lombok.extern.slf4j.Slf4j;
import makotogu.Constants;
import makotogu.n2.util.FileReader;

@Slf4j(topic = "c.Sync")
public class Sync {

    public static void main(String[] args) {
        FileReader.read(Constants._FULL_PATH);
        log.debug("do other things---");
    }
}
