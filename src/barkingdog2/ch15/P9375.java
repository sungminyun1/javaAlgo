package barkingdog2.ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P9375 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for(int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String word = st.nextToken();
                String type = st.nextToken();

                if(!map.containsKey(type)) {
                    map.put(type, 1);
                }
                map.put(type, map.get(type) + 1);
            }
            solve(map);
        }
    }

    public static void solve(HashMap<String,Integer> map) {
        int result = 1;
        for(Integer i : map.values()) {
            result *= i;
        }
        System.out.println(result -1 );
    }
}
