package barkingdog.ch13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2467 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = N-1;
        double min = Double.MAX_VALUE;
        int al = 0, ar = N-1;
        while(l < r){
            double m = ((double)arr[l] + (double)arr[r]) / 2;
            if(Math.abs(m) < Math.abs(min)){
                min = m;
                al = l;
                ar = r;
            }

            if(m >= 0){
                r -= 1;
            }else{
                l += 1;
            }
        }
//        System.out.println(min);
        System.out.println(arr[al] + " " + arr[ar]);
//        System.out.println(arr[ar]);

    }
}
