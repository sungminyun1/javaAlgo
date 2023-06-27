package anything;

import java.util.*;

public class PSVM {
    public static void main(String[] args) {
        ArrayList<String> initList = new ArrayList<>();
        initList.add("hello");
        Immutable immutable = new Immutable(0,initList);

        List<String> list = immutable.getList();
        System.out.println(immutable.getList());

        list.add("world");
        System.out.println(immutable.getList());
        System.out.println(list);
    }
}
