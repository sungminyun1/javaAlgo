package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P11279 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        ArrayList<String> ans = new ArrayList<>();
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            if(val == 0){
                if (pq.size() > 0) {
                    ans.add(""+pq.poll());
                } else {
                    ans.add(""+0);
                }
            }else{
                pq.add(val);
            }
        }

        System.out.println(String.join("\n",ans));
    }
}
