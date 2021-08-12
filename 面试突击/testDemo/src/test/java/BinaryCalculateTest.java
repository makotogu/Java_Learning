import org.junit.Test;

public class BinaryCalculateTest {

    @Test
    public void test1() {
        // 8 = 1000
        System.out.println(8>>>2);
    }

    @Test
    public void test () {
        int a = 17;
        a |= a >>> 1;
        a |= a >>> 2;
        a |= a >>> 4;
        a |= a >>> 8;
        a |= a >>> 16;
        a |= a >>> 32;
        System.out.println(a+1);
    }
}
