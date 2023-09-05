package barkingdog.ch0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P1941 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static char[][] board = new char[5][5];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            String st = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = st.charAt(j);
            }
        }
        find(0, 0, new int[7][2]);

        System.out.println(ans);
    }

    public static void find(int start, int level, int[][] pick) {
        if(level >= 7){
            bfs(pick);
            return;
        }
        for (int i = start; i < 25; i++) {
            pick[level][0] = i / 5;
            pick[level][1] = i % 5;
            find(i + 1, level + 1, pick);
        }
    }

    public static void bfs(int[][] pick) {
        int sCount = 0;
        int[][] t = new int[5][5];
        for (int[] p : pick) {
            int r = p[0];
            int c = p[1];
            if (board[r][c] == 'S') {
                sCount++;
            }
            t[r][c] = 1;
        }

        if(sCount < 4) return;

        Queue<Integer[]> nv = new LinkedList<>();
        nv.add(new Integer[]{pick[0][0], pick[0][1]});
        t[pick[0][0]][pick[0][1]] = 0;
        int count = 1;
        while (!nv.isEmpty()) {
            Integer[] now = nv.poll();
            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dx[i];
                int nc = now[1] + dy[i];
                if(nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || t[nr][nc] == 0) continue;
                t[nr][nc] = 0;
                count++;
                nv.add(new Integer[]{nr, nc});
            }
        }

        if(count == 7) ans++;
  }
}
