package programmers.lv2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P258711 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(new int[][]{
                {2,3}, {4,3}, {1,1}, {2,1}
        });
    }

    static class Solution {
        List<Integer>[] adj = new List[1_000_001];
        int[] in = new int[1_000_001];
        int[] out = new int[1_000_001];
        boolean[] visited = new boolean[1_000_001];
        int maxVertex = 0;
        public int[] solution(int[][] edges) {

            for(int[] edge : edges) {
                int tm = Math.max(edge[0], edge[1]);
                maxVertex = Math.max(maxVertex, tm);

                int from = edge[0], to = edge[1];
                if(adj[from] == null) {
                    adj[from] = new ArrayList<>();
                }
                if(adj[to] == null) {
                    adj[to] = new ArrayList<>();
                }
                adj[from].add(to);
                in[to]++;
                out[from]++;
            }

            int newVertexNum = 0;
            for(int i = 1; i <= maxVertex; i++) {
                if(in[i] == 0 && out[i] >= 2){
                    newVertexNum = i;
                    break;
                }
            }

            int doughnut = 0, stick = 0, eight = 0;
            for(Integer startVertex : adj[newVertexNum]) {
                int type = run(startVertex);
                if(type == 1) doughnut += 1;
                else if(type == 2) stick += 1;
                else if(type == 3) eight += 1;
            }


            return new int[]{newVertexNum, doughnut, stick, eight};
        }

        public int run(int start) {
            int vc = 0, ec = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);

            while(!queue.isEmpty()) {
                int now = queue.poll();
                if(visited[now]) continue;
                visited[now] = true;

                vc++;
                for(int i : adj[now]) {
                    ec++;
                    if(!visited[i]) {
                        queue.add(i);
                    }
                }
            }

            if(vc == ec) return 1;
            else if(vc == ec + 1) return 2;
            else return 3;
        }
    }
}
