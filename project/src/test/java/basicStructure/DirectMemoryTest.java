package basicStructure;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class DirectMemoryTest {
    static int _100Mb = 1024*1024*100;
    static int _1Gb = 1024*1024*1024;

    public static Unsafe getUnsafe() {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);
            return unsafe;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test1() {
        List<ByteBuffer> list = new ArrayList<>();
        int i = 0;
        try {
            while (true) {
                ByteBuffer byteBuffer = ByteBuffer.allocate(_100Mb);
                list.add(byteBuffer);
                i++;
            }
        } finally {
            System.out.println(i);
        }
    }

    @Test
    public void test2() throws InterruptedException {
        Unsafe unsafe = getUnsafe();
        //分配内存
        long base = unsafe.allocateMemory(_1Gb);
        unsafe.setMemory(base,_1Gb,(byte) 0);
        Thread.sleep(10*1000);
        //释放内存
        unsafe.freeMemory(base);
        Thread.sleep(10*1000);
    }
}
