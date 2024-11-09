package barkingdog2.ch14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2003 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int ans = 0;

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = arr[0], l = 0, r = 0;
        while (true) {
            if(sum == M){
                ans++;
            }
            if(r == l){
                r++;
                if(r < N){
                    sum += arr[r];
                }else{
                    break;
                }
            }else if(sum <= M){
                r++;
                if(r < N){
                    sum += arr[r];
                }else{
                    break;
                }
            } else {
                sum -= arr[l];
                l++;
            }
        }

        System.out.println(ans);
    }
}
