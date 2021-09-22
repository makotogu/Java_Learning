# 什么是JVM?

## 定义
Java Virtual Machine -java程序的运行环境(java 二进制字节码的运行环境)
## 好处
* 一次编写，到处运行
* 自动内存管理，垃圾回收功能
* 数组下标越界，越界检查
* 多态

## 学习JVM有什么作用
* 面试
* 理解底层的实现原理
* 中高级程序员的必备技能

# 内存结构
## 程序计数器
### 定义
Program Counter Register 程序计数器
### 作用
记住下一条jvm指令的执行地址
### 特点
* 线程私有
* 不存在内存溢出

## 虚拟机栈
### 定义
* Java Virtual Machine Stacks
* 每个线程运行时需要的内存，称为虚拟机栈
* 每个栈由多个栈帧(Frame)组成，对应着每次方法调用时所占用的内存
  * 栈帧：每个方法运行所需要内存 
* 每个线程只能有一个活动栈帧，对应着当前正在执行的那个方法
### 问题辨析
1. 垃圾回收是否涉及栈内存？
* 不会，栈帧由一次次方法调用产生，每次方法结束会被自动弹出栈，不需要进行垃圾回收
2. 栈内存的分配越大越好吗？
* 运行代码时通过 -Xss size去设置栈内存大小 不指定默认1024KB
* 栈内存越大会导致线程数量变少
3. 方法内的局部变量是否线程安全？
* 静态变量，对线程相当于共享的，就要考虑线程安全
* 如果是每个线程私有的，就不用考虑线程安全
* 如果方法内局部变量没有逃离方法的作用访问，它是线程安全的
* 如果时局部变量引用了对象，并逃离方法的作用范围，需要考虑线程安全问题
### 栈内存溢出
* 栈帧过多导致栈内存溢出
* 栈帧过大导致栈内存溢出
### 线程运行诊断
* 案例1：cpu占用过多
  * 定位： 
    * 用top定位哪个进程对cpu占用过高
    * ps H -eo pid,tid,%cpu|grep 进程id(用ps命令进一步定位是哪个线程引起的cpu占用过高)
    * jstack 进程id
      * 根据线程id找到有问题的线程，进一步定位到问题代码的源码行号
* 案例2：程序运行很长时间没有结果

## 本地方法栈
native方法是由c或c++编写，java对其调用，方法存在本地方法栈中

## 堆
### 定义
Heap 堆
* 通过new关键字，创建对象都会使用堆内存
特点
* 它是线程共享的，堆中对象都需要考虑线程安全的问题
* 有垃圾回收机制
### 堆内存溢出
* -Xmx8m 设置堆内存空间最大值
### 堆内存诊断
1. jps 工具
   * 查看当前系统中有哪些java进程
2. jmap 工具
   * 查看堆内存占用情况
   * jmap -heap 进程id
3. jconsole 工具
   * 图形界面的，多功能的监测工具，可以连续监测
* 案例
* 垃圾回收后，内存占用仍然很高

## 方法区
### 定义
* JVM规范对方法区的定义：
 * 方法区是所有Java虚拟机线程共享的区
 * 存储了与类的结构的信息（类的field，method data， 成员方法和构造器方法的代码部分
 * 方法区在虚拟机启动的时候被创建
 * 方法区如果申请内存发现内存不足，也会抛出OutOfMemoryError
