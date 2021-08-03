package makotogu.principles.demo3.before;

public class Computer {

    private XiJieHardDisk hardDisk;
    private IntelCPU cpu;
    private KingstonMemory memory;

    @Override
    public String toString() {
        return "Computer{" +
                "hardDisk=" + hardDisk +
                ", cpu=" + cpu +
                ", memory=" + memory +
                '}';
    }

    public XiJieHardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(XiJieHardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public IntelCPU getCpu() {
        return cpu;
    }

    public void setCpu(IntelCPU cpu) {
        this.cpu = cpu;
    }

    public KingstonMemory getMemory() {
        return memory;
    }

    public void setMemory(KingstonMemory memory) {
        this.memory = memory;
    }

    public void run() {
        //运行计算机
        System.out.println("计算机运行了");
        String data = hardDisk.get();
        System.out.println("从硬盘上获取的数据是："+ data);
        cpu.run();
        memory.save();
    }
}
