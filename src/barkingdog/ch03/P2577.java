package barkingdog.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2577 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int num = A*B*C;

        int[] ans = new int[10];
        while (num > 0) {
            int now = num %10;
            ans[now]++;
            num /= 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : ans) {
            sb.append(i);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
