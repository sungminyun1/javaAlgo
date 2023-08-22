package barkingdog.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P1406 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        LinkedList<Character> list = new LinkedList<>();
        int cur = input.length();
        for(int i =0; i<input.length(); i++){
            list.add(input.charAt(i));
        }

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String now = st.nextToken();
            char cmd = now.charAt(0);
            if(cmd == 'L'){
                cur = Math.max(0,cur-1);
            }else if(cmd == 'D'){
                cur = Math.min(list.size(), cur+1);
            }else if(cmd == 'B'){
                if(cur > 0){
                    list.remove(cur-1);
                    cur--;
                }
            }else if(cmd == 'P'){
                list.add(cur++, st.nextToken().charAt(0));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
