package makotogu.pattern.singleton.demo9;

import java.io.IOException;
import java.io.InputStream;

public class RuntimeDemo {
    public static void main(String[] args) throws IOException {
        //获取runtime类的对象
        Runtime runtime = Runtime.getRuntime();

        //嗲用runtime的方法 exec方法，需要一个命令参数
        Process process = runtime.exec("ipconfig");
        //调用process对象的获取输入流的方法
        InputStream inputStream = process.getInputStream();
        byte[] arr = new byte[1024 * 1024 * 100];
        //读取数据
        int len = inputStream.read(arr);//返回独到的字节的个数
        //将字节数组转换为字符串输出到控制台
        System.out.println(new String(arr,0,len,"GBK"));
    }
}
