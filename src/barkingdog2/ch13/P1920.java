package barkingdog2.ch13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920 {
    public static int N,M;
    public static int[] arr;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int t = Integer.parseInt(st.nextToken());
            solve(t);
        }

        System.out.println(sb);
    }

    public static void solve(int n){
        int l =0, r = N-1, m;
        while (l <= r) {
            m = (l + r) / 2;
            if(arr[m] == n){
                sb.append(1).append("\n");
                return;
            }else if(arr[m] < n){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        sb.append(0).append("\n");
    }
}
