package barkingdog2.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2579 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] memo  = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if(N == 1){
            System.out.println(arr[1]);
            return;
        }

        if(N == 2){
            System.out.println(arr[1] + arr[2]);
            return;
        }
        memo[1] = arr[1];
        memo[2] = arr[2] + arr[1];
        for(int i = 3; i <= N; i++) {
            int candi1 = memo[i - 2] + arr[i];
            int candi2 = memo[i - 3] + arr[i - 1] + arr[i];
            memo[i] = Math.max(candi1, candi2);
        }
        System.out.println(memo[N]);
    }
}
