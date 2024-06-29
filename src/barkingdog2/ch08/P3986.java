package barkingdog2.ch08;

import java.util.*;
import java.io.*;

public class P3986{

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int result = 0;
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N; i++){
            solve(br.readLine());
        }

        System.out.println(result);
    }

    public static void solve(String str){
        Stack<Character> q = new Stack<>();
        for(int i =0; i< str.length(); i++){
            char t = str.charAt(i);
            if(q.isEmpty()){
                q.add(t);
            }else if(q.peek() == t){
                q.pop();
            }else {
                q.add(t);
            }
        }

        if(q.isEmpty()) result++;
    }
}