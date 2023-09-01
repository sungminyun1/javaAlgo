package barkingdog.ch0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15649 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        run(0, new boolean[N + 1], new int[M]);
        System.out.println(sb);
    }

    public static void run(int level, boolean[] visited, int[] pick){
        if(level >= M){
            for (int i = 0; i < pick.length; i++) {
                sb.append(pick[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                pick[level] = i;
                run(level + 1, visited,pick);
                visited[i] = false;
            }
        }
    }
}
