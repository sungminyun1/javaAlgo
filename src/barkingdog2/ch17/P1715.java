package barkingdog2.ch17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1715 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());
            pq.add(t);
        }

        int sum = 0;
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            int c = a + b;
            sum += c;
            pq.add(c);
        }

        System.out.println(sum);
    }
}
