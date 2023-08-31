package barkingdog.ch0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class p1074 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,R,C;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int res = run(N, R, C);
        System.out.println(res);
    }

    public static int run(int n, int r, int c){
        if(n <= 1){
            return r*2 + c;
        }
        int center = (int)Math.pow(2,n - 1);
        int val = 0,nr = 0,nc = 0;
        if(r < center && c < center){
            val = 0; nr =r; nc = c;
        } else if(r < center && c >= center){
            val = center * center; nr = r; nc = c - center;
        } else if(r >= center && c < center){
            val = center * center * 2; nr = r - center; nc = c;
        } else if(r >= center && c >= center) {
            val = center * center * 3; nr = r - center; nc = c - center;
        }

        return val + run(n-1, nr, nc);
    }
}
