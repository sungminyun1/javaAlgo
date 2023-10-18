package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13913 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int start, target;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[200_001];
        Queue<Node> nv = new LinkedList<>();
        nv.add(new Node(start, 0, new int[]{start}));
        visited[start] = true;
        while (!nv.isEmpty()) {
            Node now = nv.poll();
            if(now.getVal() == target){
                System.out.println(now);
                return;
            }
            int[] nexts = {now.getVal() -1, now.getVal() +1, now.getVal() * 2};
            for (int i = 0; i < nexts.length; i++) {
                int next = nexts[i];
                if (next >= 0 && next < 100_001 && !visited[next]) {
                    int[] nextPath = new int[now.getPath().length + 1];
                    for (int k = 0; k < now.getPath().length; k++) {
                        nextPath[k] = now.getPath()[k];
                    }
                    nextPath[nextPath.length - 1] = next;
                    nv.add(new Node(next, now.getDist() + 1, nextPath));
                    visited[next] = true;
                }
            }
        }
    }

    public static class Node{
        int dist, val;
        int[] path;
        Node(int val, int dist, int[] path){
            this.val = val;
            this.dist = dist;
            this.path = path;
        }

        public int getDist() {
            return dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int[] getPath() {
            return path;
        }

        public void setPath(int[] path) {
            this.path = path;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(dist);
            sb.append("\n");
            for(int i : path){
                sb.append(i + " ");
            }
            return sb.toString();
        }
    }
}
