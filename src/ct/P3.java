package ct;
import java.util.*;
public class P3 {
    public static int solution(int[][] board){
        int personRow = 0, personCol = 0, dogRow =0, dogCol=0;
        for(int i =0; i<10; i++){
            for(int j =0; j<10; j++){
                if (board[i][j] == 2){
                    personRow = i;
                    personCol = j;
                }
                else if (board[i][j] == 3){
                    dogRow = i;
                    dogCol= j;
                }
            }
        }

        int personDir = 0;
        int dogDir = 0;
        int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};

        for(int i=0; i<10000; i++){
            int personNextRow = personRow + direction[personDir][0];
            int personNextCol = personCol + direction[personDir][1];
            if(personNextCol >=0 && personNextCol < 10
                    && personNextRow >=0 && personNextRow <10
                    && board[personNextRow][personNextCol] != 1){
                personRow = personNextRow;
                personCol = personNextCol;
            }else{
                personDir = (personDir+1)%4;
            }

            int dogNextRow = dogRow + direction[dogDir][0];
            int dogNextCol = dogCol + direction[dogDir][1];
            if(dogNextCol >=0 && dogNextCol < 10
                    && dogNextRow >=0 && dogNextRow <10 && board[dogNextRow][dogNextCol] != 1){
                dogRow = dogNextRow;
                dogCol = dogNextCol;
            }else{
                dogDir = (dogDir+1)%4;
            }

            if(dogRow == personRow && dogCol == personCol){
                return i+1;
            }
        }

        return 0;
    }
    public static void main(String[] args){
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(solution(arr2));
    }
}

