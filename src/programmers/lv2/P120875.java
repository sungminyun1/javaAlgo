package programmers.lv2;
import java.util.*;
public class P120875 {


    class Solution {
        public HashSet<Double> hm = new HashSet<>();
        public int solution(int[][] dots) {
            int answer = 0;
            for(int i =0; i<dots.length-1; i++){
                for(int j = i+1; j<dots.length; j++ ){
                    int[] p1 = dots[i];
                    int[] p2 = dots[j];
                    double a = 1.0*(p2[1] - p1[1]) / (p2[0] - p1[0]);
                    if(hm.contains(a)) return 1;
                    hm.add(a);
                }
            }
            return answer;
        }
    }
}
