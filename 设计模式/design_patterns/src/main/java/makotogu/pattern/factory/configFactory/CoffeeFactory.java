package makotogu.pattern.factory.configFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class CoffeeFactory {

    //加载配置文件，获取配置文件中配置的全类名，并创建该类的对象进行存储
    //1. 定义容器对象存储咖啡对象
    private static HashMap<String, Coffee> map = new HashMap<String, Coffee>();
    //2. 加载配置文件，只需要加载一次
    static {
        //2.1 创建properties对象
        Properties properties = new Properties();
        //2.2 使用properties的load方法进行配置文件的加载
        InputStream inputStream = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(inputStream);
            //从properties集合中获取全类名并创建对象
            for (Object o : properties.keySet()) {
                String className = properties.getProperty((String) o);
                //通过反射技术创建对象
                Class cls = Class.forName(className);
                Coffee coffee = (Coffee) cls.newInstance();
                //将名称和对象存储到容器中
                map.put((String) o, coffee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Coffee createCoffee(String type) {
        return map.get(type);
    }
}
