package barkingdog.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P3986 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                char now = input.charAt(j);
                if(stack.isEmpty() || stack.peek() != now){
                    stack.add(now);
                }else{
                    stack.pop();
                }
            }
            if(stack.isEmpty()) ans++;
        }
        System.out.println(ans);
    }
}
