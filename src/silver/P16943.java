package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16943 {
    public static int A,B,N;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static String stringA;
    public static boolean[] visited;
    public static int result = -1;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        stringA = ""+A;
        N = stringA.length();
        visited = new boolean[N];

        find(0,  "");

        System.out.println(result);
    }
    public static void find(int level, String sum){
        if(level == N){
            int now = Integer.parseInt(sum);
            if (now < B){
                result = Math.max(result, now);
            }
            return;
        }

        for(int i = 0; i<N; i++){
            if(level == 0 && stringA.charAt(i) == '0') continue;
            if(!visited[i]){
                visited[i] = true;
                find(level+1,sum+stringA.charAt(i));
                visited[i] = false;
            }

        }
    }
}
