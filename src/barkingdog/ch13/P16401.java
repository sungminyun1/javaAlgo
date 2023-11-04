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

        int m = (arr[0] + arr[N-1]) / 2;;
        int l = 0, r = N-1;
        while(l <= r){
            int sum = 0;
            for(int i : arr){
                sum += i / m;
            }
            if(sum >= M){

            }
        }

    }
}
