# 面向对象和面向过程的区别

- **面向过程**：**面向过程比面向对象性能高**。因为类调用时需要实例化，开销比较大，比较消耗资源，所以当性能是最重要的考量因素的时候，比如单片机、嵌入式开发、Linux/Unix 等一般采用面向过程开发。但是没有面向对象**易维护、易服用、易扩展**。
- **面向对象**：**面向对象易维护、易复用、易扩展**。因为面向对象有封装、继承、多态性的特性，所以可以设计出低耦合的系统，使系统更加灵活、更加易于维护。但是，**面向对象性能比面向过程低**。

> c 和 c++都是编译成为机器码，所以面向对象和面向性能区别不大
>
> 性能差异是来自于这个语言的执行机制，而不是这个语言采用的编程范式。

# Java 语言特点

1. 简单好学
2. 面向对象（封装，继承，多态）
3. 跨平台（JVM）
4. 可靠性
5. 安全性
6. 支持多线程
7. 支持网络编程（很方便）
8. 编译与解释并存

# 关于 JVM，JDK 和 JRE

## JVM

Java 虚拟机，是运行 Java 字节码的虚拟机。JVM 有针对不同系统的特定实现，目的是使用相同的字节码都会得到相同的结果。

**什么事字节码？好处是什么？**

> 在 Java 中，JVM 可以理解的代码就叫做*字节码*(.class 文件)，它只面向虚拟机。Java 通过字节码的方式一定程度解决了解释型语言效率低，但又保留了解释型语言可移植的特点。

**Java 程序从源代码到运行步骤**

1. .java 文件经过 javac 编译为.class 文件
2. .class 文件通过 JVM 变为机器可以执行的二进制机器码

> 注意第二步(.class->机器码)中,这一步 JVM 类加载器首先会加载字节码文件，然后通过解释器逐行解释执行，这样会相对较慢，而且有一些方法和代码块是经常被调用的(也就是所谓的热点代码)，所以就引入了 JIT 编译器，而 JIT 属于运行时编译。当 JIT 编译器完成第一次编译后，其会将字节码对应的机器码保存下来，下次可以直接使用。这也就解释了为什么 Java 代码第一次运行会相对较慢，之后就会很快。同时也解释了为什么说 Java 是编译和解释共存的语言。

## JDK 和 JRE

- JDK 是 Java Development Kit，它是功能齐全的 Java SDK。它拥有 JRE 所拥有的一切，还有编译器(javac)和工具(Javadoc 和 jdb 等)。它能够创建和编译程序。
- JRE 是 Java 运行时的环境(Java SE Runtime Environment),运行已编译的 Java 程序所需要的所有内容的集合，包括 Java 虚拟机(JVM)，Java 类库，Java 命令和其他的一些基础构件。但是不能用于创建新程序。

# 字符型常量和字符串常量的区别？

1. 形式上：字符常量是单引号引起的一个字符；字符串常量是双引号引起的若干个字符
2. 含以上：字符常量相当于一个 int 值(ASCII 值)，可以参加表达式计算；字符串常量表示一个地址值(该字符串内存中存放位置)
3. 占内存大小：字符常量只占用 2 个字节；字符串常量占用若干个字节

# 构造器 Constructor 是否可以被 Override？

> Constructor 不能被重写(Override)，但是可以被重载(Overload)，所以可以看到一个类中有多个构造函数的情况

# 重载和重写的区别

**重载**

> 发生在同一个类中，方法名必须相同，参数类型不同、个数不同、顺序不同，方法返回值和访问修饰符可以不同。

```java
StringBuilder messages = new StringBuilder();

StringBuilder todolist = new StringBuilder("To do :\n");
// 相同的名字、不同的参数，便产生了重载
// Java允许重载任何方法
```

**重写**

> 重写发生在运行期，是子类对父类的允许访问的方法的实现过程进行重新编写

