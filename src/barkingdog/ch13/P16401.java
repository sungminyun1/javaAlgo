package barkingdog.ch13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16401 {
    public static int N, M;
    public static int[] arr;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int l = 1, r = arr[N-1];
        int ans = 0;
        while(l <= r){
            int m = (l + r) / 2;
            int sum = 0;
            for(int i : arr){
                sum += i / m;
            }
            if(sum >= M){
                ans = Math.max(ans, m);
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        System.out.println(ans);

    }
}
