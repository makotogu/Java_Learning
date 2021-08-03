import makotogu.basicPackage.Person;
import makotogu.basicPackage.Worker;
import org.junit.Test;

public class BasicTest {

    @Test
    public void testBasic() {
        Person person1 = new Person();
        Person person2 = new Person();
        Person worker = new Worker();

        person1.introduce();
        worker.introduce();

        person1.setAge(20);
        person2.setAge(21);
        worker.setAge(16);

        System.out.println(person1.getAge());
        System.out.println(person2.getAge());
        //System.out.println(worker.getAge());
    }
}