1. 返回值类型、方法名、参数列表必须相同，抛出异常的范围小于等于父类，访问修饰符范围大于等于父类
2. 如果父类方法访问修饰符为 private/final/static 则子类就不能重写该方法，但是被 static 修饰的方法能够被再次声明
3. 构造方法无法被重写
   **综述**：重写就是子类对父类方法的重新改造，外部样子不能改变，内部逻辑可以改变

|   区别点   | 重载方法 |                            重写方法                            |
| :--------: | :------: | :------------------------------------------------------------: |
|  发生范围  | 同一个类 |                              子类                              |
|  参数列表  | 必须修改 |                          一定不能修改                          |
|  返回类型  |  可修改  |       子类方法返回值类型应比父类方法返回值类型更小或相等       |
|    异常    |  可修改  | 子类方法声明抛出的异常类应比父类方法声明抛出的异常类更小或相等 |
| 访问修改符 |  可修改  |              一定不能做更严格的限制(可以降低限制)              |
|  发生阶段  |  编译期  |                             运行期                             |

**方法的重写要遵循“两同两小一大”**：

- "两同"即方法名相同、形参列表相同；
- "两小"指的是子类方法返回值类型应该比父类方法返回值类型更小或相等，子类方法声明抛出的异常类应该比父类方法声明抛出的异常类更小或相等；
- "一大"指的是子类方法的访问权限应比父类方法的访问权限更大或相等。

**重写的返回值**

- 如果方法的返回值是 void 和基本数据类型，则返回值重写时不可修改，但是如果方法的返回值是引用类型，重写时是可以返回该引用类型的子类的。

```java
public class Hero {
    public String name() {
        return "超级英雄";
    }
}

public class SuperMan extends Hero {
    @Override
    public String name() {
        return "超人";
    }
    public Hero hero() {
        return new Hero();
    }
}

public class SuperSuperMan extends SuperMan {
    public String name() {
        return "超级超级英雄";
    }

    @Override
    public SuperMan hero() {
        return new SuperMan();
    }
}
```

# Java 面向对象编程三大特性：封装 继承 多态

## 封装

封装把一个对象的属性私有化，同时提供一些可以被外界访问的属性的方法，如果属性不想被外界访问，我们大可不必提供方法给外界访问。但是如果一个类没有提供给外界访问的方法，那么这个类也没有什么意义了。

## 继承

继承是使用已存在的类的定义作为基础建立新类的技术，新类的定义可以增加新的数据或新的功能，也可以用父类的功能，但不能选择性地继承父类。通过使用继承我们能够非常方便地复用以前的代码。

**关于继承如下 3 点请记住**

1. 子类拥有父类对象所有的属性和方法(包括私有属性和私有方法)，但是父类中的私有属性和方法子类是无法访问，**只是拥有**
2. 子类可以拥有自己属性和方法，即子类可以对父类进行扩展
3. 子类可以用自己的方式实现父类的方法

## 多态

所谓多态就是指程序中定义的引用变量所指向的具体类型和通过该引用变量发出的方法调用在编程时并不确定，而是在程序运行期间才确定，即一个引用变量到底会指向哪个类的实例对象，该引用变量发出的方法调用到底是哪个类中实现的方法，必须在由程序运行期间才能决定。

在 Java 中有两种形式可以实现多态：继承(多个子类对同一方法的重写)和接口(实现接口并覆盖接口中同一方法)。

# String StringBuffer 和 StringBuilder 的区别是什么? String 为什么是不可变的?

## 可变性

简单的来说：String 类中使用 final 关键字修饰字符数组来保存字符串，private final char value[]，所以说 String 对象时不可变的

> 在 Java9 之后，String 类的实现改用 byte 数组来存储字符串 private final byte[] value
> 而 StringBuilder 与 StringBuffer 都继承自 AbstractStringBuilder 类，在 AbstractStringBuilder 中也是使用字符数组保存字符串 char[] value 但是没有用 final 关键字修饰， 所以这两种对象都可变的。

