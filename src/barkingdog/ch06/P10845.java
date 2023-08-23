package barkingdog.ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P10845 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int last = -1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if (cmd.equals("push")) {
                int val = Integer.parseInt(st.nextToken());
                last = val;
                queue.add(val);
            } else if (cmd.equals("pop")) {
                if(queue.isEmpty()){
                    sb.append(-1);
                }else{
                    sb.append(queue.poll());
                }
                sb.append("\n");
            } else if (cmd.equals("size")) {
                sb.append(queue.size());
                sb.append("\n");
            } else if (cmd.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                sb.append("\n");
            } else if (cmd.equals("front")) {
                if(queue.isEmpty()){
                    sb.append(-1);
                }else{
                    sb.append(queue.peek());
                }
                sb.append("\n");
            } else if (cmd.equals("back")) {
                if(queue.isEmpty()){
                    sb.append(-1);
                }else{
                    sb.append(last);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
