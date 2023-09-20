package barkingdog.ch13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P18870 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] origin = new int[N];
        int[] sorted = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            origin[i] = val;
            sorted[i] = val;
        }

        Arrays.sort(sorted);
        HashMap<Integer, Integer> hm = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < sorted.length; i++) {
            if(hm.get(sorted[i]) == null){
                hm.put(sorted[i], idx);
                idx++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(hm.get(origin[i]) + " ");
        }

        System.out.println(sb);
    }
}
