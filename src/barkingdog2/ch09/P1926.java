package barkingdog2.ch09;

import java.util.*;
import java.io.*;

public class P1926 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] Board;
    public static int result = 0, N, M;
    public static int countRes = 0;
    public static int[][] dir = {
        {1,0},{0,1},{-1,0},{0,-1}
    };
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Board = new int[N][M];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++){
                int t = Integer.parseInt(st.nextToken());
                Board[i][j] = t;
            }
        }

        for(int i =0; i<N; i++){
            for(int j =0; j<M; j++){
                if(Board[i][j] == 1){
                    countRes++;
                    solve(i,j);
                }
            }
        }

        System.out.println(countRes);
        System.out.println(result);
    } 

    public static void solve(int r, int c){
        int count = 0;
        Queue<int[]> nv = new LinkedList<>();
        nv.add(new int[]{r,c});
        while(!nv.isEmpty()){
            int[] now = nv.poll();
            int nr = now[0], nc = now[1];
            if(Board[nr][nc] != 1) continue;
            count++;
            Board[nr][nc] = -1;

            for(int i =0; i<dir.length; i++){
                int fr = nr + dir[i][0];
                int fc = nc + dir[i][1];
                if(fr < 0 || fr >= N || fc < 0 || fc >= M) continue;
                if(Board[fr][fc] == 1){
                    nv.add(new int[]{fr, fc});
                }
            }
        }

        result = Math.max(result, count);
    }
}
