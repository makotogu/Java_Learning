package makotogu.pattern.singleton.demo5;

/**
 * 懒汉模式：静态内部类方式
 */
public class Singleton {

    private Singleton() {}

    //定义一个静态内部类
    private static class SingletonHolder {
        //在内部类中声明并初始化外部类的对象
        private static final Singleton INSTANCE = new Singleton();
    }

    //提供公共的访问方式
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
