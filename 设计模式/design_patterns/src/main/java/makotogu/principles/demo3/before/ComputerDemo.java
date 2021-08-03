package makotogu.principles.demo3.before;

public class ComputerDemo {
    public static void main(String[] args) {
        //创建组建对象
        XiJieHardDisk hardDisk = new XiJieHardDisk();
        IntelCPU cpu = new IntelCPU();
        KingstonMemory memory = new KingstonMemory();

        //创建计算机对象
        Computer c = new Computer();
        c.setCpu(cpu);
        c.setHardDisk(hardDisk);
        c.setMemory(memory);

        c.run();

    }
}
