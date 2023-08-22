package barkingdog.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class P1158 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i =1; i<= N; i++){
            arr.add(i);
        }
        int idx = 0;
        while (!arr.isEmpty()) {
            idx = (idx -1 + K) % arr.size();
            ans.add(arr.get(idx));
            arr.remove(idx);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i =0; i<ans.size(); i++){
            sb.append(ans.get(i));
            if (i != ans.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
