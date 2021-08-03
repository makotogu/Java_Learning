package basicStructure;

import makotogu.utils.ArrayListCapacity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    @Test
    public void test() {
        ArrayList<Object> list = new ArrayList<>();
        int arrayListCap = ArrayListCapacity.getArrayListCap(list);
        System.out.println(arrayListCap);
        list.add("a");
        arrayListCap = ArrayListCapacity.getArrayListCap(list);
        System.out.println(arrayListCap);
        System.out.println(list.size());
        System.out.println("-----------------");

        for (int i =0; i<9; i++){
            list.add("a");
        }
        arrayListCap = ArrayListCapacity.getArrayListCap(list);
        System.out.println(arrayListCap); //10
        System.out.println(list.size());
        System.out.println("-----------------");

        list.add("a");
        arrayListCap = ArrayListCapacity.getArrayListCap(list);
        System.out.println(arrayListCap); //15
        System.out.println(list.size());
        System.out.println("-----------------");

        System.out.println(list.get(1));
        System.out.println(list.toArray());
        System.out.println(list.hashCode());

        System.out.println("hello nima");

        System.out.println("hello");
    }

}
