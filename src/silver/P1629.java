package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1629 {
    public static long A,B,C;
    public static int INF = 2147483647;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        System.out.println(calc(A%C,B));
    }

    public static long calc(long bot, long top){
        if(top == 1) return bot;
        long next = calc(bot,top/2) % C;
        if(top % 2 == 0){
            return (next * next % C);
        }else {
            return (next * next  % C * bot % C);
        }
    }
}
