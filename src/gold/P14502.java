package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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


    }
}
