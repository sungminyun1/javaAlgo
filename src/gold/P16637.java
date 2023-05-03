package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16637 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int[] NUMS;
    public static char[] OPERS;
    public static boolean[] visited;
    public static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        NUMS = new int[N/2+1];
        OPERS = new char[N/2];
        visited = new boolean[N/2];
        for(int i =0; i<input.length(); i++){
            if(i % 2 == 0){
                NUMS[i/2] = Integer.parseInt(""+input.charAt(i));
            }else{
                OPERS[i/2] = input.charAt(i);
            }
        }
        DFS(0,NUMS[0]);

        System.out.println(result);
    }
    public static void DFS(int idx, int sum){
        if(idx >= N/2){
            result = Math.max(result,sum);
            return;
        }

        int res1 = calc(sum,NUMS[idx+1],OPERS[idx]);
        DFS(idx + 1, res1);

        if(idx < N/2 -1){
            int res2 = calc(NUMS[idx + 1], NUMS[idx + 2], OPERS[idx + 1]);
            DFS(idx + 2, calc(sum, res2, OPERS[idx]));
        }

    }

    public static int calc(int val1, int val2, char oper){
        if(oper == '+'){
            return val1 + val2;
        }else if(oper == '-'){
            return val1-val2;
        }else if(oper == '*'){
            return val1*val2;
        }
        return 0;
    }
}
