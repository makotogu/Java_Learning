package makotogu.pattern.prototype.deepClone.after;

import java.io.*;

public class CitationTest {
    public static void main(String[] args) throws Exception {
        Citation citation1 = new Citation();
        Student student1 = new Student();
        student1.setName("张三");
        citation1.setStu(student1);

        File file;
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(""));
        objectOutputStream.writeObject(citation1);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(""));
        Citation citation2 = (Citation) objectInputStream.readObject();
        objectInputStream.close();

        citation2.getStu().setName("李四");
        citation1.show();
        citation2.show();

    }
}
