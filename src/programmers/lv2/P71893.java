package programmers.lv2;
import java.util.*;
public class P71893 {

    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            int idx = 0;
            ArrayList<Integer> a = new ArrayList<>();
            while(idx < progresses.length){
                for(int i = idx; i<progresses.length; i++){
                    progresses[i] += speeds[i];
                }
                int count = 0;
                while(idx < progresses.length && progresses[idx] >= 100){
                    idx++;
                    count++;
                }
                if(count > 0){
                    a.add(count);
                }
            }
            return a.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