StringBuilder 与 StringBuffer 的构造方法都是调用父类构造方法也就是 AbstractStringBuilder 实现的。

## 线程安全性

String 中的对象是不可变的，也就可以理解为常量，线程安全。AbstractStringBuilder 是 StringBuilder 与 StringBuffer 的公共父类，定义了一些字符串的基本操作，如 expandCapacity、 append、 insert、 indexOf 等公共方法。StringBuffer 对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。StringBuilder 并没有对方法进行加同步锁，所以是非线程安全的。

## 性能

每次对 String 类型进行改变的时候，都会产生一个新的 String 对象，然后将指针指向新的 String 对象。StringBuffer 每次都会对 StringBuffer 对象本身进行操作，而不是生成新的对象并改变对象 引用。相同情况下使用 StringBuilder 相比使用 StringBuffer 仅能获得 10%~15% 左右的性能提升，但却要冒多线程不安全的⻛险。

## 对于三者使用的总结

1. 操作少量数据：适用 String
2. 单线程操作字符串缓冲区下操作大量数据：适用 StringBuilder
3. 多线程操作字符串缓冲区下操作大量数据：适用 StringBuffer

# 自动装箱与拆箱

- 装箱：将基本类型用它们对应的引用类型包装起来
- 拆箱：将包装类型转换为基本数据类型

## 例题

```java
public class Main {
    public static void main(String[] args) {

        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1==i2); //true
        System.out.println(i3==i4); //false
    }
}
```

- Integer 中有 valueOf 方法，在通过 valueOf 方法创建 Integer 对象的时候，如果数值在[-128,127]之间，便返回指向 IntegerCache.cache 中已经存在的对象的引用；否则创建一个新的 Integer 对象。

# 在一个静态方法内调用一个非静态成员为什么是非法的？

- 由于静态方法可以不通过对象进行调用，因此在静态方法里，不能调用其他非静态的变量，也不可以访问非静态变量成员

# 在 Java 中定义一个不做事且没有参数的构造方法的作用

- Java 程序在执行子类的构造方法之前，如果没有用 super() 来调用父类特定的构造方法，则会调用父类中“没有参数的构造方法”。因此，如果父类中只定 义了有参数的构造方法，而在子类的构造方法中又没有用 super() 来调用父类 中特定的构造方法，则编译时将发生错误，因为 Java 程序在父类中找不到没 有参数的构造方法可供执行。解决办法是在父类里加上一个不做事且没有参数的构造方法。

# 接口和抽象类的区别是什么？

1. 接口的方法默认是 public，所有方法接口中不能有实现(JAVA8 开始接口方法可以有默认实现)，而抽象类可以有非抽象的方法
2. 接口种除了 static、final 变量，不能有其他的变量，抽象类则不一定
3. 一个类可以实现多个接口，但只能实现一个抽象类。接口自己本身可以通过 extends 关键字扩展多个接口
4. 接口方法默认修饰符是 public，抽象方法可以有 public、protected 和 default 这些修饰符
5. 从设计层面来说，抽象是对类的抽象，是一种模板设计，接口是对行为的抽象，是一种行为的规范

# 成员变量与局部变量的区别有哪些？

1. 从语法形式上看：成员变量是属于类的，而局部变量实在方法中定义的变量或是方法的参数；成员变量可以被 public，private，static 等修饰符所修饰，而局部变量不能被访问控制修饰符以及 static 所修饰；但是，成员变量和局部变量都能被 final 所修饰。
2. 从变量在内存中的存储方式来看；如果成员变量是使用 static 修饰的，那么这个成员变量是属于类的，如果没有使用 static 修饰，这个成员变量是属于实例的。对象存于堆内存，如果局部变量类型为基本数据类型，那么存储在栈内存，如果为引用数据类型，那存放的是指向堆内存对象的引用或者是指向常量池中的地址。
3. 从变量在内存中生存时间上看：成员变量是对象的一部分，它随着对象的创建而存在，而局部变量随着方法的调用而自动消失。
4. 成员变量如果没有被赋予初值，则会自动以类型的默认值而赋值(一种情况例外：final 修饰符修饰的成员变量也必须显式地赋值)，而局部变量则不会自动赋值。

