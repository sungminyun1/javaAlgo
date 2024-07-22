package barkingdog2.ch0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11729 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int count = 0;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        solve(N,1,3,2);
        System.out.println(count);
        System.out.println(sb.toString());
    }

    public static void move(int from, int to) {
        count++;
        sb.append(from).append(" ").append(to).append("\n");
    }

    public static void solve(int n, int from, int to, int via){
        if(n == 1 ){
            move(from,to);
            return;
        }

        solve(n-1,from, via, to);
        move(from,to);
        solve(n-1,via, to, from);
    }
}
