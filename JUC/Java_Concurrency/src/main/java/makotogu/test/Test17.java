package makotogu.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test17")
public class Test17 {
    static int counter = 0;
    public static void main(String[] args) throws InterruptedException {
        Room room = new Room();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.increment();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                room.decrement();
            }
        }, "t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("{}",room.getCounter());

    }
}

class Room {
    private int counter = 0;
    public synchronized void increment() {
            counter++;
    }
    public synchronized void decrement() {
            counter--;
    }

    public int getCounter() {
        synchronized (this) {
            return counter;
        }
    }
}
