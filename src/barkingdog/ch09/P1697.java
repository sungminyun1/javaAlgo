package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1697 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int dest= Integer.parseInt(st.nextToken());

        Queue<Integer> nv = new LinkedList<>();
        final int MAX = 200001;

        int[] dist = new int[MAX];
        Arrays.fill(dist, -1);
        nv.add(start);
        dist[start] = 0;

        while(!nv.isEmpty()){
            int now = nv.poll();
            if(now == dest){
                System.out.println(dist[now]);
                return;
            }

            int[] nexts = {now + 1, now - 1, now * 2};
            for (int next : nexts) {
                if(next < 0 || next >= MAX || dist[next] >= 0) continue;
                dist[next] = dist[now] +1;
                nv.add(next);
            }
        }
    }
}
