package programmers.lv2;
import java.util.Arrays;
public class P71872 {
    class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            Arrays.sort(citations);
            for(int i=0; i<citations.length; i++){
                int smaller = Math.min(citations[i], citations.length-i);
                answer = Math.max(answer, smaller);
            }
            return answer;
        }
    }
}
