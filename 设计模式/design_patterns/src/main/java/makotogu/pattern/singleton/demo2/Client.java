package makotogu.pattern.singleton.demo2;

public class Client {
    public static void main(String[] args) {
        makotogu.pattern.singleton.demo2.Singleton instance = makotogu.pattern.singleton.demo2.Singleton.getInstance();
        makotogu.pattern.singleton.demo2.Singleton instance2 = Singleton.getInstance();
        System.out.println("两者是否为同一个对象"+(instance2 == instance));
    }
}
