package makotogu.principles.demo3.before;

public class XiJieHardDisk {
    // 存储数据的方法
    public void save(String data) {
        System.out.println("使用希捷硬盘存储数据"+data);
    }

    public String get() {
        System.out.println("使用希捷硬盘读取数据");
        return "数据";
    }
}
