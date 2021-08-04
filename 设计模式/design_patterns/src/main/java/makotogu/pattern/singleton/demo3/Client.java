package makotogu.pattern.singleton.demo3;

public class Client {
    public static void main(String[] args) {
        final Singleton[] instance1 = new Singleton[1];
        final Singleton[] instance2 = new Singleton[1];
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    instance1[0] = Singleton.getInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    instance2[0] = Singleton.getInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
        System.out.println(instance2[0] == instance1[0]);
    }
}
