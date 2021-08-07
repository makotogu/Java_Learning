package makotogu.pattern.prototype.deepClone.before;

public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Citation citation1 = new Citation();
        Student student1 = new Student();
        student1.setName("张三");
        citation1.setStu(student1);

        Citation citation2 = citation1.clone();
        citation2.getStu().setName("李四");

        citation1.show();
        citation2.show();

    }
}
