package barkingdog.ch09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        Queue<Integer[]> needVisit = new LinkedList<>();

        int targetCount = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                board[i][j] = val;

                if (val == 1) {
                    needVisit.add(new Integer[]{i, j});
                } else if(val == 0){
                    targetCount++;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int day = -1;
        int count = 0;
        while (!needVisit.isEmpty()) {
            int size = needVisit.size();

            for (int i = 0; i < size; i++) {
                Integer[] now = needVisit.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now[0] + dx[j];
                    int ny = now[1] + dy[j];
                    if(nx <0 || ny<0 || nx>=N || ny>=M) continue;
                    if (board[nx][ny] == 0) {
                        needVisit.add(new Integer[]{nx, ny});
                        board[nx][ny] = 1;
                        count++;
                    }
                }
            }
            day++;
        }

        System.out.println(targetCount == count? day : -1);
    }
}
