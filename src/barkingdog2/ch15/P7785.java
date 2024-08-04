package barkingdog2.ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P7785 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        Set<String> emp = new HashSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String behavior = st.nextToken();
            if(behavior.equals("enter")) {
                emp.add(name);
            }else {
                emp.remove(name);
            }
        }

        List<String> arr = new ArrayList<>(emp);
        arr.sort(String::compareTo);
        StringBuilder sb = new StringBuilder();
        for(int i = arr.size() - 1; i >= 0; i--) {
            sb.append(arr.get(i)).append("\n");
        }
        System.out.println(sb);

    }
}
