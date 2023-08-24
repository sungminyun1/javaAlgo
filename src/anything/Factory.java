package anything;

public class Factory {
    public static String create(int type){
        if(type == 1){
            return "one";
        }else if(type == 2){
            return "two";
        }
        return "zero";
    }
}
