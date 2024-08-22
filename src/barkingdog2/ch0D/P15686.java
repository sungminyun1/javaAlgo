package barkingdog2.ch0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P15686 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,M, ans = Integer.MAX_VALUE;
    public static List<Integer[]> houses = new ArrayList<>();
    public static List<Integer[]> chickens = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int t = Integer.parseInt(st.nextToken());
                if(t == 1){
                    houses.add(new Integer[]{i,j});
                }else if(t == 2){
                    chickens.add(new Integer[]{i,j});
                }
            }
        }

        search(new ArrayList<>(), 0);

        System.out.println(ans);
    }

    public static void search(List<Integer> choose, int start) {
        if(choose.size() == M){
            int houseSum = 0;
            for(Integer[] house: houses){
                int houseMin = Integer.MAX_VALUE;
                for(int ch: choose){
                    Integer[] chicken = chickens.get(ch);
                    int dist = Math.abs(house[0]- chicken[0]) + Math.abs(house[1]- chicken[1]);
                    houseMin = Math.min(houseMin, dist);
                }
                houseSum += houseMin;
            }
            ans = Math.min(ans, houseSum);
            return;
        }

        for(int i =start; i<chickens.size(); i++){
            choose.add(i);
            search(choose, i + 1);
            choose.remove(choose.size() - 1);
        }
    }
}
