package programmers.lv2;
import java.util.*;

public class P181188 {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets,(a,b)->{return a[1] - b[1];});
        int last = -1;
        for(int[] target : targets){
            if(last < 0 || last < target[0]){
                answer++;
                last = target[1] -1;
            }else {
                continue;
            }
        }

        return answer;
    }
}
