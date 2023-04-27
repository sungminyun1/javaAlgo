package ct;
import java.util.*;

public class P7 {
    public static int solution(int[] keypad, String password){
        int answer = 0;
        int[][] index = new int[10][2];
        for(int i =0; i<keypad.length; i++){
            index[keypad[i]][0] = i / 3;
            index[keypad[i]][1] = i % 3;
        }

        for(int i =0; i<password.length() -1; i++){
            int now = Integer.parseInt(String.valueOf(password.charAt(i)));
            int next = Integer.parseInt(String.valueOf(password.charAt(i+1)));
            if(now == next) continue;
            if(Math.abs(index[now][0] - index[next][0]) > 1 || Math.abs(index[now][1] - index[next][1]) > 1){
                answer +=2;
            }else{
                answer++;
            }
        }


        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}