package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15686 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Integer[]> house = new ArrayList<>();
    public static ArrayList<Integer[]> ch = new ArrayList<>();
    public static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                int now = Integer.parseInt(st.nextToken());
                if(now == 1){
                    house.add(new Integer[]{i, j});
                }
                else if(now == 2){
                    ch.add(new Integer[]{i, j});
                }
            }
        }
        getCase(0,0, new int[M][2]);
        System.out.println(ans);
    }

    public static void getCase(int level, int start, int[][] choice){
        if(level >= choice.length ){
            calcRes(choice);
            return;

        }
        for(int i = start; i<ch.size(); i++){
            choice[level][0] = ch.get(i)[0];
            choice[level][1] = ch.get(i)[1];
            getCase(level +1, i+1,choice);
        }
    }

    public static void calcRes(int[][] choice) {
        int t = 0;
        for (Integer[] h : house) {
            int min = 200;
            for (int[] ch : choice) {
                int dist = Math.abs(h[0] - ch[0]) + Math.abs(h[1] - ch[1]);
                min = Math.min(min, dist);
            }
            t += min;
        }
        ans = Math.min(t, ans);
    }
}
