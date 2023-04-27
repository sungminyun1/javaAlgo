package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P16936 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static long[] inputArray;
    public static boolean done = false;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        inputArray = new long[N];
        for(int i =0; i<N; i++){
            inputArray[i] = Long.parseLong(st.nextToken());
        }

        for(int i=0; i<N; i++){
            boolean[] visited = new boolean[N];
            Arrays.fill(visited, false);
            long[] pick = new long[N];
            find(0,i,visited,pick);
            if(done){
                String result = "";
                for(int j=0; j<pick.length; j++){
                    result += pick[j] + " ";
                }
                System.out.println(result);
                return;
            }
        }
    }

    public static void find(int level, int cur, boolean[] visited, long[] pick){
        if (done || level == N -1){
            pick[N - 1] = inputArray[cur];
            done = true;
            return;
        }
        visited[cur] = true;
        pick[level] = inputArray[cur];
        if(inputArray[cur] % 3 == 0){
            int idx = include(inputArray,inputArray[cur] /3);
            if(idx >=0){
                find(level+1,idx,visited,pick);
            }
        }
        int idx2 = include(inputArray,inputArray[cur] *2);
        if(idx2 >=0){
            find(level+1,idx2,visited,pick);
        }
        visited[cur] = false;
    }

    public static int include(long[] arr, long val){
        for(int i =0; i<arr.length; i++){
            if(arr[i] == val ) return i;
        }
        return -1;
    }
}
