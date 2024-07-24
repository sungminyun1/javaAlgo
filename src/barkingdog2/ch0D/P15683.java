package barkingdog2.ch0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15683 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M, RESULT = Integer.MAX_VALUE;
    public static int[][] board;
    public static int[][][] cctv1 = {
            {{1,0}}, {{0,1}}, {{-1,0}}, {{0,-1}},
    };
    public static int[][][] cctv2 = {
            {{-1,0},{1,0}},
            {{0,1},{0,-1}}
    };
    public static int[][][] cctv3 = {
            {{-1,0},{0,1}},
            {{0,1},{1,0}},
            {{1,0},{0,-1}},
            {{0,-1},{-1,0}}
    };
    public static int[][][] cctv4 = {
            {{0,-1},{-1,0},{0,1}},
            {{-1,0},{0,1},{1,0}},
            {{0,1},{1,0},{0,-1}},
            {{1,0},{0,-1},{-1,0}},
    };
    public static int[][][] cctv5 = {
            {{0,-1},{-1,0},{0,1},{1,0}},
    };
    public static ArrayList<int[]> cctvs = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]>0 && board[i][j] < 6){
                    cctvs.add(new int[]{i,j});
                }
            }
        }

        solve(0, new int[cctvs.size()]);

        System.out.println(RESULT);
    }

    public static void solve(int n, int[] selected){
        if(n == selected.length){
            solve2(selected);
            return;
        }

        int[][][] scctv = null;
        int val = board[cctvs.get(n)[0]][cctvs.get(n)[1]];
        if(val == 1) scctv = cctv1;
        else if(val == 2) scctv = cctv2;
        else if(val == 3) scctv = cctv3;
        else if(val == 4) scctv = cctv4;
        else if(val == 5) scctv = cctv5;

        for(int i = 0; i < scctv.length; i++){
            selected[n] = i;
            solve(n + 1, selected);
        }
    }

    public static void solve2(int[] selected){
        for(int i = 0; i < selected.length; i++){
            int[][][] scctv = null;
            int val = board[cctvs.get(i)[0]][cctvs.get(i)[1]];
            if(val == 1) scctv = cctv1;
            else if(val == 2) scctv = cctv2;
            else if(val == 3) scctv = cctv3;
            else if(val == 4) scctv = cctv4;
            else if(val == 5) scctv = cctv5;

            int[][] dir = scctv[selected[i]];

            for(int j = 0; j < dir.length; j++){
                int idx = 1;
                int r = cctvs.get(i)[0], c = cctvs.get(i)[1], dx = dir[j][0], dy = dir[j][1];
                while(true){
                    int nr = r + dx * idx, nc = c + dy * idx;
                    if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == 6) break;
                    if(board[nr][nc] == 0) board[nr][nc] = -1;
                    idx++;
                }
            }
        }

        int count = 0;
        for(int i =0; i<N; i++){
            for(int j =0; j<M; j++){
                if(board[i][j] == 0) count++;
                else if(board[i][j] == -1) board[i][j] = 0;
            }
        }

        RESULT = Math.min(count, RESULT);
    }
}
