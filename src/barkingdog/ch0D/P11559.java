package barkingdog.ch0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class P11559 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static char[][] Board = new char[12][6];
    public static int combo = 0;
    public static boolean isDone = true;
    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                Board[i][j] = s.charAt(j);
            }
        }


        while(true){
            isDone = true;
            run();
            if(isDone) break;
            combo++;
        }
        System.out.println(combo);
    }

    public static void run(){
        boolean[][] visited = new boolean[12][6];
        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < 6; j++) {
                if (Board[i][j] != '.' && !visited[i][j]) {
                    DFS(new int[]{i, j}, visited);
                }
            }
        }
        if(!isDone){
            for (int j = 0; j < 6; j++) {
                for (int i = 11; i >= 0; i--) {
                    if (Board[i][j] != '.') {
                        int idx = i;
                        while(true){

                            if(idx == 11){
                                Board[idx][j] = Board[i][j];
                                if(idx != i){
                                    Board[i][j] = '.';
                                }
                                break;
                            }else if(Board[idx +1][j] == '.'){
                                idx++;
                            }else{
                                Board[idx][j] = Board[i][j];
                                if(idx != i){
                                    Board[i][j] = '.';
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public static void DFS(int[] start, boolean[][] visited) {
        ArrayList<int[]> match = new ArrayList<>();
        match.add(start);
        Stack<int[]> nv = new Stack<>();
        nv.push(start);
        visited[start[0]][start[1]] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        char token = Board[start[0]][start[1]];
        while (!nv.isEmpty()) {
            int[] now = nv.pop();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dx[i];
                int nc = now[1] + dy[i];
                if(nr < 0 || nr >= 12 || nc < 0 || nc >= 6 || visited[nr][nc] || Board[nr][nc] != token) continue;
                nv.push(new int[]{nr, nc});
                visited[nr][nc] = true;
                match.add(new int[]{nr, nc});
            }
        }

        if(match.size() >= 4){
            isDone = false;
            for (int[] loc : match) {
                Board[loc[0]][loc[1]] = '.';
            }
        }
    }
}
