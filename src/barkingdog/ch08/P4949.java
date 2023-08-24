package barkingdog.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P4949 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        while (true) {
            String input = br.readLine();
            if (input.equals(".")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            boolean succ = true;
            for (int i = 0; i < input.length(); i++) {
                char now = input.charAt(i);
                if (now == '(' || now == '[') {
                    stack.add(now);
                } else if (now == ')') {
                        if(stack.isEmpty() || stack.pop() != '('){
                        succ = false;
                        break;
                    }
                } else if (now == ']') {
                    if(stack.isEmpty() || stack.pop() != '['){
                        succ = false;
                        break;
                    }
                }
            }
            if(succ && stack.isEmpty()){
                sb.append("yes\n");
            }else{
                sb.append("no\n");
            }
        }
        System.out.println(sb);
    }
}
