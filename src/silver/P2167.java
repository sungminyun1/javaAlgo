package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2167 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M;
    public static int[][] Board;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Board = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                Board[i][j] = Board[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }
        int q = Integer.parseInt(br.readLine());
        for (int k = 0; k < q; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int res = 0;
            for (int it = i; it <= x; it++) {
                res += Board[it][y] - Board[it][j-1];
            }
            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }
}
