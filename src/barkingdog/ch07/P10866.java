package barkingdog.ch07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P10866 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push_front")) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if (cmd.equals("push_back")) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            } else if (cmd.equals("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append(-1);
                }else{
                    sb.append(deque.pollFirst());
                }
                sb.append("\n");
            } else if (cmd.equals("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append(-1);
                }else{
                    sb.append(deque.pollLast());
                }
                sb.append("\n");
            } else if (cmd.equals("size")) {
                sb.append(deque.size());
                sb.append("\n");
            } else if (cmd.equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                sb.append("\n");
            } else if (cmd.equals("front")) {
                if (deque.isEmpty()) {
                    sb.append(-1);
                }else{
                    sb.append(deque.peekFirst());
                }
                sb.append("\n");
            } else if (cmd.equals("back")) {
                if (deque.isEmpty()) {
                    sb.append(-1);
                }else{
                    sb.append(deque.peekLast());
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