### 方法区内存溢出
* 1.8 以前会导致永久代内存溢出
* 1.8 以后会导致元空间内存溢出
### 运行时常量池
* 常量池，就是一张表，虚拟机指令根据这张常量表找到要执行的类名、方法名、参数类型、字面量等信息
* 运行时常量池，常量池*.class文件中的，当该类被夹在，他的常量池信息就会放入运行时常量池，并把里面的符号地址变为真实地址
### StringTable
``` java
import org.junit.Test;

public class StringTableTest {
    //常量池中的信息，都会被加载到运行时常量池中， 这是 a,b,ab都是常量池中的符号，还没有变为java中的字符串对象
    // ldc #2 会把a符号变成"a"字符串对象
    // ldc #3 会把b符号变成"b"字符串对象

    @Test
    public void test1(){
        String s1 = "a"; //懒汉行为，用到了才会创建
        String s2 = "b";
        String s3 = "a"+"b";
        String s4 = s1 + s2;
        String s5 = "ab";
        String s6 = s4.intern();

        // Q
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);

        String x2 = new String("c")+new String("d");
        String x1 = "cd";
        x2.intern();

        // Q 如果调换了最后两行代码的位置，如果是jdk1.6呢？
        System.out.println(x1 == x2);
    }
}
```
### StringTable特性
* 常量池种的字符串仅仅是符号，第一次用到才会变为对象
* 利用串池的机制，来避免重复创建字符串对象
* 字符串变量拼接的原理是StringBuilder(jdk1.8)
* 字符串常量拼接的原理是编译期优化
* 可以使用intern方法，主动将串池中还没有的字符串对象放入串池
  * 1.8将这个字符串对象尝试放入串池，如果有则并不会放入，如果没有则会放入串池，会把串池中的对象返回
  * 1.6把这个字符串对象尝试放入串池，如果有则不会放入，如果没有会把此对象复制一份，放入串池，并把串池中的对象返回
### StringTable位置
### StringTable 垃圾回收
-Xmx10m -XX:+PrintStringTableSTATISTICS -XX:PrintGCDetails -verbose:gc
### StringTable 调优
底层： 哈希表
StringTableSize 调整大小（桶大小）更好的哈希分布减少哈希冲突，提高stringtable的串池效率
考虑字符串对象是否入池 intern可以减少相同字符串对内存的占用

## 直接内存
### 定义
Direct Memory
* 常见于NIO操作时，用于数据缓冲区
* 分配回收成本高，但读写性能高
* 不收JVM内存回收管理
### 分配和回收原理
* 使用了Unsafe对象完成直接内存的分配回收，并且需要主动调用freeMemory方法
* ByteBuffer的实现类内部，使用了Cleaner（虚引用）来检测ByteBuffer对象，一旦ByteBuffer对象被垃圾回收，那么就会有ReferenceHandler线程通过Cleaner的clean方法调用freeMemory来释放内存


# 垃圾回收
## 如何判断一个对象可以被回收
1. 引用计数法
   * 两个对象互相引用会造成内存泄漏 java没有采用
2. 可达性分析算法
   * java虚拟机中的垃圾回收器采用可达性分析来探索所有存活的对象
   * 扫描堆中的对象，看是否能够沿着GC Root对象为起点的引用链找到该对象，找不到，表示可以回收
   * 哪些对象可以看做为GC Root？
     * 虚拟机栈（栈帧中的本地变量表）中引用的对象
     * 本地方法栈中 JNI（即一般说的 Native 方法）引用的对象
     * 方法区中类静态属性引用的对象
     * 方法区中常量引用的对象
3. 四种引用
   1. 强引用
   * 只有所有GC Roots 对象不通过强引用引用该对象，该对象才能被垃圾回收
   2. 软引用(SoftReference)： 当内存不足时会被回收掉（没有强引用引用时）
   * 仅有软引用引用该对象时，在垃圾回收后，内存忍不足时会再次出发垃圾回收，回收软引用对象
   * 可以配合引用队列来释放软引用自身
   3. 弱引用： 只要发生内存回收都会回收（没有强引用引用时）
   * 仅有弱引用引用该对象时，在垃圾回收时，无论内存足够与否都会回收弱引用对象
   * 可以配合引用队列来释放弱引用自身
   4. 虚引用： 创建一个cleaner对象，传递直接内存地址，回收byteBuffer时回到引用队列中调用cleaner去清除直接内存
   * 必须配合引用队列使用，主要配合ByteBuffer使用，被引用对象回收时，会将虚引用入队，由Reference Handler线程嗲用虚引用相关方法释放直接内存
   6. 终结器引用： 不推荐使用finallize() 要先将自己放入队列
   * 无需手动编码，但其内部配合引用队列使用，在垃圾回收时，中继器引用入队（被引用对象暂时没有被回收），再由Finalizer线程通过终结器引用找到被引用对象并调用他的finalize方法，第二发此GC时才能回收被引用对象

