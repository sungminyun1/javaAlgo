package barkingdog2.ch14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P22862 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = 0, kc = arr[0] % 2 == 0 ? 0 : 1, seq = arr[0] % 2 == 0 ? 1 : 0;
        int res = 0;
        while (l <= r) {
            res = Math.max(res, seq);
            int nr = r+1;
            if(nr == N) break;
            int now = arr[nr];

            if (now % 2 == 0) {
                r = nr;
                seq++;
            } else if (kc < K) {
                r = nr;
                kc++;
            } else if(arr[l] % 2 == 0){
                seq--;
                l++;
            } else{
                l++;
                kc--;
            }
        }

        System.out.println(res);
    }
}
