package barkingdog2.ch14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2531 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int c;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] used = new int[d+1];
        for (int i = 0; i < k; i++) {
            used[arr[i]]++;
        }
        int l = 0, r = k-1, tc = 0, result = 0;
        while(tc < N){
            int tr = calc(used);
            result = Math.max(result, tr);
            int nl = l < N-1? l+1 : 0;
            int nr = r < N-1? r+1 : 0;
            used[arr[l]]--;
            used[arr[nr]]++;
            tc++;
            l = nl;
            r = nr;
        }
        System.out.println(result);
    }

    public static int calc(int[] used){
        int count = 0;
        for (int i : used) {
            if(i > 0){
                count++;
            }
        }

        return used[c] > 0? count: count+1;
    }
}
