package makotogu.principles.demo3.after;

public class ComputerDemo {
    public static void main(String[] args) {
        //创建计算机对象
        Computer c = new Computer();
        //创建组建对象
        HardDisk hardDisk = new XiJieHardDisk();
        Memory memory = new KingstonMemory();
        CPU cpu = new IntelCPU();

        
        c.setCpu(cpu);
        c.setHardDisk(hardDisk);
        c.setMemory(memory);
        c.run();
    }
}
