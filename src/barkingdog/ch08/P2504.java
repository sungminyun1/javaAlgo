package barkingdog.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P2504 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int val = 1;
        int res = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);

            if (now == '(') {
                val *= 2;
                stack.add(now);
            } else if (now == '[') {
                val *= 3;
                stack.add(now);
            } else if (now == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    res = 0;
                    break;
                }
                stack.pop();
                res += val;
                val /= 2;
            } else if (now == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    res = 0;
                    break;
                }
                stack.pop();
                res += val;
                val /= 3;
            }
        }

        System.out.println(res);
    }
}
