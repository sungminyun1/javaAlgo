package ct;
import java.util.*;

public class P1 {
    public static char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];
        for(int student = 1; student<=n; student++){
            int now = student;
            for(int i =0; i< ladder.length; i++){
                for(int ladNow : ladder[i]){
                    if(ladNow == now){
                        now = ladNow+1;
                    }else if(ladNow +1 == now){
                        now = ladNow;
                    }
                }
            }
            answer[now-1] = (char)(64+student);
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}