**Java 的八种基本数据类型**
| 序号  |    数据类型     | 位数  | 默认值 |    取值范围    |    举例说明     |
| :---: | :-------------: | :---: | :----: | :------------: | :-------------: |
|   1   |    byte(位)     |   8   |   0    |  -2^7 - 2^7-1  |   byte b=10;    |
|   2   |  short(短整数)  |  16   |   0    | -2^15 - 2^15-1 |   short s=10;   |
|   3   |    int(整数)    |  32   |   0    | -2^31 - 2^31-1 |    int i=10;    |
|   4   |  long(长整数)   |  64   |   0    | -2^63 - 2^63-1 |   long l=10L;   |
|   5   |  float(单精度)  |  32   |  0.0   | -2^31 - 2^31-1 | float f=10.0f;  |
|   6   | double(双精度)  |  64   |  0.0   | -2^63 - 2^63-1 | double d=10.0d; |
|   7   |   char(字符)    |  16   |  NULL  |   0 - 2^16-1   |   char c='c';   |
|   8   | boolean(布尔值) |   8   | FALSE  |   TRUE,FALSE   | boolean b=true; |

# 创建一个对象用什么运算符？对象实体与对象引用有何不同？
new运算符，new创建对象实例(对象实例在堆内存中)，对象引用指向对象实例(对象引用存放在栈内存中)。一个对象引用可以指向0个或1个对象(一根绳子可以不系气球，也可以系一个)；一个对象可以有n个引用指向他(可以有n根绳子指向一个气球)

# 什么是方法的返回值？返回值在类的方法里的作用是什么？
方法的返回值是指我们获取到某个方法体中的代码执行后产生的结果。返回值的作用是接收结果，使其可以用于其他的操作。

# 一个类的构造方法的作用是什么？若一个类没有声明构造方法，该程序能正确执行吗？为什么？
主要作用是完成对类对象的初始化工作。可以执行。因为一个类即使没有声明构造方法也会有默认不带参数的构造方法

# 构造方法有哪些特征？
1. 名字和类名相同
2. 没有返回值，但不能用void声明构造函数
3. 生成类的对象时自动执行，无需调用

# 静态方法和实例方法有何不同？
1. 在外部调用静态方法时，可以使用"类名.方法名"的方式，也可以使用"对象名.方法名"的方式。而实例方法只有后面这种方式，也就是说调用静态方法可以不创建对象
2. 静态方法在访问本类的成员时，只允许访问静态成员，而不允许访问实例成员和实例方法，实例方法无此限制。

# 对象的相等与指向他们的引用相等，两者有什么不同？
对象的相等，比的是内存中存放的内容是否相等。而引用相等，比较的是他们指向的内存地址是否相等。

# 在调用子类构造方法前会先调用父类没有参数的构造方法，其目的是？
帮助子类做初始化工作

# <font color="#feccfe"> == 与 equals </font>
**==** 它的作用是用来判断两个对象的地址是不是相等。即，判断两个对象是不是同一个对象(基本数据类型的==比较的是值，引用数据类型==比较的是内存地址)
**equals()** 它的作用也是判断两个对象是否相等，一般有两种情况：
* 情况1：类没有覆盖equals()方法。则通过equals()比较该类的两个对象时，等价于通过==比较这两个对象
* 情况2：类覆盖了equals()方法。一般，我们都覆盖equals()方法来比较两个对象的内容是否相同；若它们的内容相等，则返回true(即，认为这两个对象相等)
``` java
public class test1 {
    public static void main(String[] args) {
        String a = new String("ab");
        String b = new String("ab");
        String aa = "ab";
        String bb = "ab";
        System.out.println(aa == bb);//true
        System.out.println(a == b);//false
        System.out.println(a.equals(b));//true
        System.out.println(aa.equals(bb)); //true
        System.out.println(42 == 42.0); //true
    }
}
```
**说明**
* String中的equals()方法被重写过，应为object的equals方法是比较对象的内存地址，而String的equals方法比较的是对象的值
* 当创建String类型的对象时，虚拟机会在常量池中查找有没有已经存在的值和要创建的值相同的对象，如果有就把它赋给当前引用。如果没有就在常量池中重新创建一个String对象

