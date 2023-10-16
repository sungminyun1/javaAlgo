package barkingdog.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P6198 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        long result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());
            while( !stack.isEmpty() && stack.peek() <= t){
                stack.pop();
            }

            result += stack.size();
            stack.push(t);
        }

        System.out.println(result);
    }
}
