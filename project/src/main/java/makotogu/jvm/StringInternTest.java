package makotogu.jvm;

public class StringInternTest {

    public static void main(String[] args) {
        System.out.println();
        String s = new String("a") + new String("b");
        String x ="ab";
        // 堆 new String("a")   new String("b")  new String("ab")
        String s2 = s.intern();
        //↑将这个字符串对象尝试放入串池，如果有则并不会放入，如果没有则放入串池，会把串池中的对象返回

        System.out.println(s2 == "ab");
        System.out.println(s == "ab");
        System.out.println("---------------");
        System.out.println(s2 == x);
        System.out.println(s == x);
    }
}
