package barkingdog.ch0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P15686 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] Board;
    public static List<int[]> houses = new ArrayList<>();
    public static List<int[]> chickens = new ArrayList<>();
    public static int N,M,ANS = 50000;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                Board[i][j] = val;
                if(val == 1){
                    houses.add(new int[]{i, j});
                }else if(val == 2){
                    chickens.add(new int[]{i, j});
                }
            }
        }
        pickCh(0,0,new int[M]);
        System.out.println(ANS);
    }

    public static void pickCh(int level, int start, int[] pick){
        if (level >= pick.length) {
            calc(pick);
            return;
        }
        for (int i = start; i < chickens.size(); i++) {
            pick[level] = i;
            pickCh(level +1, i + 1, pick);
        }
    }

    public static void calc(int[] pick) {
        int[][] ch = new int[N][N];
        for (int i : pick) {
            int[] loc = chickens.get(i);
            ch[loc[0]][loc[1]] = 2;
        }
        int sum = 0;
        for (int[] start : houses) {
            sum += BFS(start, ch);
        }
        ANS = Math.min(ANS, sum);
    }

    public static int BFS(int[] start, int[][] ch){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int[][] dist = new int[N][N];
        Queue<int[]> nv = new LinkedList<>();
        nv.add(start);
        dist[start[0]][start[1]] = 1;
        while (!nv.isEmpty()) {
            int[] now = nv.poll();

            if(ch[now[0]][now[1]] == 2) return dist[now[0]][now[1]] -1 ;

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dx[i];
                int nc = now[1] + dy[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || dist[nr][nc] > 0) continue;
                dist[nr][nc] = dist[now[0]][now[1]] + 1;
                nv.add(new int[]{nr, nc});
            }
        }
        return 0;
    }
}
