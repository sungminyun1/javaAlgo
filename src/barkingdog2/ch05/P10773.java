package barkingdog2.ch05;

import java.io.*;
import java.util.*;

public class P10773 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i =0; i<N; i++){
            int c = Integer.parseInt(br.readLine());
            if(c == 0){
                stack.pop();
            }else {
                stack.push(c);
            }
        }

        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }

        System.out.println(result);
    }
}