# <font color="#feccfe"> hashCode 与 equals </font>

1. hashCode()介绍：
   hashCode是获取哈希码（散列码），返回值为一个int整数。这个哈希码的作用是确定对象在哈希表中的索引位置。hashCode()定义在JDK的Object类中，这就意味着Java中的任何类都包含有hashCode()函数。hashCode是一个native方法，使用c和c++实现
   哈希表存储的是键值对(key-value)，能根据“键”快速的检索出对于的“值”
2. 为什么要使用hashCode()?
   以HashSet为例：
   当把对象加入HashSet是，HashSet会先计算对象的hashCode来判断对象加入的位置，同时也会与其他已经加入的对象的hashCode进行比较，如果没有相符的hashCode，HashSet回家社对象没有重复出现，如果发现相同的hashCode会调用equals()方法，检查对象是否真的1相同，如果相同，就不会让其加入，如果不同就会散列到其他的位置。减少了equals的次数，提高了执行速度。
> Java的Collection接口被List和Set接口继承，List元素可以重复且有序，Set元素不可以重复且无序
3. 为什么重写equals()方法时必须重写hashCode()方法？
   如果两个对象相等，则hashCode一定是相同的，两个对象相等，对两个对象分别调用equals()方法都返回true。但是两个对象有相同的hashCode值，，两个对象也不一定相等，因此，equals方法被覆盖过，则hashCode方法也要被覆盖。
> hashCode()的默认行为是对堆上的对象产生独特之，如果没有重写hashCode(),则类的两个对象无论如何都不会相等
4. 为什么两个对象有相同的hashcode值也不一定是相等的？
   因为hashCode()所用的杂凑算法也许刚好会让多个对象传回相同的杂凑值。越早搞得杂凑算法越容易碰撞，但这也与数据值域分布的特性有关(所谓碰撞也就是指的是不同的对象得到相同的hashCode)
> 杂凑(hash)
``` java
import org.junit.Test;

public class HashCodeTest {

    /**
     * 测试hashCode相同的对象是否完全相同
     * String重写了equals方法
     */
    @Test
    public void test1() {
        String a = "ab";
        String b = "ab";
        String c = a;
        String d = new String("ab");
        System.out.println(a == b);
        System.out.println(a == c);

        System.out.println(a == d);
        System.out.println(a.equals(d));

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(c.hashCode());
        System.out.println(d.hashCode());

        /*
        * true
        * true
        * false
        * true
        * 3105
        * 3105
        * 3105
        * 3105
        * */
    }
    /**
     * 测试hashCode相同的对象是否完全相同
     * Long也重写了equals
     */
    @Test
    public void test2() {
        Long a = new Long(111_111_111_111_111_111L);
        Long b = new Long(111_111_111_111_111_111L);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a==b);
        System.out.println(a.equals(b));
        /*
        * -2048209104
        * -2048209104
        * false
        * true
        * */

    }
}


```


