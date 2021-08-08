package makotogu.pattern.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类也实现了对应接口
 */
public class ProxyFactory {

    //声明目标对象
    private TrainStation trainStation = new TrainStation();

    public SellTickets getProxyObject() {
        //返回代理对象

        /**
         *  ClassLoader loader ：类加载器，用于加载代理类。可以通过目标对象获取类加载器
         *  Class<?>[] interfaces ：代理类实现的接口的字节码对象
         *  InvocationHandler h ：代理对象的调用处理程序
         */
        SellTickets proxyInstance = (SellTickets) Proxy.newProxyInstance(
                trainStation.getClass().getClassLoader(),
                trainStation.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    /**
                     * Object proxy: 代理对象。和proxuObject对象是一个对象，在invoke方法中基本不用
                     * Method method: 对接口中的方法进行封装的method对象
                     * Object[] args: 调用方法的实际参数
                     *
                     * @return: 方法的返回值
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //System.out.println("invoke方法执行了");
                        System.out.println("代售点收取一定费用（jdk）");
                        //执行目标对象的方法
                        Object invoke = method.invoke(trainStation, args);
                        return invoke;
                    }
                }
        );
        return proxyInstance;
    }


}
