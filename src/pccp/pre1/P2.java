package pccp.pre1;

public class P2 {
    public static void main(String[] args) {
        P2 p2 = new P2();
    }
    public static int answer = 0;
    public static int[][] ab;
    public int solution(int[][] ability) {
        ab = ability;
        run(0, new int[ab[0].length], new boolean[ab.length]);
        return answer;
    }

    public void run(int level, int[] pick, boolean[] check) {
        if(level >= ab[0].length){
            int val = 0;
            for (int i = 0; i < pick.length; i++) {
                val += ab[pick[i]][i];
            }
            answer = Math.max(answer, val);
            return;
        }
        for (int i = 0; i < ab.length; i++) {
            if (!check[i]) {
                check[i] = true;
                pick[level] = i;
                run(level + 1, pick, check);
                check[i] = false;
            }
        }
    }
}
