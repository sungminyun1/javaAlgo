package barkingdog.ch0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15650 {
    public static int N, M;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        run(1,0, new int[M]);
        System.out.println(sb);
    }

    public static void run(int start, int level, int[] pick) {
        if(level >= M){
            for (int i : pick) {
                sb.append(i+" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            pick[level] = i;
            run(i + 1, level + 1, pick);
        }
    }
}

