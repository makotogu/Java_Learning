package makotogu.pattern.builder.demo2;

public class Client {
    public static void main(String[] args) {
        //创建手机对象 使用构建者对象
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .screen("samsung")
                .memory("kingston")
                .mainBoard("asus")
                .build();

        System.out.println(phone);
    }
}
