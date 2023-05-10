package programmers.lv2;

public class P68645 {
    class Solution {
        public int[] solution(int n) {
            int[] dx = {1,0,-1};
            int[] dy = {0,1,-1};
            int[][] Board = new int[n][n];
            int r =0, c = 0, num = 1, dir = 0;
            int end = (n*n - n)/2 +n;
            while(num <= end){
                Board[r][c] = num++;
                int nr = r + dx[dir];
                int nc = c + dy[dir];
                if(nr >=0 && nr < n && nc >= 0 && nc < n && Board[nr][nc] == 0){
                    r = nr;
                    c = nc;
                }else {
                    dir = (dir+1)%3;
                    r += dx[dir];
                    c += dy[dir];
                }
            }
            int[] answer = new int[end];
            int idx = 0;
            for(int i =0; i<n; i++){
                for(int j = 0; j<i+1; j++){
                    answer[idx++] = Board[i][j];
                }
            }

            return answer;
        }
    }
}