## 垃圾回收算法
1. 标记清除
   优点：速度快
   缺点：容易产生内存碎片
2. 标记整理
   优点：没有内存碎片
   缺点：速度较慢
3. 复制
   * 将内存区划分为两个区域，一个叫FROM，一个叫TO。从FROM复制存活到TO，完成整理，不会产生碎片，一次清空FROM，然后交换FROM和TO
   优点：不会有内存碎片 
   缺点：占用双倍的内存空间
## 分代回收
* 对象首先会分配在伊甸园区
* 新生代空间不足够会出发minor gc， 伊甸园和from存活对象使用copy存放到to中，存活对象的年龄加一，并且交换from to
* minor gc 会引发STW(stop the world),暂停其他的用户的线程，等垃圾回收结束，用户线程才恢复运行
* 当对象寿命超过阈值时，会晋升为老年代，最大寿命是15（4bit）
* 当老年代空间不够，会尝试触发minor gc，如果空间依旧不够，会出发full gc， STW的时间更长

## 相关VM参数
|        含义        |                             参数                             |
| :----------------: | :----------------------------------------------------------: |
|     堆初始大小     |                             -Xms                             |
|     堆最大大小     |                 -Xmx 或 -XX:MaxHeapSize=size                 |
|     新生代大小     |        -Xmn 或 -XX:NewSize=size + -XX:MaxNewSize=size        |
| 幸存区比例（动态） | -XX:InitialSurvivorRatio=ratio 和 -XX:+UseAdaptiveSizePolicy |
|     幸存区比例     |                   -XX:SurvivorRatio=ratio                    |
|      晋升阈值      |              -XX:MaxTenuringThreshold=threshold              |
|      晋升详情      |                -XX:+PrintTenuringDistribution                |
|       GC详情       |               -XX:+PrintGCDetails -verbose:gc                |
|  FullGC前 MinorGC  |                  -XX:+ScavengeBeforeFullGC                   |


# 垃圾回收器
1. 串行
   * 单线程
     * 对内存较小，cpu核心数少（适合个人电脑）
2. 吞吐量优先
   * 多线程
     * 堆内存大，多核cpu
   * 单位时间内STW时间尽可能短  少餐多食
3. 响应时间优先
   * 多线程
     * 堆内存较大，多核cpu
   * STW单次的时间尽可能短  少食多餐
## 串行
-XX:+UseSerialGC=Serial + SerialOld
> Serial 复制算法
> SerialOld 老年代 标记整理算法
## 吞吐量优先的垃圾回收器
-XX:+UseParallelGC~ -XX:+UseParallelOldGC  //标记加整理 开启一个会连带开启另一个
-XX:+UseAdaptiveSizePolicy //采用一个自适应的大小策略
-XX:GCTimeRatio=ratio //调整吞吐量 垃圾回收的时间和总时间的占比
-XX:MaxGCPauseMillis=ms //默认值200ms 
-XX:ParallelGCThreads=n
## 响应时间优先
-XX:+UseConcMarkSweepGC ~ -XX:+UseParNewGC ~SerialOld  //CMS垃圾回收器在某些时刻起到并发的效果 //UP是新生代的 //并发失败会使用SerialOld来补救（标记整理）
-XX:ParallelGCThreads=n ~ -XX:ConcGCThreads=threads
-XX:CMSInitiatingOccupancyyFraction=percent //控制何时进行CMS垃圾回收，执行CMS的内存占比 percen表示一个内存占比
-XX:+CMSScavengeBeforeRemark //避免重新标记之前，对新生代进行扫描，做完一次回收新生代内容少，将来扫描的对象就少，减轻重新标记的压力

