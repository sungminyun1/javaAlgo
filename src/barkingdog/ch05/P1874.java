package barkingdog.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class P1874 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> input = new ArrayList<>();
        for(int i =0; i<N; i++){
            input.add(Integer.parseInt(br.readLine()));
        }

        int idx = 0;
        int val = 1;
        while (idx < input.size()) {
            int now = input.get(idx);
            if(stack.isEmpty() || stack.peek() < now){
                stack.add(val++);
                sb.append("+\n");
            }else if(stack.peek() == now){
                idx++;
                stack.pop();
                sb.append("-\n");
            } else{
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}
