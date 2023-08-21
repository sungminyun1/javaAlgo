package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P9251 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static HashMap<String, Integer> hm = new HashMap<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String[] sp = s1.split("");
        st = new StringTokenizer(br.readLine());
        String s2 = st.nextToken();
        String[] sp2 = s2.split("");

        int[][] dp = new int[sp.length + 1][sp.length + 1];
        for(int i =1; i<dp.length; i++){
            for(int j = 1; j<dp.length; j++){
                if(sp[i-1].equals(sp2[j-1])){
                    dp[i][j] = dp[i-1][j] +1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[sp.length][sp.length]);
    }
}
