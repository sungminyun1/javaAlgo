package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11660 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M;
    public static int[][] Board;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if(j > 0){
                    Board[i][j] = Board[i][j - 1] + Integer.parseInt(st.nextToken());
                }else {
                    Board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int res = calc(x1 - 1, y1 - 1, x2 - 1, y2 - 1);
            sb.append(res).append('\n');
        }
        System.out.println(sb);
    }

    public static int calc(int x1, int y1, int x2, int y2) {
        int res = 0;

        for(int x = x1; x<= x2; x++){
            if (y1 > 0) {
                res += Board[x][y2] - Board[x][y1 - 1];
            }else{
                res += Board[x][y2];
            }
        }
        return res;
    }
}
