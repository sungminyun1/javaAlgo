package barkingdog.ch0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7795 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arrA = new int[N];
            int[] arrB = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arrB[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(run(arrA,arrB));
        }
    }

    public static int run(int[] arrA, int[] arrB) {
        int res = 0;
        Arrays.sort(arrA);
        Arrays.sort(arrB);
        int count = 0;
        int bidx = 0;
        for (int i = 0; i < arrA.length; i++) {
            int now = arrA[i];
            while (bidx < arrB.length && arrB[bidx] < now) {
                count++;
                bidx++;
            }
            res += count;
        }
        return res;
    }
}
