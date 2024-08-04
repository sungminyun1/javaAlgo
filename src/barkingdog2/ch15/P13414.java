package barkingdog2.ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P13414 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        Map<String,Integer> enrolled = new HashMap<>();

        for (int i = 0; i < L; i++) {
            String student = br.readLine();
            enrolled.put(student, i);
        }
        List<String> queue = enrolled.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K; i++) {
            if(i >= queue.size()) { break;}
            sb.append(queue.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}
