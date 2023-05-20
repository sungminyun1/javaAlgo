package programmers.lv2;

public class P71878 {
    class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;
            long l = 0, r = (long)times[times.length-1] * n;
            while(l <= r){
                long m = (l+r)/2;
                long sum = 0;
                for(int time : times){
                    sum += m / time;
                }
                if(sum >= n){
                    r = m-1;
                }else{
                    l = m+1;
                }
            }

            return l;
        }
    }
}