# 为什么java中只有值传递？
按值调用(call by value)表示方法接收的调用者提供的值，而按引用调用(call by reference)表示方法接收的是调用者提供的变量地址。一个方法可以修改传递引用所对应的变量值，而不能修改传递值调用锁对应的变量值，而不能修改传递值调用所对应的变量值。
Java程序设计语言总是采用**按值调用**，也就是说得到的是所有参数值得一个拷贝，方法不能修改传递给它的任何参数变量的内容。  
``` java
package makotogu;

/**
 * 在swap方法中，a,b的值进行交换，并不会影响num1、num2。因为a，b中的值是从num1、num2中复制的，a、b再怎么变也不会影响原始的
 * 一个方法不能修改一个基本数据类型的参数
 */
public class CallByValueTest1 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        swap(num1, num2);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }

    public static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
}
```
```java
package makotogu;

/**
 * array 被初始化arr的拷贝也就是一个对象的引用，也就是说array和arr指向的是同一个数组对象。
 * 因此，外部对引用对象的改变会反映到所对应的对象上
 */
public class CallByValueTest2 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);
    }

    public static void change(int[] array) {
        array[0] = 0;
    }
}

```
``` java
package makotogu;

/**
 * 方法没有改变存储在s1和s2中的对象引用，swap方法的参数x和y被初始化成为两个对象引用的拷贝，这个方法交换的是这个两个拷贝
 */
public class CallByValueTest3 {
    public static void main(String[] args) {
        Student s1 = new Student("小张");
        Student s2 = new Student("小李");
        swap(s1,s2);
        System.out.println("s1"+s1.getName());
        System.out.println("s2"+s2.getName());
    }

    public static void swap(Student x, Student y) {
        Student temp = x;
        x = y;
        y = temp;
        System.out.println("x:"+x.getName());
        System.out.println("y:"+y.getName());
    }
}
```
**总结**
Java程序设计语言对对象采用的不是引用调用，实际上，对象引用是按值传递的。
Java中方法参数的使用情况：
* 一个方法不能修改一个基本数据类型的参数(既数值型或布尔型)
* 一个方法可以改变一个对象参数的状态
* 一个方法不能让对象参数引用一个新的对象

# 简述线程、程序、进程的基本概念
**线程**与进程相似，但线程是个比进程更小的执行单位。一个进程在其执行的过程中可以产生多个线程。与进程不同的是同类的多个线程共享同一块内存空间和一组系统资源，所以系统在产生一个线程，或是在各个线程之间切换工作时，负担要比进程小很多，也正是如此，线程也被成为轻量级进程。
**程序**是含有指令和数据的文件，被存储在磁盘或其他的数据存储设备中，也就是说程序是静态的代码。
**进程**是程序的一次执行过程，是系统运行程序的基本单位，因此进程是动态的。系统运行一个程序即是一个进程从创建，运行到消亡的过程。简单来说，一个进程就是一个执行中的程序，它在计算机中一个指令接着一个指令地执行着，同时，每个进程还占有某些系统资源如CPU时间，内存空间，文件，输入输出设备地使用权等。换句话说，当程序在执行时，将会被操作系统载入内存中。

# 线程有哪些基本状态？
Java线程在运行地生命周期中地指定时刻只可能处于下面6中不同状态的一个状态
|   状态名称   |                                                 说明                                                 |
| :----------: | :--------------------------------------------------------------------------------------------------: |
|     NEW      |                           初始状态，线程被构建，但是还没有调用start()方法                            |
|   RUNNABLE   |                 运行状态，Java线程将操作系统中地就绪和运行两种状态笼统地称作“运行中”                 |
|   BLOCKED    |                                      阻塞状态，表示线程阻塞于锁                                      |
|   WAITING    | 等待状态，表示线程进入等待状态，进入该状态表示当前线程需要等待其他线程做出一些特定地动作(通知或中断) |
| TIME_WAITING |                   超时等待状态，该状态不同于WAITING,它是可以在指定地时间自行返回的                   |
|  TERMINATED  |                                  终止状态，表示当前线程已经执行完毕                                  |

线程在生命周期中并不是固定处于某个状态，而是随着代码的执行在不同状态之间切换。

