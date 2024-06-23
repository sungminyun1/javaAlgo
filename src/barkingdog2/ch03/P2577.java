package barkingdog2.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2577 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer A = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Integer B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Integer C = Integer.parseInt(st.nextToken());
        Integer D = A*B*C;

        int[] arr = new int[10];
        while(D > 0){
            arr[D % 10]++;
            D /= 10;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i + "\n");
        }
        System.out.println(sb);
    }
}
