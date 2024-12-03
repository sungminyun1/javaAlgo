package barkingdog2.ch0A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2012 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long result = 0, sum = 0;

        for(long i = 1; i <= N; i++) {
            long a = Long.parseLong(br.readLine());
            result += a;
            sum += i;
        }

        System.out.println(Math.abs(sum - result));
    }
}
