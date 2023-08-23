package barkingdog.ch05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class P2493 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] ans = new int[N];
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = N-1; i>0; i--){
            stack.add(i);
            while(!stack.isEmpty()){
                if (arr[i-1] > arr[stack.peek()]) {
                    int idx = stack.pop();
                    ans[idx] = i;
                }else{
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
