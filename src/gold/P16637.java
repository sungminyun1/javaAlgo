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
        find(0,0);
    }
    public static void find(int level, int start){

    }

    public static int calc(){
        int res = 0;
        for(int i =0; i<visited.length; i++){
            if(visited[i]){
                switch(OPERS[i]){
                    case '+':
                        NUMS[i] += NUMS[i+1];
                        NUMS[i+1] = NUMS[i];
                        break;
                    case '-':
                        NUMS[i] -= NUMS[i+1];
                        NUMS[i+1] = NUMS[i];
                        break;
                    case '*':
                        NUMS[i] *= NUMS[i+1];
                        NUMS[i+1] = NUMS[i];
                        break;
                }
            }
        }
        for(int i =0; i<visited.length; i++){
            if(!visited[i]){
                switch(OPERS[i]){
                    case '+':
                        result += NUMS[i] + NUMS[i+1];
                        break;
                    case '-':
                        NUMS[i] -= NUMS[i+1];
                        NUMS[i+1] = NUMS[i];
                        break;
                    case '*':
                        NUMS[i] *= NUMS[i+1];
                        NUMS[i+1] = NUMS[i];
                        break;
                }
            }
        }
        return 0;
    }
}
