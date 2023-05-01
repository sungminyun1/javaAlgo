package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16938 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static long L,R,X;
    public static int N,result = 0;
    public static int[] Arr;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Long.parseLong(st.nextToken());
        R = Long.parseLong(st.nextToken());
        X = Long.parseLong(st.nextToken());

        Arr = new int[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i =0; i<N; i++){
            Arr[i] = Integer.parseInt(st.nextToken());
        }

        find(0,0L,1000000000L,0);

        System.out.println(result);
    }

    public static void find(int start, long sum, long min, long max){
        if(sum > R){
            return;
        }
        if(sum >= L && max-min >=X){
            result++;
        }

        for(int i = start; i<N; i++){
            find(i+1,sum+Arr[i],Math.min(min,Arr[i]),Math.max(max,Arr[i]));
        }
    }
}
