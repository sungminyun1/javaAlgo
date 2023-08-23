package barkingdog.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P10773 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i =0; i<N; i++){
            int val = Integer.parseInt(br.readLine());
            if(val == 0 && !stack.isEmpty()){
                stack.pop();
            }else if(val != 0){
                stack.add(val);
            }
        }
        int ans = 0;
        for(int val : stack){
            ans += val;
        }
        System.out.println(ans);
    }
}
