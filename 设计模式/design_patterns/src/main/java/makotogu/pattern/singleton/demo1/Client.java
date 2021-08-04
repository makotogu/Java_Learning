package makotogu.pattern.singleton.demo1;

public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println("两者是否为同一个对象"+(instance2 == instance));
    }
}
