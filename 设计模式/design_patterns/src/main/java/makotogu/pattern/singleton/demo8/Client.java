package makotogu.pattern.singleton.demo8;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 测试反射破坏单例
 */
public class Client {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取字节码对象
        Class<Singleton> singletonClass = Singleton.class;
        //获取无参构造方法对象
        Constructor<Singleton> declaredConstructor = singletonClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton newInstance = declaredConstructor.newInstance();
        Singleton newInstance1 = declaredConstructor.newInstance();
        System.out.println(newInstance == newInstance1);
    }
}
