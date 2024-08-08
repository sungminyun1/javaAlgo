package barkingdog2.ch19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1991 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int[][] graph;
    public static StringBuilder F = new StringBuilder(), M = new StringBuilder(), E = new StringBuilder();
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String now = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            if(left.equals(".")){
                graph[toIndex(now)][0] = -1;
            }else{
                graph[toIndex(now)][0] = toIndex(left);
            }

            if(right.equals(".")){
                graph[toIndex(now)][1] = -1;
            }else{
                graph[toIndex(now)][1] = toIndex(right);
            }
        }

        solve(0);
        System.out.println(F);
        System.out.println(M);
        System.out.println(E);
    }

    public static void solve(int now){

        F.append(indexToString(now));
        int left = graph[now][0];
        int right = graph[now][1];
        if(left != -1) solve(left);
        M.append(indexToString(now));
        if(right != -1) solve(right);
        E.append(indexToString(now));
    }

    public static int toIndex(String s) {
        return s.charAt(0) - 'A';
    }

    public static char indexToString(int i) {
        return (char)('A' + i);
    }
}
