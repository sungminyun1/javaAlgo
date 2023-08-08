package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P11286 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<String> ans = new ArrayList<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            if(val == 0){
                if(pq.size() > 0){
                    ans.add("" + pq.poll().val);
                }else {
                    ans.add("" + 0);
                }
            }else{
                pq.add(new Node(val));
            }
        }

        System.out.println(String.join("\n", ans));
    }

    public static class Node implements Comparable<Node>{
        public int val;
        Node(int val){
            this.val = val;
        }
        @Override
        public int compareTo(Node o) {
            if( Math.abs(val) == Math.abs(o.val)){
                return val - o.val;
            }
            return Math.abs(val) - Math.abs(o.val);
        }
    }
}
