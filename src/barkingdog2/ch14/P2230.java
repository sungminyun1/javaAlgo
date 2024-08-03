package barkingdog2.ch14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2230 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int l = 0, r = 0;
        int ans = Integer.MAX_VALUE;
        while (r < N && l < N) {
            int diff = arr[r] - arr[l];
            if(diff >= M){
                l++;
                ans = Math.min(ans, diff);
            }else{
                r++;
            }
        }

        System.out.println(ans);
    }
}
