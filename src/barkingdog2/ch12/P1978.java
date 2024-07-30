package barkingdog2.ch12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1978 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(solve(a)) count++;
        }

        System.out.println(count);
    }

    public static boolean solve(int n){
        if(n < 2) return false;
        if(n < 4) return true;

        for(int i = 2; i < n; i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}
