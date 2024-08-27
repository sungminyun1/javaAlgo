package barkingdog2.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1874 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();

        StringBuilder sb = new StringBuilder();
        int cursor = 1;
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());
            while(true){
                if(stack.isEmpty() || stack.peek() < t){
                    stack.push(cursor);
                    cursor++;
                    sb.append("+").append("\n");
                }else if(stack.peek() == t){
                    stack.pop();
                    sb.append("-").append("\n");
                    break;
                }else{
                    System.out.println("NO");
                    return;
                }
            }
        }
        System.out.println(sb);
    }
}
