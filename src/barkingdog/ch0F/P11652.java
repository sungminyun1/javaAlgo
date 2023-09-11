package barkingdog.ch0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P11652 {
    public static int N;
    public static long[] arr;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            long val = Long.parseLong(br.readLine());
            arr[i] = val;
        }
        Arrays.sort(arr);
        long maxNum = arr[0];
        int maxCount = 0;

        long nowNum = arr[0];
        int nowCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == nowNum){
                nowCount++;
            }else{
                nowNum = arr[i];
                nowCount = 1;
            }

            if(maxCount < nowCount){
                maxNum = arr[i];
                maxCount = nowCount;
            }
        }

        System.out.println(maxNum);
    }
}
