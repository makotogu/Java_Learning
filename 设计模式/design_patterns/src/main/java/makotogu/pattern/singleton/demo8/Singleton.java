package makotogu.pattern.singleton.demo8;

import java.io.Serializable;

public class Singleton implements Serializable {

    private static boolean flag = false;

    private Singleton() {
        synchronized (Singleton.class) {
            //判断flag的值是否是true，如果是true，说明非第一次访问,直接抛异常
            if (flag) {
                throw new RuntimeException("不能创建多个对象");
            }
            //将flag设置为true
            flag = true;
        }
    }

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