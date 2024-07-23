package barkingdog2.ch0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15649 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N,M;
    private static boolean[] nums;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new boolean[N+1];

        solve(0, new ArrayList<>());
        System.out.println(sb.toString());
    }

    private static void solve(int len, ArrayList<Integer> selected){
        if(len == M){
            print(selected);
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!nums[i]){
                selected.add(i);
                nums[i] = true;
                solve(len+1, selected);
                nums[i] = false;
                selected.remove(len);
            }
        }
    }

    private static void print(ArrayList<Integer> selected){
        for(int i : selected){
            sb.append(i).append(" ");
        }

        sb.append("\n");
    }
}
