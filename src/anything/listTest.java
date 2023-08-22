package anything;

import java.util.LinkedList;
import java.util.ListIterator;

public class listTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        ListIterator<Integer> iter = list.listIterator();
        for (int i = 0; i < 10; i++) {
            if (!iter.hasNext()) {
                iter = list.listIterator();
            }
            System.out.println(iter.next());
        }

    }
}
