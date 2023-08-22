package barkingdog.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class P5397 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            solve(st.nextToken());
        }
        System.out.println(sb);
    }

    public static void solve(String input) {
        LinkedList<Character> list = new LinkedList<>();
        ListIterator<Character> iter = list.listIterator();
        for(int i =0; i<input.length(); i++){
            char now = input.charAt(i);
            if(now == '<'){
                if(iter.hasPrevious()){
                    iter.previous();
                }
            }else if(now == '>'){
                if(iter.hasNext()){
                    iter.next();
                }
            }else if(now == '-'){
                if(iter.hasPrevious()){
                    iter.previous();
                    iter.remove();
                }
            }else{
                iter.add(now);
            }
        }
        for (char c : list) {
            sb.append(c);
        }
        sb.append("\n");
    }
}
