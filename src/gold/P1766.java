package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1766 {
    public static class Node implements Comparable<Node>{
        public Queue<Integer> q;
        public Node(Queue<Integer> q){
            this.q = q;
        }

        @Override
        public int compareTo(Node o) {
            return q.peek() - o.q.peek();
        }
    }

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static PriorityQueue<Node> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] needPrev = new boolean[N+1];
        HashMap<Integer,Integer> graph = new HashMap<>();

        for(int i =0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int post = Integer.parseInt(st.nextToken());
            needPrev[post] = true;
            graph.put(prev, post);
        }

        for(int i =1; i<N+1; i++){
            if(!needPrev[i]){
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                Integer now = graph.get(i);
                while(now != null){
                    q.offer(now);
                    now = graph.get(now);
                }
                Node n = new Node(q);
                pq.add(n);
            }
        }

        ArrayList<String> answer = new ArrayList<>();
        while(pq.size() > 0){
            Node cn = pq.poll();
            Queue<Integer> cq = cn.q;
            answer.add("" + cq.poll());
            if(cq.size()>0){
                pq.add(cn);
            }
        }
       System.out.println(String.join(" ",answer));
    }
}
