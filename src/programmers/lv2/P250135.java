package programmers.lv2;

// PCCP 기출문제 3번. 아날로그 시계
public class P250135 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.solution(0, 5, 30, 0, 7, 0);
        System.out.println(res);
    }

    // 60 * 60 * 12 = 43200
    static class Solution {
        public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
            int answer = 0;

            int startSecond = h1 * 60 * 60 + m1 * 60 + s1;
            int endSecond = h2 * 60 * 60 + m2 * 60 + s2;
            int totalSecond = endSecond - startSecond;
            double curHourPosition = (double) startSecond / 43200;
            double curMinPosition = (double) m1 / 3600;
            double curSecPosition = (double) s1 / 60;

            for(int i =0; i<totalSecond; i++) {
                if(curHourPosition == curMinPosition && curHourPosition == curSecPosition) {
                    answer++;
                }else if(curHourPosition == curSecPosition){
                    answer++;
                }else if(curMinPosition == curSecPosition){
                    answer++;
                }
                curHourPosition += 1.0 / 43200;
                curMinPosition += 1.0 / 3600;
                curSecPosition += 1.0 / 60;
            }

            return answer;
        }
    }




}