# G1 
定义：Garbage First
适用场景
* 同事注重吞吐量(Throughput)和低延迟(Low latency),默认的暂停目标是200ms
* 超大堆内存，会将堆分为多个大小相等的Region
* 整体上是标记+整理算法，两个区域之间是复制算法
相关JVM参数
-XX:+UseG1GC
-XX:G1HeapRegionSize=size
-XX:MaxGCPAuseMillis=time
## G1垃圾回收阶段
1. Young Collection
2. Young Collection + Concurrent Mark
3. Mixed Collection
三步依次循环

## Young Collection

会触发STW

## Young Collection + CM

* 在Young GC时会进行GC ROOT的初始标记

* 老年代占用堆空间比例达到阈值时，进行并发标记(不会STW), 由下面的JVM参数决定

    -XX：InitiatingHeapOccupancyPercent=percent （默认45%） 

## Mixed Collection

会对E、S、O进行全面垃圾回收

*   最终标记(Remark)会STW
*   拷贝存活(Evacuation)会STW
*   -XX:MaxGCPauseMillis=ms

## Full GC

*   Serial GC
    *   新生代内存不足发生的垃圾收集-minor gc
    *   老年代内存不足发生的垃圾收集-full gc
*   Parallel GC
    *   新生代内存不足发生的垃圾收集-minor gc
    *   老年代内存不足发生的垃圾收集-full gc
*   CMS
    *   新生代内存不足发生的垃圾收集-minor gc
    *   老年代内存不足 

*   G1
    *   新生代内存不足发生的垃圾收集-minor gc
    *   老年代内存不足

## Young Collection 跨代引用

*   新生代回收的跨代引用（老年代引用新生代）问题
    *   老年代的区域细分（卡表）  每个区域（Card）512B左右
    *   如果某个区域中引用了新生代，就标记为脏Card

*   卡表与Remembered Set
*   在引用变更时通过post-write barrier + dirty card queue
*   concurrent refinement threads 更新 Remembered Set

## Remark

*   pre-write barrier + satb_mark_queue

## JDK8 字符串去重复

*   优点： 节省大量内存
*   缺点： 略微多占用了cpu时间，新生代回收时间略微增加
*   -XX:+UserStringDeduplication

``` java
String s1 = new String("hello"); // char[] {'h','e','l','l','o'}
String s2 = new String("hello"); // char[] {'h','e','l','l','o'}
```

*   将所有新分配的字符串放入一个队列
*   当新生代回收时，G1并发检查是否有字符串重复
*   如果它们值一样，让它们引用同一个char[]
*   注意，与String.intern() 不一样
    *   String.intern() 关注的是字符串对象
    *   字符串去重关注的是char[]
    *   在JVM内部，使用了不同的字符串表

## JDK 8u40 并发标记类卸载

所有对象都经过并发标记后，就能知道哪些类不再被使用，当一个类加载器的所有类都不再使用，则卸载它所加载的所有类

-XX:+ClassUnloadingWithConcurrentMark 默认启用

## JDK 8u60 回收巨型对象

*   一个对象大于region的一半时，称之为巨型对象
*   G1不会对巨型对象进行拷贝
*   回收时会被优先考虑
*   G1 会跟踪老年代所有incoming引用，这样老年代incoming引用为0的巨型对象就可以在新生代垃圾回收时处理掉

## JDK 9 并发标记起始时间的调整

*   并发标记必须在堆空间占满前完成，否则退化为FullGC
*   JDK9之前需要使用-XX:InitialingHeapOccupancyPercent
*   JDK9可以动态调整
    *   -XX:InitiatingHeapOccupancyPercent 用来设置初始值
    *   进行数据采样并动态调整
    *   总会添加一个安全的空档空间

# 垃圾回收调优

预备知识

*   掌握GC相关的VM参数，会基本的空间调整
*   掌握相关工具
*   调优跟应用、环境有关、没有放之四海而皆准的法则
