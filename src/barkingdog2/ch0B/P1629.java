package barkingdog2.ch0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1629 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long A,B,C;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        long ans = solve(B);

        System.out.println(ans);
    }

    public static long solve(long b) {
        if(b == 1){
            return A % C;
        }

        long t = solve(b/2);
        long tt = (t * t) % C;
        if(b % 2 == 0){
            return tt;
        }else {
            return tt * A % C;
        }
    }

}
