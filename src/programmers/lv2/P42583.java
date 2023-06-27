package programmers.lv2;
import java.util.*;
public class P42583 {

    class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int answer = 0;
            int cw = 0;
            Queue<Integer> q = new LinkedList<>();
//            Queue<Integer> q = new ArrayList<>();
            for(int i =0; i<bridge_length; i++){
                q.add(0);
            }
            int idx = 0;
            while(idx<truck_weights.length){
                answer++;
                cw -= q.poll();
                if (cw + truck_weights[idx] <= weight){
                    cw += truck_weights[idx];
                    q.add(truck_weights[idx]);
                    idx++;
                } else{
                    q.add(0);
                }
            }

            return answer + bridge_length;
        }
    }
}
