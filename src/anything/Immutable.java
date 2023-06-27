package anything;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Immutable {
    private final int val;
    private final List<String> list;

    public Immutable(int val, List<String> list){
        this.val = val;
        this.list = list;
    }

    public int getVal(){
        return val;
    }

    public List<String> getList(){
        return Collections.unmodifiableList(list);
//        return new ArrayList<>(list);
    }
}
