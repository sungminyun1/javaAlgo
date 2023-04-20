package ct;
import java.util.*;

public class P2 {
    public static int[][] Board;
    public static int N;

    static class Robot{
        public int col, row,dir;
        Robot(){
            col =0;
            row =0;
            dir=1;
        }

        public void move(){
            int nextRow = row;
            int nextCol = col;
            switch (dir){
                case 0:
                    nextRow = row -1;
                    break;
                case 1:
                    nextCol = col +1;
                    break;
                case 2:
                    nextRow = row +1;
                    break;
                case 3:
                    nextCol = col -1;
                    break;
            }

            if(nextRow >=0 && nextRow <N && nextCol>=0 && nextCol <N && Board[nextRow][nextCol] == 0){
                row = nextRow;
                col = nextCol;
            }else{
                dir = (dir+1)%4;
            }
        }

        public int getCol() {
            return col;
        }

        public int getRow() {
            return row;
        }


        public int getDir() {
            return dir;
        }
    }

    public static int[] solution(int[][] board, int k){
        int[] answer = new int[2];

        Board = board;
        N = board.length;

        Robot r = new Robot();
        for(int i =0; i<k; i++){
            r.move();
        }
        answer[0] = r.getRow();
        answer[1] = r.getCol();

        return answer;
    }

    public static void main(String[] args){
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(arr3, 25)));

    }
}
