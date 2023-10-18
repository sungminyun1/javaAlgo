package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P13913_2 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int start, target;
    public static int[] visited;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());
        visited = new int[100_001];
        Arrays.fill(visited, -1);
        Queue<Integer> nv = new LinkedList<>();
        nv.add(start);
        visited[start] = 200_000;
        while (!nv.isEmpty()) {
            int now = nv.poll();
            if(now == target){
                printAnswer(visited);
                return;
            }
            int[] nexts = {now + 1, now - 1, now * 2};
            for (int i = 0; i < nexts.length; i++) {
                int next = nexts[i];
                if (next >= 0 && next < 100_001 && visited[next] < 0) {
                    nv.add(next);
                    visited[next] = now;
                }
            }
        }
    }

    public static void printAnswer(int[] visited) {
        Stack<Integer> stack = new Stack<>();
        int now = target;
        while (now < 100_001) {
            stack.push(now);
            now = visited[now];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(stack.size()-1 + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb);
    }
}
