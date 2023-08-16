package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16953 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        long start = Long.parseLong(st.nextToken());
        long target = Long.parseLong(st.nextToken());

        Queue<Long> q = new LinkedList<>();
        q.add(start);

        int level = 1;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for(int i =0; i<qSize; i++){
                long now = q.poll();
                long candi1 = now *10 +1;
                long candi2 = now * 2;
                if(candi1 == target || candi2 == target){
                    System.out.println(level+1);
                    return;
                }
                if(candi1 < target){
                    q.add(candi1);
                }
                if(candi2 < target){
                    q.add(candi2);
                }
            }
            level++;
        }
        System.out.println(-1);
    }
}
