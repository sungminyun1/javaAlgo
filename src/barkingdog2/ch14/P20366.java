package barkingdog2.ch14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P20366 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[] Arr;
    private static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            Arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Arr);
        run(0, 0, new int[4]);

        System.out.println(result);
    }

    private static void run(int cur, int start, int[] arr) {
        if(cur > 3){
            int diff = Math.abs((arr[0] + arr[3]) - (arr[1] + arr[2]));
            result = Math.min(result, diff);
            return;
        }
        for(int i = start; i < N ; i++) {
            arr[cur] = Arr[i];
            run(cur + 1, i + 1, arr);
        }
    }
}
