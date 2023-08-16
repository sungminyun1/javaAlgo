package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2606 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int pcCount = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[pcCount+1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0; i<pcCount+1; i++){
            graph.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        for(int i =0; i<count; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
            graph.get(to).add(from);

        }

        ArrayList<Integer> needVisit = graph.get(1);
        visited[1] = true;
        while(!needVisit.isEmpty()){
            int now = needVisit.get(0);
            needVisit.remove(0);
            if(visited[now]) continue;

            visited[now] = true;
            answer++;

            ArrayList<Integer> next = graph.get(now);
            for (Integer t : next) {
                needVisit.add(t);
            }
        }
        System.out.println(answer);
    }
}
