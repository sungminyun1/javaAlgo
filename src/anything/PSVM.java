package anything;

import java.util.*;

public class PSVM {
    public static int val = 1;
    public static void main(String[] args) {
        PSVM p = new P2();
        p.run();
        System.out.println(p.val);

        P2 p2 = new P2();
        p2.run();
        System.out.println(p2.val);
    }
    public void run(){
        System.out.println("psvm run");
    }

    public static class P2 extends PSVM{
        public static int val = 2;
        public void run(){
            System.out.println("p2 run");
        }
    }
}


