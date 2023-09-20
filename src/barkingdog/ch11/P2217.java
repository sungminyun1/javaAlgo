package barkingdog.ch11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class P2217 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Long[] arr = new Long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr, (a,b)-> (int)(b-a));
        long max = 0;
        for (int i = 0; i < arr.length; i++) {
           max = Math.max(max,arr[i] * (i+1));
        }
        System.out.println(max);
    }
}
