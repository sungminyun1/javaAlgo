package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1806 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, S;
    public static int[] arr;
    public static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, sum = 0;
        while (right <= N) {
            if (sum < S) {
                sum += arr[right];
                right++;
            }else{
                answer = Math.min(answer, right - left);
                sum -= arr[left];
                left++;
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
