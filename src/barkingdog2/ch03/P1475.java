package barkingdog2.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1475 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] arr = new int[9];
    public static void main(String[] args) throws IOException {
        String n = br.readLine();

        for(int i = 0; i < n.length(); i++) {
            int t = Integer.parseInt(n.substring(i,i+1));
            if(t == 9) t= 6;
            arr[t]++;
        }

        arr[6] = (arr[6] / 2) + arr[6] % 2;
        Arrays.sort(arr);
        System.out.println(arr[8]);
    }
}
