package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16924 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M;
    public static boolean[][] needVisit;
    public static char[][] Board;
    public static ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        needVisit = new boolean[N][M];
        Board = new char[N][M];

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j =0; j<M; j++){
                Board[i][j] = line.charAt(j);
                if(line.charAt(j) == '*'){
                    needVisit[i][j] = true;
                }else{
                    needVisit[i][j] = false;
                }
            }
        }

        for(int i =0; i<N; i++){
            for(int j=0; j<M; j++){
                if(Board[i][j] == '*'){
                    int availSize = getAvailCrossSize(i, j);
                    if(availSize > 0){
                        ArrayList<Integer> res = new ArrayList<>();
                        res.add(i+1);
                        res.add(j+1);
                        res.add(availSize);
                        result.add(res);
                        needVisit[i][j] = false;
                        for(int len = 1; len <= availSize; len++){
                            needVisit[i-len][j] = false;
                            needVisit[i+len][j] = false;
                            needVisit[i][j -len] = false;
                            needVisit[i][j + len] = false;
                        }
                    }
                }
            }
        }

        for(int i =0; i<N; i++){
            for(int j =0; j<M; j++){
                if(needVisit[i][j]){
                    System.out.println(-1);
                    return;
                }
            }
        }

        String resString = "";
        resString += result.size() + "\n";
        for (ArrayList<Integer> res : result) {
            for (Integer re : res) {
                resString += re + " ";
            }
            resString += "\n";
        }
        System.out.println(resString);

    }

    public static int getAvailCrossSize(int i, int j){
        int result = 0;
        int len = 0;
        while(true){
            len++;
            if(i-len < 0 || Board[i-len][j] == '.') break;
            if(i+len >= N || Board[i+len][j] == '.') break;
            if(j-len < 0 || Board[i][j-len] == '.') break;
            if(j+len >= M || Board[i][j+len] == '.') break;
            result++;
        }
        return result;
    }
}
