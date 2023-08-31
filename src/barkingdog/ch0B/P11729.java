package barkingdog.ch0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11729 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int count = 0;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        run(1, 3, N);
        System.out.println(count);
        System.out.println(sb);
    }

    public static void run(int from, int to, int n) {
        if(n< 1) return;
        run(from,6 - from - to, n -1);
        count++;
        sb.append(from + " " + to + "\n");
        run(6 - from - to, to, n -1);
    }
}
