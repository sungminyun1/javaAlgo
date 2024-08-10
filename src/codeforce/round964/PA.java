package codeforce.round964;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PA {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int a = Integer.parseInt(s.substring(0, 1));
            int b = Integer.parseInt(s.substring(1, 2));
            sb.append((a + b)).append("\n");
        }
        System.out.println(sb);
    }
}
