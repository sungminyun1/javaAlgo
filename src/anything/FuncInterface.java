package anything;

public class FuncInterface {

    public static void main(String[] args) {
        PlusCalc<Integer> plusInt = (a, b) -> a + b;
        System.out.println(plusInt.plus(1,2));
    }
}
