package programmers.lv2;
import java.util.*;

public class P86051 {


    class Solution {
        public int solution(int[] numbers) {
            int answer = 0;
            HashSet<Integer> hs = new HashSet<>();
            for(int i =0; i<10; i++){
                hs.add(i);
            }
            for(int number : numbers){
                hs.remove(number);
            }

            for(int val : hs){
                answer += val;
            }
            return answer;
        }
    }
}
