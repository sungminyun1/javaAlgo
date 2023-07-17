package anything;

@FunctionalInterface
public interface PlusCalc <T extends Number>{
    T plus(T x, T y);
}
