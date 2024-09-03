package programmers.lv2;

// 연습문제 - 광물 캐기
public class P172927 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.solution(
                new int[]{0, 1, 1},
                new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"}
        );

        System.out.println(res);
    }




    static class Solution {
        int answer = Integer.MAX_VALUE;
        int[] _picks;
        String[] _minerals;
        public int solution(int[] picks, String[] minerals) {
            _picks = picks;
            _minerals = minerals;
            int maxTools = (int)Math.ceil((double)minerals.length / 5);
            int totalTools = 0;
            for (int i : picks) {
                totalTools += i;
            }
            int targetCount = Math.min(maxTools, totalTools);
            solve(new int[targetCount], 0);
            return answer;
        }

        public void solve(int[] choices, int level) {
            if(level == choices.length) {
                answer = Math.min(calc(choices), answer);
                return;
            }

            for (int i = 0; i < 3; i++) {
                if(_picks[i] > 0){
                    choices[level] = i;
                    _picks[i]--;
                    solve(choices, level + 1);
                    _picks[i]++;
                }
            }
        }

        public int calc(int[] choices) {
            int sum = 0;
            int idx = 0;
            for(int i = 0; i < choices.length; i++) {
                int tool = choices[i];
                for (int j = 0; j < 5; j++) {
                    if(idx >= _minerals.length) {
                        return sum;
                    }
                    String mine = _minerals[idx];
                    if(tool == 0){
                        sum++;
                    }else if(tool == 1){
                        if(mine.equals("diamond")){
                            sum += 5;
                        }else{
                            sum++;
                        }
                    }else{
                        if(mine.equals("diamond")){
                            sum += 25;
                        }else if(mine.equals("iron")){
                            sum += 5;
                        }else{
                            sum++;
                        }
                    }
                    idx++;
                }
            }

            return sum;
        }
    }




}
