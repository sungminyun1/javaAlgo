package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class P2164 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i =1; i<= num; i++){
            queue.offer(i);
        }

        while(queue.size() > 1){
            queue.poll();
            Integer val = queue.poll();
            if(val != null){
                queue.offer(val);
            }
        }

        System.out.println(queue.poll());
    }
}
