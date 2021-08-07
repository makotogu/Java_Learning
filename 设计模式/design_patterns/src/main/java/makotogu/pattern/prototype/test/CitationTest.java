package makotogu.pattern.prototype.test;

public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        //创建原型对象
        Citation citation1 = new Citation();
        //克隆奖状对象
        Citation citation2 = citation1.clone();
        citation1.setName("张三");
        citation2.setName("李四");

        citation1.show();
        citation2.show();
    }
}
