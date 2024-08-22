package barkingdog2.ch0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P11559 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N = 12, M = 6, combo = 0;
    public static char[][] map = new char[N][M];
    public static void main(String[] args) throws IOException {
        for(int i =0; i<N; i++) {
            String input = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        while(round()){
            combo++;
        }

        System.out.println(combo);
    }

    public static boolean round(){
        boolean[][] visited = new boolean[N][M];
        int res = 0;
        for(int i =0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if (map[i][j] != '.' && !visited[i][j]) {
                    if(search(visited, new int[]{i, j})) res++;
                }
            }
        }

        gravity();

        return res > 0;
    }

    public static boolean search(boolean[][] visited, int[] start){
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> q = new LinkedList<>();
        q.add(start);

        boolean res =false;
        char token = map[start[0]][start[1]];
        List<int[]> selected = new ArrayList<>();
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(visited[cur[0]][cur[1]]) continue;

            selected.add(cur);
            visited[cur[0]][cur[1]] = true;
            for(int d = 0; d<4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(map[nx][ny] == token && !visited[nx][ny]) {
                    q.add(new int[] {nx, ny});
                }
            }
        }

        if(selected.size() >= 4) {
            res = true;
            for (int[] now : selected) {
                map[now[0]][now[1]] = '.';
            }
        }

        return res;
    }

    public static void gravity(){
        for(int i = N-1; i>=0; i--) {
            for(int j=0; j<M; j++) {
                char cur = map[i][j];
                if(cur == '.') continue;

                int ni = i;
                while(ni < N - 1){
                    char next = map[ni + 1][j];
                    if(next == '.'){
                        ni++;
                    }else{
                        break;
                    }
                }
                map[i][j] = '.';
                map[ni][j] = cur;
            }
        }
    }
}
