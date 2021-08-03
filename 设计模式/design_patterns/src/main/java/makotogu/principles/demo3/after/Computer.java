package makotogu.principles.demo3.after;

public class Computer {

    private CPU cpu;
    private HardDisk hardDisk;
    private Memory memory;

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void run(){
        //运行计算机
        System.out.println("计算机运行了");
        String data = hardDisk.get();
        System.out.println("从硬盘上获取的数据是："+ data);
        cpu.run();
        memory.save();
    }
}
