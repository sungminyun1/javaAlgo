package anything;

import java.util.*;

public class PSVM {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        System.out.println(a);
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        System.out.println(q);
        System.out.println(q.peek());
    }
}
