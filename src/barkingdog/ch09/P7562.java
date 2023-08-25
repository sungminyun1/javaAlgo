package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer[] start = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            Integer[] dest = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            solve(N,start,dest);
        }
        System.out.println(sb);
    }

    public static void solve(int N, Integer[] start, Integer[] dest) {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = -1;
            }
        }
        Queue<Integer[]> nv = new LinkedList<>();
        dist[start[0]][start[1]] = 0;
        nv.add(start);
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        while (!nv.isEmpty()) {
            Integer[] now = nv.poll();
            if (now[0] == dest[0] && now[1] == dest[1]) {
                sb.append(dist[now[0]][now[1]]);
                sb.append("\n");
                return;
            }
            for (int i = 0; i < dx.length; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N || dist[nx][ny] >= 0) continue;
                dist[nx][ny] = dist[now[0]][now[1]] + 1;
                nv.add(new Integer[]{nx, ny});
            }
        }
    }
}
