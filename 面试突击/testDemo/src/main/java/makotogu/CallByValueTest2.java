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
