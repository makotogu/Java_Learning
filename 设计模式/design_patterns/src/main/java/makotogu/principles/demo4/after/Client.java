package makotogu.principles.demo4.after;

public class Client {
    public static void main(String[] args) {
        //创建安全门对象1
        XiaoMiSafetyDoor door1 = new XiaoMiSafetyDoor();
        door1.antiTheft();
        door1.fireProof();
        door1.waterProof();

        System.out.println("========");

        DaMiSafetyDoor door2 = new DaMiSafetyDoor();
        door2.antiTheft();
        door2.fireProof();
    }
}
