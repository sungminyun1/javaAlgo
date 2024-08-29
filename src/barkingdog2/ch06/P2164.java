package barkingdog2.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2164 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=N; i++){
            q.add(i);
        }

        while(q.size() > 1){
            q.poll();
            int t = q.poll();
            q.offer(t);
        }

        System.out.println(q.poll());
    }
}
