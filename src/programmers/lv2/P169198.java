package programmers.lv2;

// 연습문제 - 당구 연습
public class P169198 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(10,10,3,7, new int[][]{
                {7,7},{2,7},{7,3}
        });

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + " ");
        }
    }




    static class Solution {
        public static int _m,_n;
        public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
            int[] answer = new int[balls.length];
            int[] ball = new int[]{startX, startY};
            _m = m; _n = n;
            for(int i =0; i<balls.length; i++){
                int res = Integer.MAX_VALUE;
                int[] target = balls[i];
                if(upAvail(ball, target)){
                    int w = target[1] - ball[1];
                    int h = ball[0] + target[0];
                    int ta = w * w + h * h;
                    res = Math.min(res, ta);
                }

                if(downAvail(ball, target)){
                    int w = target[1] - ball[1];
                    int h = m - ball[0] + m - target[0];
                    int ta = w * w + h * h;
                    res = Math.min(res, ta);
                }

                if(leftAvail(ball, target)){
                    int h = target[0] - ball[0];
                    int w = target[1] + ball[1];
                    int ta = w * w + h * h;
                    res = Math.min(res, ta);
                }

                if(rightAvail(ball, target)){
                    int h = target[0] - ball[0];
                    int w = n - ball[1] + n - target[1];
                    int ta = w * w + h * h;
                    res = Math.min(res, ta);
                }

                answer[i] = res;
            }

            return answer;
        }

        public boolean upAvail(int[] ball, int[] target){
            if(ball[1] == target[1] && ball[0] > target[0]) return false;
            return true;
        }

        public boolean downAvail(int[] ball, int[] target){
            if(ball[1] == target[1] && ball[0] < target[0]) return false;
            return true;
        }

        public boolean leftAvail(int[] ball, int[] target){
            if(ball[0] == target[0] && ball[1] > target[1]) return false;
            return true;
        }

        public boolean rightAvail(int[] ball, int[] target){
            if(ball[0] == target[0] && ball[1] < target[1]) return false;
            return true;
        }

    }





}
