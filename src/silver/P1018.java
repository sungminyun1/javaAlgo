package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1018 {
    public static boolean[][] board;
    public static boolean[][] correctBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];
        correctBoard = new boolean[8][8];

        for(int i = 0; i<N; i++){
            String str = br.readLine();
            for(int j = 0; j<M; j++){
                if(str.charAt(j) == 'W'){
                    board[i][j] = true;
                }else{
                    board[i][j] = false;
                }
            }
        }

        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                boolean token;
                if((i+j)%2 == 0){
                    token = true;
                }else{
                    token = false;
                }
                correctBoard[i][j] = token;
            }
        }

        double minResult = Double.POSITIVE_INFINITY;
        for(int i =0; i<=N-8; i++){
            for(int j = 0; j<=M-8; j++){
                int check = check(i, j);
                minResult = Math.min(minResult, check);
            }
        }
        System.out.println((int)minResult);



    }

    public static int check(int startI,int startJ){
        int correctCase1 = 0;
        int correctCase2 = 0;

        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                boolean caseOne = correctBoard[i][j];
                boolean caseTwo = !correctBoard[i][j];
                if(board[startI + i][startJ + j] != caseOne){
                    correctCase1++;
                }
                if(board[startI + i][startJ + j] != caseTwo){
                    correctCase2++;
                }
            }
        }
        return Math.min(correctCase1,correctCase2);
    }
}
