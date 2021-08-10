package makotogu;

/**
 * 在swap方法中，a,b的值进行交换，并不会影响num1、num2。因为a，b中的值是从num1、num2中复制的，a、b再怎么变也不会影响原始的
 * 一个方法不能修改一个基本数据类型的参数
 */
public class CallByValueTest1 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 20;

        swap(num1, num2);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }

    public static void swap(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }
}
