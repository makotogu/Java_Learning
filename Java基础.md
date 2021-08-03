# 面向对象基础
## 类
* 类中的五个成分(有且仅有)
  1. 成员变量(Field):  描述类或者对象的属性信息的。
  2. 成员方法(Method): 描述类或者对象的行为信息的。
  3. 构造器(Constructor): 初始化一个对象返回。
  4. 代码块
  5. 内部类

## 封装
* 优点: 
  * 减少耦合: 
  * 可以独立地开发、测试、优化、使用、理解和修改 减轻维护的负担: 
  * 可以更容易被程序员理解，并且在调试的时候可以不影响其他模块 有效地调节性能: 
  * 可以通过剖析确定哪些模块影响了系统的性能 提高软件的可重用性 降低了构建大型系统的风险: 
  * 即使整个系统不可用，但是这些独立的模块却有可能是可用的
``` java
package basicPackage;

import java.util.Date;

public class Person {
    private String name;
    private Integer age;
    private Date birthday;

    /*省略getter setter*/
}

```
* get方法 获得东西 理解为得到对象的某个属性
* set方法 设置东西 理解为为对象设置某个属性
* tostring 将类设置为String 输出的时候好看、好观察 本质是一个强制转换为String的方法

## 继承
继承实现了一种 IS-A 的关系
* 例子 给person加一个方法，写一个类继承person

## 多态
多态是同一个行为具有多个不同表现形式或形态的能力


``` java
import basicPackage.Person;
import basicPackage.Worker;
import org.junit.Test;

public class BasicTest {

    @Test
    public void testBasic() {
        Person person = new Person();
        Person worker = new Worker();

        person.introduce();
        worker.introduce();

        person.setAge(20);
        worker.setAge(16);
        
        System.out.println(person.getAge());
        System.out.println(worker.getAge());
    }
}
```

# 工具详解 - Maven项目构建
* maven项目最重要的是结构
  * 根目录(src)：
    * main:
      * java:
      * resources:
      * ...
    * test:
  * pom.xml

* pom.xml
``` xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>org.example</groupId>
    <artifactId>project</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
    </properties>

</project>
```
* 这是最基本的空的maven的配置文件，可以看到一个约束头，没人记得住，反正都是idea帮忙生成的，没有生成就去复制
* 然后看到第一个 modelVersion 它就是4.0.0 规定死的 现在都用 maven2、maven3 它们的version就是4.0.0
* 然后是groupId那一坨 可以看到 我没改动就是默认长这样的 说明java希望大家用com.xxx.xxx去设置文件的层级、取名 一般我会叫什么（makotogu）github的昵称， 然后是artifact就是你项目的名字，然后version就是版本了
* dependency 这个就是依赖管理了，maven好用的地方来了  众所周知java很多功能都有别人帮忙完成，我们去偷一下就行，从哪里去偷？没有maven、gradle这种工具只能从网上去下载，下载完之后添加到库再去使用，麻烦。maven提供了巨多的依赖，他提供了官方的依赖仓库，https://mvnrepository.com/ 这个地方就是官方的依赖了，复制黏贴一下就可以用了。
* properties 这个怎么说呢，其实有很多用法，但是这里基础就只需要去写个这个，这样可以避免一部分时候idea抽风，用错jdk的版本减少一点报错的可能。 
* 还有一个plugins 可以在maven的功能里加什么tomcat启动什么的 快捷一点省力一点，没怎么特别用过，大概是idea太好了吧

* maven会一直存在，它超好的，但不排除如果我学了gradle变心了，那就会再写gradle怎么去用。
* 后面的ssm也都是用maven做管理的

# 服务器 tomcat
* 这个说难不难，说简单不简单。 汤姆猫？
* 这是一个开源的服务器，好多都用这个，配置完一大坨就可以在电脑上启动web服务，这个电脑就不是普通的电脑了就是一台服务器了。在同一个局域网应该是可以去多设备访问的，如果访问不到也蛮正常的，可能防火墙没设置，可能配置关掉了，具体情况具体分析。
* 下载就不说了 但建议不要用9以后的版本，有些包貌似还不支持，等支持我就改。（java还行，用python最新的的话pip版本支持少得可怜直接死亡）
* 展开叙述生命周期，设计思想比较的复杂，可以考虑先会做事，再去理解，打算放在能做一整个页面之后再去解释
* b站服务器挂掉的时候，发现b站用的是淘宝的开源Tengine

# 基本语法
java中万物都是对象！！！！！！！！！！！
## 基本数据结构
* ArrayList 编写了测试程序 得到实际容量大小和存储数据多少的比对，得出ArrayList的自动扩容原则为原来大小的1.5倍，初始的容量为10。
* LinkedList 是一个双向链表 

* hashmap<> 哈希表
  * 跟着代码看一下原理（java1.7及其以前和java1.8及其以后的map有方法产生变化了）


* 提一嘴 idea 按住crtl再去点击类可以进入类的定义界面

## 反射！！！！！！！！！！！！！！！！！！ 究极厉害
* Java反射机制的核心是在程序运行时动态加载类并获取类的详细信息，从而操作类或对象的属性和方法。本质是JVM得到class对象之后，再通过class对象进行反编译，从而获取对象的各种信息
* 反射就像流氓，什么面向对象的封装全部无视，什么都可以动态获取
``` java
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

```
 
## 注解 非常好用需要了解，一般不会自己去写注解
* 专门有注解开发需要理解，但是由于完成一个流程使用Spring提供的注解已经足够了，不用尝试学会开发注解。
* 注解：注释+解释 ，首先告诉程序这是什么，同时也是告诉用户这是什么。