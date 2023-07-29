package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3190 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] board;
    public static HashMap<Integer,String > change = new HashMap<>();
    public static Queue<Integer[]> snake = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int boardSize = Integer.parseInt(st.nextToken());
        board = new int[boardSize][boardSize];

        st = new StringTokenizer(br.readLine());
        int foodNum = Integer.parseInt(st.nextToken());
        for(int i =0; i<foodNum; i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            board[row-1][col-1] = 1;
        }
        st = new StringTokenizer(br.readLine());
        int changeNum = Integer.parseInt(st.nextToken());
        for(int i =0; i<changeNum; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            change.put(time,dir);
        }
        int[][] dir = {
                {-1,0},
                {0,1},
                {1,0},
                {0,-1},
        };
        int dirNow = 1;
        Integer[] first = {0,0};
        snake.offer(first);
        board[0][0] = 2;
        int headRow = 0;
        int headCol = 0;
        int tailRow = 0;
        int tailCol = 0;
        int time = 0;
        while(true){
            if(change.get(time) != null){
                String nd = change.get(time);
                if(nd.equals("D")){
                    dirNow += 1;
                    if(dirNow > 3) dirNow = 0;
                }else {
                    dirNow -= 1;
                    if(dirNow < 0) dirNow = 3;
                }
            }
            time++;
            headRow += dir[dirNow][0];
            headCol += dir[dirNow][1];

            if(headRow <0 || headRow >= boardSize || headCol <0 || headCol >= boardSize || board[headRow][headCol] == 2){
                break;
            }
            if(board[headRow][headCol] == 0){
                board[tailRow][tailCol] = 0;
                board[headRow][headCol] = 2;
                if(tailRow - 1 > 0 && board[tailRow-1][tailCol] == 2){
                    tailRow -= 1;
                }else if(tailRow +1 <boardSize && board[tailRow+1][tailCol] == 2){
                    tailRow += 1;
                }else if(tailCol -1 > 0 && board[tailRow][tailCol -1] == 2){
                    tailCol -= 1;
                }else if(tailCol +1 < boardSize && board[tailRow][tailCol +1] == 2){
                    tailCol += 1;
                }
            }else {
                board[headRow][headCol] = 2;
            }
        }
        System.out.println(time);
    }
}
