package makotogu;

/**
 * 方法没有改变存储在s1和s2中的对象引用，swap方法的参数x和y被初始化成为两个对象引用的拷贝，这个方法交换的是这个两个拷贝
 */
public class CallByValueTest3 {
    public static void main(String[] args) {
        Student s1 = new Student("小张");
        Student s2 = new Student("小李");
        swap(s1,s2);
        System.out.println("s1"+s1.getName());
        System.out.println("s2"+s2.getName());
    }

    public static void swap(Student x, Student y) {
        Student temp = x;
        x = y;
        y = temp;
        System.out.println("x:"+x.getName());
        System.out.println("y:"+y.getName());
    }
}

