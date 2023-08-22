package barkingdog.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10808 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] input = st.nextToken().split("");
        int[] ans = new int[26];
        for (String now : input) {
            ans[(int)now.charAt(0) - 97]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<ans.length; i++){
            sb.append(ans[i]);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
