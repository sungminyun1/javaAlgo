package barkingdog2.ch07;

import java.io.*;
import java.util.*;

public class P1021 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Deque<Integer> dq = new LinkedList<>();
    public static Integer answer = 0;
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        
        for(int i =1; i<=N; i++){
            dq.add(i);
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<M; i++){
            solve(Integer.parseInt(st.nextToken()));
        }

        System.out.println(answer);
    }

    public static void solve(int num){
        int count = 0;
        while(dq.peekFirst() != num){
            count++;
            int p = dq.removeFirst();
            dq.add(p);
        }
        answer += Math.min(count, dq.size() - count);
        dq.removeFirst();
    }
}
