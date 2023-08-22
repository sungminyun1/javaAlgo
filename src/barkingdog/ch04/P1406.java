package barkingdog.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class P1406 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        String input = st.nextToken();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        LinkedList<Character> list = new LinkedList<>();
        for(int i =0; i<input.length(); i++){
            list.add(input.charAt(i));
        }
        ListIterator<Character> iter = list.listIterator();
        while(iter.hasNext()){
            iter.next();
        }

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String now = st.nextToken();
            char cmd = now.charAt(0);
            if(cmd == 'L'){
                if(iter.hasPrevious()){
                    iter.previous();
                }
            }else if(cmd == 'D'){
                if(iter.hasNext()){
                    iter.next();
                }
            }else if(cmd == 'B'){
                if(iter.hasPrevious()){
                    iter.previous();
                    iter.remove();
                }
            }else if(cmd == 'P'){
                iter.add(st.nextToken().charAt(0));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
