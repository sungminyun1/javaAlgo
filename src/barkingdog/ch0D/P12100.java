package barkingdog.ch0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12100 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] BOARD;
    public static int N;
    public static int ANS = 0;
    public static int LEFT = 0, RIGHT = 1, UP = 2, DOWN = 3;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        BOARD = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                BOARD[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        getCase(0,new int[5]);
//        moveUp();
//        moveUp();
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(Board[i][j] + " ");
//            }
//            System.out.println("");
//        }
        System.out.println(ANS);
    }

    public static void getCase(int level, int[] pick){
        if(level >= pick.length){
            int[][] cloneBoard = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cloneBoard[i][j] = BOARD[i][j];
                }
            }
            for (int dir : pick) {
                if(dir == LEFT){
                    cloneBoard = moveLeft(cloneBoard);
                }else if(dir == RIGHT){
                    cloneBoard = moveRight(cloneBoard);
                }else if(dir == UP){
                    cloneBoard = moveUp(cloneBoard);
                }else if(dir == DOWN){
                    cloneBoard = moveDown(cloneBoard);
                }
            }

            for (int i = 0; i < N; i++) {
                for(int j : cloneBoard[i]){
                    ANS = Math.max(ANS, j);
                }
            }

            return;
        }
        for (int i = 0; i < 4; i++) {
            pick[level] = i;
            getCase(level +1, pick);
        }
    }

    public static int[][] moveUp(int[][] Board){
        boolean[][] mergeCheck = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(Board[j][i] > 0){
                    int idx = j;
                    while(true){
                        if(idx == 0){
                            Board[idx][i] = Board[j][i];
                            if(idx != j){
                                Board[j][i] = 0;
                            }
                            break;
                        }
                        if(Board[idx-1][i] == 0){
                            idx--;
                        }else if(Board[idx-1][i] == Board[j][i] && !mergeCheck[idx-1][i]){
                            Board[idx-1][i] *= 2;
                            mergeCheck[idx-1][i] = true;
                            Board[j][i] = 0;
                            break;
                        }else{
                            Board[idx][i] = Board[j][i];
                            if(idx != j){
                                Board[j][i] = 0;
                            }
                            break;
                        }
                    }
                }
            }
        }
        return Board;
    }

    public static int[][] moveDown(int[][] Board){
        boolean[][] mergeCheck = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = N-1; j >= 0; j--) {
                if(Board[j][i] > 0){
                    int idx = j;
                    while(true){
                        if(idx == N-1){
                            Board[idx][i] = Board[j][i];
                            if(idx != j){
                                Board[j][i] = 0;
                            }
                            break;
                        }
                        if(Board[idx+1][i] == 0){
                            idx++;
                        }else if(Board[idx+1][i] == Board[j][i] && !mergeCheck[idx+1][i]){
                            Board[idx+1][i] *= 2;
                            mergeCheck[idx+1][i] = true;
                            Board[j][i] = 0;
                            break;
                        }else{
                            Board[idx][i] = Board[j][i];
                            if(idx != j){
                                Board[j][i] = 0;
                            }
                            break;
                        }
                    }
                }
            }
        }
        return Board;
    }

    public static int[][] moveRight(int[][] Board){
        boolean[][] mergeCheck = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            int[] arr = Board[i];
            for (int j = N-1; j >= 0; j--) {
                if(arr[j] > 0){
                    int idx = j;
                    while(true){
                        if(idx == N-1){
                            arr[idx] = arr[j];
                            if(idx != j){
                                arr[j] = 0;
                            }
                            break;
                        }
                        if(arr[idx+1] == 0){
                            idx++;
                        }else if(arr[idx+1] == arr[j] && !mergeCheck[i][idx+1]){
                            arr[idx+1] *= 2;
                            mergeCheck[i][idx+1] = true;
                            arr[j] = 0;
                            break;
                        }else{
                            arr[idx] = arr[j];
                            if(idx != j){
                                arr[j] = 0;
                            }
                            break;
                        }
                    }
                }
            }
        }
        return Board;
    }

    public static int[][] moveLeft(int[][] Board){
        boolean[][] mergeCheck = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            int[] arr = Board[i];
            for (int j = 0; j < N; j++) {
                if(arr[j] > 0){
                    int idx = j;
                    while(true){
                        if(idx == 0){
                            arr[idx] = arr[j];
                            if(idx != j){
                                arr[j] = 0;
                            }
                            break;
                        }
                        if(arr[idx-1] == 0){
                            idx--;
                        }else if(arr[idx-1] == arr[j] && !mergeCheck[i][idx-1]){
                            arr[idx-1] *= 2;
                            mergeCheck[i][idx-1] = true;
                            arr[j] = 0;
                            break;
                        }else{
                            arr[idx] = arr[j];
                            if(idx != j){
                                arr[j] = 0;
                            }
                            break;
                        }
                    }
                }
            }
        }
        return Board;
    }
}
