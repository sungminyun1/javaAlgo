package barkingdog.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class P10828 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(st.nextToken());
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")){
                stack.add(Integer.parseInt(st.nextToken()));
            } else if (cmd.equals("pop")) {
                if (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }else{
                    sb.append(-1);
                }
                sb.append("\n");
            } else if (cmd.equals("size")) {
                sb.append(stack.size());
                sb.append("\n");
            } else if (cmd.equals("empty")) {
                if (stack.isEmpty()) {
                    sb.append(1);
                }else{
                    sb.append(0);
                }
                sb.append("\n");
            } else if (cmd.equals("top")) {
                if (stack.isEmpty()) {
                    sb.append(-1);
                }else{
                    sb.append(stack.peek());
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
