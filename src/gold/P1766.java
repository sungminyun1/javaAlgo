package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class P1766 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] count = new int[N+1];
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();

        for(int i =0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int post = Integer.parseInt(st.nextToken());
            count[post] += 1;
            if(graph.get(prev) == null) graph.put(prev, new ArrayList<Integer>());
            graph.get(prev).add(post);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =1; i<count.length; i++){
            if(count[i] == 0){
                pq.add(i);
            }
        }
        ArrayList<String> answer = new ArrayList<>();
        while(pq.size() > 0){
            int now = pq.poll();
            answer.add(""+now);
            ArrayList<Integer> nowArr = graph.get(now);
            if(nowArr != null){
                for (int i : nowArr) {
                    count[i]--;
                    if(count[i] == 0) pq.add(i);
                }
            }
        }
        System.out.println(String.join(" ",answer));
    }
}
