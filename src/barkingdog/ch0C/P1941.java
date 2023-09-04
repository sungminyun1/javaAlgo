package barkingdog.ch0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1941 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static char[][] board = new char[5][5];
    public static boolean[][] visited = new boolean[5][5];
    public static int[] dx = {1, 0};
    public static int[] dy = {0, 1};
    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            String st = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = st.charAt(j);
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int tc = 0;
                if(board[i][j] == 'S') tc = 1;
                visited[i][j] = true;
                run(0, tc, i, j);
                visited[i][j] = false;
            }
        }
        System.out.println(ans);
    }

    public static void run(int count, int sCount, int r, int c) {
        if (count >= 7) {
            if(sCount >= 4) ans++;
            return;
        }

        for (int i = 0; i < dx.length; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || visited[nr][nc]) continue;
            visited[nr][nc] = true;
            int tc = sCount;
            if(board[nr][nc] == 'S') tc = sCount + 1;
            run(count + 1, tc, nr, nr);
            visited[nr][nc] = false;
        }
    }
}
