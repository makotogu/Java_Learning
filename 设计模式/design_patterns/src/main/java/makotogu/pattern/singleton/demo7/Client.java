package makotogu.pattern.singleton.demo7;

import java.io.*;

/**
 * 测试使用序列化反序列化破坏
 */
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        writeObject2File();
        readObjectFromFile();
        readObjectFromFile();
    }

    //从文件中读取数据（对象）
    public static void readObjectFromFile() throws IOException, ClassNotFoundException {
        //1. 创建对象输入流对象
        File file;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("C:\\Users\\jianw\\Desktop\\a.txt"));
        //2. 读取对象
        Singleton instance = (Singleton) objectInputStream.readObject();

        System.out.println(instance);
    }
    //向文件中写数据（对象）
    public static void writeObject2File() throws IOException {
        //1. 读取Singleton对象
        Singleton instance = Singleton.getInstance();
        //2. 创建对象数输出流对象
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("C:\\Users\\jianw\\Desktop\\a.txt"));
        //3. 写对象
        objectOutputStream.writeObject(instance);
        objectOutputStream.close();
    }
}

