package barkingdog.ch0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1629 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static long A,B,C;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        long ans = calc(B);
        System.out.println(ans);
    }

    public static long calc(long val){
        if(val == 1){
            return A % C;
        }
        long t = calc(val / 2) % C;
        long res = t * t % C;
        if (val % 2 == 0) {
            return res;
        }else {
            return res * A % C;
        }
    }
}
