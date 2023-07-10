package programmers.lv2;
import java.util.*;
public class P42628 {
    class Solution {
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> minPq = new PriorityQueue<>();
            PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

            for(String now : operations){
                String[] sp = now.split(" ");
                String cmd = sp[0];
                Integer val = Integer.parseInt(sp[1]);
                if(cmd.equals("I")){
                    minPq.offer(val);
                    maxPq.offer(val);
                }else if(val < 0 && minPq.size() > 0){
                    int min = minPq.poll();
                    maxPq.remove(min);
                }else if(val > 0 && maxPq.size() >0){
                    int max = maxPq.poll();
                    minPq.remove(max);
                }
            }

            if(minPq.size() == 0){
                return new int[]{0,0};
            }
            return new int[]{maxPq.poll(),minPq.poll()};
        }
    }
}
