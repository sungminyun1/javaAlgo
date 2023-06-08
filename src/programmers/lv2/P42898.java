package programmers.lv2;

public class P42898 {
    class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int[][] map = new int[m][n];
            map[0][0] = 1;
            for(int[] paddle : puddles){
                map[paddle[0]-1][paddle[1]-1] = -1;
            }
            for(int i =0; i<m; i++){
                for(int j =0; j<n; j++){
                    if(map[i][j] == -1){
                        map[i][j] = 0;
                        continue;
                    };

                    if(i >0 ){
                        map[i][j] += map[i-1][j] % 1000000007;
                    }

                    if(j>0 ){
                        map[i][j] += map[i][j-1] % 1000000007;
                    }
                }
            }
            return map[m-1][n-1] % 1000000007;
        }
    }
}
