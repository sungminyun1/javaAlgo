package barkingdog.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P9012 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(solve(br.readLine()));
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static String solve(String S){
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            char now = S.charAt(i);
            if(now == '('){
                count++;
            }else {
                if(count == 0){
                    return "NO";
                }
                count--;
            }
        }
        return count == 0 ? "YES" : "NO";
    }
}
