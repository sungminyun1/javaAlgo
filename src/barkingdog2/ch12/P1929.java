package barkingdog2.ch12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1929 {
    public static StringBuilder sb = new StringBuilder();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[M + 1];

        for(int i = 2; i <= M; i++) {
            if(check[i]) continue;
            if(i >= N){
                sb.append(i).append("\n");
            }

            int t = 2, ni = i * 2;
            while(ni <= M){
                check[ni] = true;
                t++;
                ni = i * t;
            }
        }
        System.out.println(sb);
    }
}
