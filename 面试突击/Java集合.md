# 说说List，Set，Map三者的区别
* List(对付顺序的好帮手)：存储的元素是有序的、可重复的
* Set(注重独一无二的性质)：存储的元素是无序的、不可重复的
* Map(用key搜索的专家)：使用键值对存储元素。key是无序的、不可重复的，value是无序的、可重复的，每个键最多映射到一个值

# ArrayList和LinkedList的区别   
1. 是否线程安全： 两者都不安全
2. 底层数据结构： ArrayList底层用的是Object数组；LinkedList用的是双向链表 (JDk1.6之前为双向循环链表)
3. 插入和删除是否首元素位置影响？
   1. ArrayList：采用数组存储，所以插入和删除元素的时间复杂度受元素位置的影响。
      * 如 add(E e) 默认插入尾部，只要O(1)，但如果要在指定位置插入或删除add(int index, E element)复杂度就为O(n-1)，因为需要进行移位操作
   2. LinkedList： 采用链表存储，如果对于add(E e)方法的插入、删除元素时间不收元素位置的影响，近似于O(1)，但如果在指定位置添加由于涉及到移动到指定位置，所以为O(n)
4. 是否支持快速随机访问：LinkedList不支持 ArrayList支持 (对应于get(int index))方法
5. 内存空间占用：ArryaList的空间浪费主要体现在在list列表的结尾会预留一定的容量空间，而LinkedList的空间花费则特显在它的每一个元素都要消耗比ArrayList更多的空间(要存放前驱后继还有数据)

# 双向链表和循环双向链表
**双向链表**：包含两个指针，一个prev指向前一个节点，一个next指向后一个节点
**双向循环节点**：在双向链表的情况下，head指针的prev指向最后一个节点，最后一个节点的next指向head

# RandomAccess接口
``` java
public interface RandomAccess {
}
```
Marker interface used by List implementations to indicate that they support fast (generally constant time) random access. 
也就是一个标识这个方法支持快速随机访问得一个接口。实现这个接口与能够快速随机访问关系不大

# ArrayList和Vector区别？为什么要用ArrayList取代Vector呢？
* ArrayList是List的主要实现类，底层使用Object[]存储，适合用于频繁的查找工作，线程不安全
* Vector是List的古老实现类，底层使用Object[]存储，线程安全

# HashMap和HashTable的区别
1. **线程是否安全**：HashMap是非线程安全的，HashTable是线程安全的(但是不建议用HashTable了，要线程安全可以用ConcurrentHashMap)
2. **效率**：因为线程安全的问题，HashMao要比HashTable要快些。   
3. **对 Null key 和 Null value 的支持**: HashMap 可以存储 null 的 key 和 value，但 null 作为键只能有一个，null 作为值可以有多个;HashTable 不允许有 null 键和 null 值，否则会抛出 NullPointerException 。
4. **初始容量大小和每次扩充容量大小的不同**:
   1. 创建时如果不指定容量初始值， Hashtable 默认的初始大小为 11，之后每次扩充，容量变为原来的 2n+1。 HashMap 默认的初始化大 小为 16。之后每次扩充，容量变为原来的 2 倍。
   2. 创建时如果给定了容量初始值，那么 Hashtable 会直接使用你给定的大小，而 HashMap 会将其扩充为 2 的幂次方大小( HashMap 中的 tableSizeFor() 方法保证，下面给出了源代码)。
5. **底层数据结构**:
   * JDK1.8 以后的 HashMap 在解决哈希冲突时有了􏰀大的变化，当链表⻓度大于阈值(默认为 8)(将链表转换成红黑树前会判断，如果当前数组的⻓度小于 64，那么 会选择先进行数组扩容，而不是转换为红黑树)时，将链表转化为红黑树，以减少搜索时 间。Hashtable 没有这样的机制。
>HashMap扩容机制源码
``` java
/**
* Returns a power of two size for the given target capacity.
*/
static final int tableSizeFor(int cap) {
   int n = cap - 1;
   n |= n >>> 1;
   n |= n >>> 2;
   n |= n >>> 4;
   n |= n >>> 8;
   n |= n >>> 16;
   return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
}
```

# HashMap 和 HashSet的区别
HashSet 底层就是基于 HashMap 实现的。( HashSet 的源码非常非常少，因为除了 clone() 、 writeObject() 、 readObject() 是 HashSet 自己不得不实现之外，其他方法都是直接调用 HashMap 中的方法。)
|            HashMap             |                                                  HashSet                                                  |
| :----------------------------: | :-------------------------------------------------------------------------------------------------------: |
|         实现了Map接口          |                                               实现了Set接口                                               |
|           存储键值对           |                                                仅存储对象                                                 |
|    调用put()向map中添加元素    |                                       调用add()方法向Set中添加元素                                        |
| HashMap使用键(key)计算hashCode | HashSet使用成员对象来计算hashCode值，对于两个对象来说hashCode可能相同，所以用equals()方法来判断对象的相等 |

# HashSet如何检查重复
当你把对象加入 HashSet 时， HashSet 会先计算对象的 hashcode 值来判断对象加入的位置，同 时也会与其他加入的对象的 hashcode 值作比􏰀，如果没有相符的 hashcode ， HashSet 会假设 对象没有重复出现。但是如果发现有相同 hashcode 值的对象，这时会调用 equals() 方法来检查hashcode 相等的对象是否真的相同。如果两者相同， HashSet 就不会让加入操作成功。
## hashCode() 与 equals() 的相关规定
1. 如果两个对象相等，则hashcode一定也是相同的
2. 两个对象相等，对两个equals()方法返回true
3. 两个对象有相等的hashcode值，它们也不一定是相等的
4. 综上，equals()方法被覆盖过，则hashCode()方法也必须被覆盖
5. hashCode()的默认行为是对堆上的对象产生独特值。如果没有重写hashCode()，则该class的两个对象无论如何都不会相等。

# HashMap的底层实现
## JDK1.8之前
JDK1.8 之前 HashMap 底层是数组和链表结合在一起使用也就是链表散列。HashMap 通过 key 的 hashCode 经过扰动函数处理过后得到 hash 值，然后通过 (n - 1) & hash 判断当前元素存放的位置(这里的 n 指的是数组的⻓度)，如果当前位置存在元素的话，就判断该元素与要存 入的元素的 hash 值以及 key 是否相同，如果相同的话，直接覆盖，不相同就通过拉链法解决冲突。
所谓扰动函数指的就是 HashMap 的 hash 方法。使用 hash 方法也就是扰动函数是为了防止一些实现比较差的hashCode() 方法 换句话说使用扰动函数之后可以减少碰撞。
## 1.8源码
``` java
static final int hash(Object key) {
   int h;
   // key.hashCode(): 返回散列值就是hashcode
   // ^ : 按位异或
   // >>> : 无符号右移，忽略符号位，空位都以0补齐
   return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```
## 1.7源码
``` java
static int hash(int h){
   h ^= (h >>> 20) ^ (h >>> 12);
   return h ^ (h >>> 7) ^ (h >>> 4);
}
```