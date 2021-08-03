package makotogu.jvm;


import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 弱引用演示
 * -Xmx20m -XX:+PrintGCDetails -verbose:gc
 * @author jianw
 */
public class WeakReferenceTest {
    private static final int _4MB = 4*1024*1024;

    public static void main(String[] args) {
        List<WeakReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WeakReference<byte[]> ref = new WeakReference<>(new byte[_4MB]);
            list.add(ref);
            for (WeakReference<byte[]> weakReference : list) {
                System.out.println(weakReference.get()+" ");
            }
            System.out.println();
        }
        System.out.println("循环结束：" + list.size());
    }
}
