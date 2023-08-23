package barkingdog.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P5430 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String cmd = br.readLine();
            int N = Integer.parseInt(br.readLine());
            Deque<Integer> arr = new LinkedList<>();
            String input = br.readLine();
            input = input.substring(1, input.length() - 1);
            StringTokenizer st = new StringTokenizer(input, ",");
            for (int j = 0; j < N; j++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            solve(cmd, arr);
        }

        System.out.println(sb);
    }

    public static void solve(String cmd, Deque<Integer> deque) {
        int dir = 1;
        for (int i = 0; i < cmd.length(); i++) {
            char c = cmd.charAt(i);
            if (c == 'R') {
                dir *= -1;
            }else if(c == 'D'){
                if(deque.isEmpty()){
                    sb.append("error\n");
                    return;
                }
                if(dir >0){
                    deque.pollFirst();
                }else{
                    deque.pollLast();
                }
            }
        }
        int orig_size = deque.size();
        sb.append("[");
        for(int i =0; i<orig_size; i++){
            int val = dir > 0? deque.pollFirst() : deque.pollLast();
            sb.append(val);
            if(i != orig_size -1){
                sb.append(",");
            }
        }
        sb.append("]\n");
    }
}
