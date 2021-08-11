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
1. 线程是否安全：HashMap是非线程安全的，HashTable是线程安全的(但是不建议用HashTable了，要线程安全可以用ConcurrentHashMap)
2. 效率：因为线程安全的问题，HashMao要比HashTable要快些。   
3. 