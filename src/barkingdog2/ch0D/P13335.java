package barkingdog2.ch0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13335 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> cars = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            cars.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < w; i++) {
            bridge.add(0);
        }

        int curL = 0, time = 0;
        while(!cars.isEmpty()) {
            int bridgeOut = bridge.poll();
            curL -= bridgeOut;

            int nextCar = cars.peek();
            if(curL + nextCar > L){
                bridge.add(0);
            }else{
                bridge.add(nextCar);
                cars.poll();
                curL += nextCar;
            }
            time++;
        }

        System.out.println(time + w);
    }
}
