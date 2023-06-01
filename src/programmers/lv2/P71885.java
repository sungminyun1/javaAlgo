package programmers.lv2;
import java.util.*;
public class P71885 {

    class Solution {
        public String solution(String[] participant, String[] completion) {
            HashMap<String,Integer> hm = new HashMap<>();
            for(String p : participant){
                if(hm.get(p) == null){
                    hm.put(p,1);
                }else{
                    hm.put(p, hm.get(p)+1);
                }
            }
            for(String c : completion){
                hm.put(c, hm.get(c)-1);
            }

            for(String key : hm.keySet()){
                if(hm.get(key) > 0) {
                    return key;
                }
            }
            return "";
        }
    }
}
