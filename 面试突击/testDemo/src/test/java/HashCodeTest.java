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
    }
}

