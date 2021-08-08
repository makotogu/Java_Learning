package JVM_test;

import org.junit.Test;

public class StringTableTest {
    //常量池中的信息，都会被加载到运行时常量池中， 这是 a,b,ab都是常量池中的符号，还没有变为java中的字符串对象
    // ldc #2 会把a符号变成"a"字符串对象
    // ldc #3 会把b符号变成"b"字符串对象
    //

    @Test
    public void test1(){
        String s1 = "a"; //懒汉行为，用到了才会创建
        String s2 = "b";
        String s3 = "a"+"b"; //javac 在编译期间的优化，结果已经优化为"ab"
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
