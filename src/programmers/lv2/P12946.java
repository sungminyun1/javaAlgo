package programmers.lv2;

import java.util.*;

class P12946 {
    public static ArrayList<int[]> seq = new ArrayList<>();
    public int[][] solution(int n) {
        solve(1,3,2,n);
        int[][] answer = new int[seq.size()][2];
        for(int i =0; i<seq.size(); i++){
            answer[i][0] = seq.get(i)[0];
            answer[i][1] = seq.get(i)[1];
        }
        return answer;
    }
    public static void solve(int from, int to, int tmp, int n){
        int[] move = {from,to};

        if(n == 1){
            seq.add(move);
            return;
        }

        solve(from,tmp,to,n-1);
        seq.add(move);
        solve(tmp,to,from,n-1);
    }
}