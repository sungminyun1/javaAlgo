package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P13549 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int start, dest;
    public static int[] dist = new int[200001];
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        dest = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, -1);
        PriorityQueue<Node> nv = new PriorityQueue<>();
        dist[start] = 0;
        nv.add(new Node(start,0));

        while (!nv.isEmpty()) {
            Node node = nv.poll();
            int now = node.val;
            if (now == dest) {
                System.out.println(dist[now]);
                return;
            }
            int[] dx = {now + 1, now - 1, now * 2};
            for (int i = 0; i < dx.length; i++) {
                int d = dx[i];
                if(d < 0 || d >= 200001 || dist[d] >= 0 || dist[d] >= dist[now]) continue;
                if(i == 2){
                    dist[d] = dist[now];
                    nv.add(new Node(d, dist[d]));
                }else {
                    dist[d] = dist[now]+1;
                    nv.add(new Node(d, dist[d]));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int val, order;

    Node(int val, int order){
        this.val = val;
        this.order = order;
    }

    @Override
    public int compareTo(Node o) {
        return o.val - val;
    }
}