线程创建后处于NEW（新建）状态，调用start()方法后开始优行，线程这时候处于READY(可运行)状态。可运行状态的线程获得了cpu时间片(timeslice)后就处于RUNNING(运行)状态。当线程执行wait()方法后，线程进入WAITING(等待)状态。进入等待状态的线程需要依靠其他线程的通知才能够返回到运行状态，而TIMED_WAITING(超时等待)状态相当于在等待状态上增加了超时限制，比如通过sleep(long millis)方法或wait(long millis)方法可以将Java线程置于TIMED_WAITING状态。当超时时间到达后Java线程将会返回到RUNNABLE状态。当线程调用同步方法时，在没有获取到锁的情况下，线程会进入到BLOCKED(阻塞)状态。线程在执行RUNNABLE的run()方法后会进入到TERMINATED(终止)状态。

# 关于final关键字的总结
final主要用于三个地方：变量、方法、类
1. 一个final变量，如果是基本数据类型的变量，数值一旦初始化就不能更改，如果是引用类型的变量，则在对其初始化后便不能再让其指向另一个对象。
2. 当用final修饰一个类时，表明这个类不能被继承。final类中的所有成员方法都会被隐式地修改为final方法
3. 使用final方法的原因有两个，第一个原因是把方法锁定，以防任何继承类修改它的含义。第二个是因为效率。在早期的Java实现版本中，会将final方法转为内嵌调用。但是如果方法过于庞大，可能看不到内嵌调用带来的任何性能提升。（现在不用final优化了）。类中所有的private方法都隐式地指定为final

# Java异常处理
## Java中异常类层次
在Java中，所有异常都有一个共同的祖先java.lang包中的Throwable类。Throwable类有两个重要的子类Exception(异常)和Error(错误)。Exception能被程序本身处理(try...ctach...)，Error是无法处理的。
Exception和Error二者都是Java异常处理的重要子类，各自都包含大量子类。
* Exception：程序自身可以处理的异常，通过catch来捕获，Exception又可以分为受检查异常(必须处理)和不受检查异常(可以不处理)
* Error：Error属于程序无法处理的错误，我们没办法通过catch来捕获。如：VertualMachineError、OutOfMemoryError、NoClassDefFoundError等
**受检查异常**
在编译过程中，如果受检查异常没有被catch/throw处理，就没有办法通过编译
除了RunntimeException及其子类外，其他的Exception类及其子类都属于检查异常，常见的有IO相关，ClassNotFoundException、SQLException..
**不受检查异常**
Java代码在编译过程中，我们即使不处理不受检查异常也可以正常通过编译
RuntimeException及其子类都统称为非受检查异常，例如：NullPointException等
## Throwable类常用方法
* public string getMessage(): 返回异常发生时的简要描述
* public string toString(): 返回异常发生时的详细信息
* public string getLocalizedMessage(): 返回异常对象的本地化信息。使用Throwable的子类覆盖这个方法，可以生成本地化信息。如果子类没有覆盖该方法，则该方法返回的信息与getMessage()返回的结果相同
* public void printStackTrace(): 在控制台上打印Throwable对象封装的异常信息
## 异常处理总结
* try块：用于捕获异常。其后可接0个或多个catch块，如果没有catch块，则必须更一个finally块
* catch块：用于处理try捕获的异常
* finally块：无论是否捕获或处理异常，finally块理得语句都会执行。当在try块或catch块中遇到return语句时，finally语句块将在方法返回之前被执行。
**以下三种情况，finally块不会被执行**
1. 在try或finally块中用了System.exit(int)退出程序。但是如果System.exit(int)在异常语句之后，finally还是会被执行
2. 程序所在线程死亡
3. 关闭cpu

## Java序列化中如果有些字段不想进行序列化，怎么办？
对于不想进行序列化的变量，使用transient关键字修饰。
transient关键字的作用：阻止实例中那些用此关键字修饰的变量序列化；当对象被反序列化时，被transient修饰的变量值不会被持久化和恢复。transient只能修饰变量，不能修饰类和方法。

