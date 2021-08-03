package makotogu.principles.demo2.before;

/**
 * @author gujiacheng
 */
public class RectangleDemo {
    public static void main(String[] args) {
        //创建长方形对象
        Rectangle r = new Rectangle();
        //设置长和宽
        r.setWidth(10);
        r.setLength(20);
        //调用resize方法进行扩展
        resize(r);
        printLengthAndWidth(r);
        System.out.println("=======");
        Square square = new Square();
        square.setLength(10);
        resize(square);
        printLengthAndWidth(square);
    }

    public static void resize(Rectangle rectangle) {
        //如果宽比长小，进行扩宽的操作
        while (rectangle.getWidth() <= rectangle.getLength()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    //打印长和宽
    public static void printLengthAndWidth(Rectangle rectangle) {
        System.out.println(rectangle.getLength());
        System.out.println(rectangle.getWidth());
    }
}
