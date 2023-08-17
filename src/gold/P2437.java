package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P2437 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] arr;
    public static HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        Arrays.sort(arr);

        for(int i =0; i<arr.length; i++){
            if(arr[i] > sum +1) break;
            sum += arr[i];
        }
        System.out.println(sum+1);
    }

}
