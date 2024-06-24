package barkingdog2.ch04;

import java.io.*;
import java.util.*;

public class P5397 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer CASES = Integer.parseInt(st.nextToken());

        for(int i = 0; i< CASES; i++){
            solve(br.readLine());    
        }
        System.out.println(sb);
    }

    public static void solve(String input){
        LinkedList<String> list = new LinkedList<>();
        ListIterator<String> iter = list.listIterator();
        for(int i = 0; i<input.length(); i++){
            char token = input.charAt(i);
            if(token == '<'){
                if(iter.hasPrevious()){
                    iter.previous();
                }
            }else if(token == '>'){
                if(iter.hasNext()){
                    iter.next();
                }
            }else if(token == '-'){
                if(iter.hasPrevious()){
                    iter.previous();
                    iter.remove();
                }
            }else {
                iter.add(String.valueOf(token));
            }
        }

        for(String s : list){
            sb.append(s);
        }
        sb.append("\n");
    }
}