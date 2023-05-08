package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10986 {
    public static int N,M;
    public static long[] arr;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new long[N + 1];
        long[] count = new long[M];
        for (int i = 1; i <= N; i++) {
            arr[i] = (arr[i-1] + Long.parseLong(st.nextToken())) % M;
            count[(int)arr[i]]++;
        }
        long answer = count[0];
        for (int i = 0; i < M; i++) {
            if(count[i] > 1){
                answer += count[i] * (count[i]-1) / 2;
            }
        }

        System.out.println(answer);
    }
}
