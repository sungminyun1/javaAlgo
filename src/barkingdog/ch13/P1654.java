package barkingdog.ch13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1654 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static long[] arr;
    public static int K, N;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            max = Math.max(arr[i], max);
        }

        long left = 1;
        long right = max;

        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;
            for (long i : arr) {
                count += i / mid;
            }
            if (count >= N) {
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        System.out.println((left + right) / 2);

    }
}
