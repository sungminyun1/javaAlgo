package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P9466 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            solve(N, arr);
        }
    }

    public static void solve(int N, int[] arr) {
        int[] visited = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            if (visited[i] == 0) {
                run(i, visited, arr);
            }
        }
        int ans = 0;
        for (int i = 1; i < arr.length; i++) {
            if (visited[i] != -1) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void run(int x, int[] visited, int[] arr){
        int cur = x;
        while (true) {
            visited[cur] = x;
            cur = arr[cur];
            if(visited[cur] == x){
                while(visited[cur] != -1){
                    visited[cur] = -1;
                    cur = arr[cur];
                }
                return;
            }
            else if(visited[cur] != 0) return;
        }
    }
}
