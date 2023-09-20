package barkingdog.ch13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int res = search(arr, Integer.parseInt(st.nextToken()));
            sb.append(res + "\n");
        }

        System.out.println(sb);
    }

    public static int search(int[] arr, int target) {
        int l = 0, r = arr.length -1;
        while(r >= l){
            int m = (l+r)/2;
            if(arr[m] == target) return 1;
            if(arr[m] > target){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return 0;
    }
}
