package barkingdog.ch0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P18809 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M,G,R;
    public static int[][] Board;
    public static int Ans = 0;
    public static ArrayList<int[]> availList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                Board[i][j] = val;
                if(val == 2){
                    availList.add(new int[]{i, j});
                }
            }
        }
        searchCase(0,0,0,new char[availList.size()]);
        System.out.println(Ans);
    }

    public static void searchCase(int level, int usedG, int usedR, char[] pick){
        if(level >= pick.length){
            BFS(pick);
            return;
        }
        if(usedG < G){
            pick[level] = 'G';
            searchCase(level+1,usedG+1,usedR,pick);
        }
        if(usedR < R){
            pick[level] = 'R';
            searchCase(level+1,usedG,usedR+1,pick);
        }
        if (pick.length - level > R - usedR + G - usedG) {
            pick[level] = 'E';
            searchCase(level+1,usedG,usedR,pick);
        }
    }

    public static void BFS(char[] pick){
        int[][] check = new int[N][M];
        Queue<int[]> nv = new LinkedList<>();
        for (int i = 0; i < pick.length; i++) {
            int[] now = availList.get(i);
            if(pick[i] == 'G'){
                check[now[0]][now[1]] = 1;
                nv.add(now);
            }
            else if(pick[i] == 'R'){
                check[now[0]][now[1]] = -1;
                nv.add(now);
            }
        }

        int count = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!nv.isEmpty()) {
            int[] now = nv.poll();
            int valNow = check[now[0]][now[1]];
            int nextVal = valNow > 0 ? valNow +1 : valNow-1;
            if(valNow == 100_000) continue;

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dx[i];
                int nc = now[1] + dy[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= M || Board[nr][nc] == 0) continue;
                if(check[nr][nc] == 0){
                    if(valNow < 0){
                        check[nr][nc] = valNow - 1;
                    }else{
                        check[nr][nc] = valNow + 1;
                    }
                    nv.add(new int[]{nr, nc});
                } else if (check[nr][nc] == -(nextVal)) {
                    count++;
                    check[nr][nc] = 100_000;
                }
            }
        }

        Ans = Math.max(Ans, count);
    }
}
