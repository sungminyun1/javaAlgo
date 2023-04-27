package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P16922 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] ROME = {1, 5, 10, 50};
    public static int N, count = 0;
    public static boolean[] check = new boolean[20*50+1];
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        Arrays.fill(check,false);
        find(0,0,0);
        System.out.println(count);
    }

    public static void find(int level,int start, int val){
        if (level == N){
            if(!check[val]){
                count++;
                check[val] = true;
            }
            return;
        }

        for(int i=start; i<4; i++){
            find(level+1,i,val+ROME[i]);
        }
    }
}
