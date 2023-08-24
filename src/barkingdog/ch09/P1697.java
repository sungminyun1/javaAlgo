package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        boolean[] visited = new boolean[MAX];
        visited[start] = true;
        nv.add(start);

        int count = 0;
        while (!nv.isEmpty()) {
            int ns = nv.size();
            for (int i = 0; i < ns; i++) {
                int now = nv.poll();
                if(now == dest){
                    System.out.println(count);
                    return;
                }
                if (now + 1 < MAX && !visited[now + 1]) {
                    visited[now+1] = true;
                    nv.add(now + 1);
                }
                if (now - 1 > 0 && !visited[now - 1]) {
                    visited[now-1] = true;
                    nv.add(now - 1);
                }
                if (now *2 < MAX && !visited[now *2]) {
                    visited[now*2] = true;
                    nv.add(now *2);
                }
            }
            count++;
        }
        System.out.println(count);
    }
}
