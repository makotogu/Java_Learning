package makotogu.principles.demo4.before;

public class Client {
    public static void main(String[] args) {
        XiaomiSafetyDoor safetyDoor = new XiaomiSafetyDoor();
        safetyDoor.antiTheft();
        safetyDoor.waterProof();
        safetyDoor.fireProof();
    }
}
