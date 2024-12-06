package barkingdog2.ch0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16236 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int[][] board;
    private static Shark shark;
    private static int fishCount = 0;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                board[i][j] = val;

                if(val == 9){
                    shark = new Shark(i, j);
                }else if(val >0 && val < 9){
                    fishCount++;
                }
            }
        }

        while(fishCount > 0){
            if(searchFish()){
                fishCount--;
            }else{
                break;
            }
        }

        shark.printAnswer();
    }

    public static boolean searchFish(){
        Queue<Integer[]> nv = new LinkedList<>();
        nv.add(new Integer[]{shark.row, shark.col, 0});
        boolean[][] visited = new boolean[N][N];
        int[] dc = {0, -1, 1, 0};
        int[] dr = {-1, 0, 0, 1};

        int minDist = Integer.MAX_VALUE;
        List<Integer[]> candi = new LinkedList<>();
        boolean searchDone = false;

        while(!nv.isEmpty() && !searchDone){
            Integer[] cur = nv.poll();
            int row = cur[0];
            int col = cur[1];
            int dist = cur[2];

            if(visited[row][col]) continue;
            visited[row][col] = true;
            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
                if(board[nr][nc] == 0 || shark.canMove(board[nr][nc])){
                    nv.add(new Integer[]{nr, nc, dist + 1});
                }else if(shark.canEat(board[nr][nc])){
                    int nd = dist + 1;
                    if (nd <= minDist) {
                        minDist = nd;
                        candi.add(new Integer[]{nr, nc});
                    }else{
                        searchDone = true;
                    }
                }
            }
        }
        if(!candi.isEmpty()){
            Integer[] fish = chooseFish(candi);
            shark.move(fish[0], fish[1],  minDist);
            return true;
        }
        return false;
    }

    public static Integer[] chooseFish(List<Integer[]> candi){
        candi.sort((a,b)->{
            if(a[0] < b[0]){
                return -1;
            }else if(a[0] == b[0] && a[1] < b[1]){
                return -1;
            }
            return 1;
        });
        return candi.get(0);
    }

    private static class Shark {
        public int row;
        public int col;
        public int size = 2;
        public int feed = 0;
        public int time = 0;

        Shark(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public void eat(){
            this.feed++;
            grow();
        }

        public void grow(){
            if(this.feed == this.size){
                this.feed = 0;
                this.size++;
            }
        }

        public void move(int row, int col, int dist){
            board[this.row][this.col] = 0;
            board[row][col] = 9;
            this.time += dist;
            this.row = row;
            this.col = col;
            eat();
        }

        public boolean canEat(int fishSize){
            return this.size > fishSize;
        }

        public boolean canMove(int fishSize){
            return this.size == fishSize;
        }

        public void printAnswer(){
            System.out.println(this.time);
        }
    }
}
