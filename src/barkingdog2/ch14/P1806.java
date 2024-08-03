package barkingdog2.ch14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1806 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = 0, sum = 0, res = Integer.MAX_VALUE;
        while(l <= r && r <= N){
            if(sum >= S){
                res = Math.min(res, r - l );
                sum -= arr[l];
                l++;
            }else {
                sum += arr[r];
                r++;
            }
        }

        System.out.println(res == Integer.MAX_VALUE ? 0 : res);
    }
}
