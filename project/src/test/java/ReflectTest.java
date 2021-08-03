import makotogu.basicPackage.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    //反射的一个是获得类
    @Test
    public void test1() {
        Person person = new Person();
        System.out.println(person.getClass());
        //多此一举 我已经知道这个是什么类了 但是可以演示获取这个类的名字
        //输出结果： class makotogu.basicPackage.Person
    }
    @Test
    public void test2() {
        try {
            Class cls = Class.forName("makotogu.basicPackage.Person");
            System.out.println(cls.isArray());
            System.out.println(cls.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //这就牛了啊，虽然可以看到我是输入了一个名字在里面，
        //但是如果我去设置一个方法，设置一个配置可以传递这个全类名
        //那么框架就可以获取类，去判断类的各种功能属性
        //那么就可以实现哪些框架去获取类名的工作
        //举例说明：IOC (inversion of control) == DI （dependency injection） 工厂模式设计模式
    }

    //通过反射获取属性值
    @Test
    public void test3(){
        try {
            Class cls = Class.forName("makotogu.basicPackage.Person");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }
            Field age = cls.getDeclaredField("age");
            age.setAccessible(true);  // 设置让我访问
            Object obj = cls.getConstructor().newInstance();
            age.set(obj, 17);
            Person person = (Person) obj;
            System.out.println(person.getAge());
        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        Person person = new Person();
        person.setAge(18);
        person.setName("zy");
        Class<? extends Person> cls = person.getClass();
        try {
            Field age = cls.getDeclaredField("age");
            age.setAccessible(true);  // 设置让我访问
            age.set(person, 17);
            Field name = cls.getDeclaredField("name");
            name.setAccessible(true);
            name.set(person, "zhouy");
            System.out.println(person.toString());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        //看起来毫无作用，但是如果这个对象是外部传给我的就有作用。
        //将上述两个方法结合，可以做到耍流氓般的把对象所有的属性啊什么的都获取，还可以随意修改
    }


    //还有一种就是方法 反射依旧可以获取方法并且使用它
    @Test
    public void test5() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person = new Person();
        person.setAge(18);
        person.setName("zy");
        Class<? extends Person> cls = person.getClass();
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        Method setName = cls.getMethod("setName", String.class);
        Method setAge = cls.getMethod("setAge", Integer.class);
        Method sayHello = cls.getDeclaredMethod("sayHello"); //declaredMethod无视私有
        Method getAge = cls.getMethod("getAge");
        Method getName = cls.getMethod("getName");
        setName.invoke(person,"周莹");
        setAge.invoke(person,17);
        sayHello.setAccessible(true); // 私有方法需要设置让我访问，否则就报错
        sayHello.invoke(person);
        System.out.println(getAge.invoke(person) + "  " + getName.invoke(person));

        //这个test就展示了从传入对象到获取对象方法，再利用获取到的对象的方法去修改对象的属性值
    }

}
