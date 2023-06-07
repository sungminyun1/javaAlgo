package programmers.lv2;
import java.util.*;
public class P43105 {

    class Solution {
        public int solution(int[][] triangle) {
            int[][] c = new int[triangle.length][];
            c[0] = triangle[0];
            for(int i =1; i<triangle.length; i++){
                int[] row = triangle[i];
                c[i] = new int[row.length];
                for(int j =0; j<row.length; j++){
                    int left = j-1;
                    int right = j;
                    if(left >=0){
                        c[i][j] = c[i-1][left] + triangle[i][j];
                    }
                    if(right < c[i-1].length){
                        c[i][j] = Math.max(c[i][j], c[i-1][right] + triangle[i][j]);
                    }
                }
            }
            int answer = 0;
            for(int val : c[c.length-1]){
                answer = Math.max(answer,val);
            }
            return answer;
        }
    }
}
