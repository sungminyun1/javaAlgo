package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14502 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M;
    public static int[][] Board;
    public static ArrayList<ArrayList<Integer>> avail = new ArrayList<>();
    public static ArrayList<ArrayList<Integer>> virus = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                Board[i][j] = Integer.parseInt(st.nextToken());
                if (Board[i][j] == 0) {
                    ArrayList<Integer> t =new ArrayList<>();
                    t.add(i);
                    t.add(j);
                    avail.add(t);
                }else if(Board[i][j] == 2){
                    ArrayList<Integer> t =new ArrayList<>();
                    t.add(i);
                    t.add(j);
                    virus.add(t);
                }
            }
        }

        for(int i =0; i<avail.size() -2; i++){
            for (int j = i + 1; j < avail.size() - 1; j++) {
                for (int k = j + 1; k < avail.size(); k++) {
                    int[][] tBoard = new int[N][];
                    for(int m =0; m<N; m++){
                        tBoard[m] = Board[m].clone();
                    }
                    tBoard[avail.get(i).get(0)][avail.get(i).get(1)] = 1;
                    tBoard[avail.get(j).get(0)][avail.get(j).get(1)] = 1;
                    tBoard[avail.get(k).get(0)][avail.get(k).get(1)] = 1;
                    spread(tBoard);
                }
            }
        }

    }

    public static void spread(int[][] board){
        System.out.println("hi");
    }
}
