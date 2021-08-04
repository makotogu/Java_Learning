package makotogu.pattern.singleton.demo3;


/**
 * 懒汉式-方式1：线程不安全
 */
public class Singleton {
    // 私有构造方法
    private Singleton() {}
    //声明Singleton类型的变量instance
    private static Singleton instance;
    //对外提供访问方式
    public static Singleton getInstance() throws InterruptedException {
        if (instance == null) {
            Thread.sleep(200);
            instance = new Singleton();
        }
        return instance;
    }
}
