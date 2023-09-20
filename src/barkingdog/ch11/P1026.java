package barkingdog.ch11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1026 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Integer[] arrA = new Integer[N];
        Integer[] arrB = new Integer[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB, (a, b) -> b - a);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += arrA[i] * arrB[i];
        }
        System.out.println(sum);
    }
}