## 获取用键盘输入常用的两种方法
1. 通过Scanner
``` java
Scanner input = new Scanner(System.in);
String s = input.nextLine();
input.close();
```
2. 通过BufferedReader
``` java
BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
String s = input.readline();
```

# Java中IO流
## java中的IO流分为集中
* 按照流的流向分，可以分为输入流和输出流；
* 按照操作单元划分，可以划分为字节流和字符流；
* 按照留的角色划分为节点流和处理流。
Java IO流共涉及40多个类，这些类看上去很杂乱，但实则上很有规则，而且彼此之间存在非常紧密的联系，JavaIO流的40多个类都是从如下4个抽象类基类中派生出来的。
* InputStream/Reader：所有的输入流的基类，前者是字节输入流，后者是字符输入流。
* OutputStream/Writer：所有输出流的基类，前者是字节输出流，后者是字符输出流。
## 既然有了字节流，为什么还要有字符流？
问题本质问：不管是文件读写还是网络发生接收，信息的最小存储单元都是字节，那为什么I/O流要分为字节流和字符流操作呢？
回答： 字符流是Java虚拟机将字节转换得到的，问题就出在这个过程还算是非常耗时，并且，如果我们不知道编码类型就很容易出现乱码问题。所以，I/O流就干脆提供了一个直接操作字符的接口，方便我们平时对字符进行流操作。如果音频文件、图片等媒体文件用字节流比较好，如果涉及字符的话使用字符流比较好。
## BIO,NIO,AIO有什么区别？
* BIO(Blocking I/O)：同步阻塞I/O模式，数据的读取写入必须阻塞在一个线程内等待其完成。在活动连接数不是特别高(小于单机1000)的情况下，这种模型是比较不错的，可以让每个连接专注自己的I/O并且编程模型简单，也不用过多考虑系统的过载、限流等问题。线程池本身就是一个天然的漏斗，可以缓冲一些系统处理不了的连接或请求。但是，当面对十万甚至百万级连接的时候，传统BIO模型是无能为力。因此，我们需要一种更高效的I/O处理模型来应对更高的并发量。
* NIO(Non-blocking/New I/O): NIO是一种同步非阻塞的I/O模型，在Java1.4中引入了NIO框架，对应java.nio包，提供了Channel,Selector,Buffer等抽象。NIO中的N可以理解为Non-blocking，不单纯是New。他支持面向缓冲的，基于通道的I/O操作方法。NIO提供了与传统BIO模型中的Socket和ServerSocket相对应的SocketChannel和ServerSocketChannel两种不同的套接字通道实现，两种通道都支持阻塞和非阻塞两种模式。阻塞模式使用就像传统中的支持一样，比较简单，但是性能和可靠性都不好；非阻塞模式正好与之相反。对于低负载，低并发的应用程序，可以使用同步阻塞I/O来提升开发速率和更好的维护性；对于高负载、高并发的（网络）应用，应使用NIO的非阻塞模式来开发。
* AIO(Asynchronous I/O):AIO也就是NIO 2。在Java 7 中引入NIO的改进版NIO2，它是异步非阻塞的IO模型。异步IO是基于时间和回调机制实现的，也就是应用操作之后会直接返回，不会堵塞在那里，当后台处理完成，操作系统会通知相应的线程进行后续的操作。AIO是异步IO的缩写，虽然NIO在网络中，提供了非阻塞的方法，但是NIO的IO行为还是同步的，对于NIO来说，我们的业务线程实在IO操作准备好时得到通知，接着就由这个线程自行进行IO操作，IO操作本身是同步的。Netty尝试使用过AIO然后放弃了。

# 深拷贝 VS 浅拷贝
1. 浅拷贝： 对基本数据类型进行值传递，对应用数据类型进行引用传递般的拷贝，此为浅拷贝
2. 深拷贝： 对基本数据类型进行值传递，对引用数据类型，创建一个新的对象，并复制其内容，此为深拷贝