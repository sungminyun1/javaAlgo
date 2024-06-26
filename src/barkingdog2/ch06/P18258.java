package barkingdog2.ch06;

import java.util.*;
import java.io.*;

public class P18258 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int CASES = Integer.parseInt(st.nextToken());

        int last = -1;
        
        for(int i =0; i<CASES; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")){
                int val = Integer.parseInt(st.nextToken());
                queue.add(val);
                last = val;
            }else if(cmd.equals("pop")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }else{
                    sb.append(queue.poll()+"\n");
                }
            }else if(cmd.equals("size")){
                sb.append(queue.size() + "\n");
            }else if(cmd.equals("empty")){
                if(queue.isEmpty()){
                    sb.append("1\n");
                }else{
                    sb.append("0\n");
                }
            }else if(cmd.equals("front")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }else {
                    sb.append(queue.peek() + "\n");
                }
            }else if(cmd.equals("back")){
                if(queue.isEmpty()){
                    sb.append("-1\n");
                }else {
                    sb.append(last+ "\n");
                }
            }
        }

        System.out.println(sb);
    }
}
