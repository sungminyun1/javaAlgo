package barkingdog.ch13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P10816 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hm = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            if(hm.get(val) == null){
                hm.put(val, 1);
            }else{
                int t = hm.get(val);
                hm.put(val, t + 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int val = Integer.parseInt(st.nextToken());
            if(hm.get(val) == null){
                sb.append(0 + " ");
            }else{
                sb.append(hm.get(val) + " ");
            }
        }
        System.out.println(sb);
    }
}
