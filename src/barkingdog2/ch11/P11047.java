package barkingdog2.ch11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];

        for(int i =0; i<N; i++) {
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }

        int count = 0;
        int maxIdx = N-1;
        while(K > 0){
            if(coins[maxIdx] > K){
                maxIdx--;
            }else{
                K -= coins[maxIdx];
                count++;
            }
        }

        System.out.println(count);
    }
}
