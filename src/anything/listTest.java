package anything;

import java.util.LinkedList;

public class listTest {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        System.out.println(list.size());
        list.remove(1);
        System.out.println(list);
    }
}
