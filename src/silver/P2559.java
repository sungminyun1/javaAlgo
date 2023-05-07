package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2559 {
    public static int N,K;
    public static int[] arr;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, sum = 0;
        while (right <= N) {
            if (right - left + 1 < K+1) {
                sum += arr[right++];
            }else{
                answer = Math.max(answer, sum);
                sum += arr[right++];
                sum -= arr[left++];
            }
        }

        System.out.println(answer);
    }
}
