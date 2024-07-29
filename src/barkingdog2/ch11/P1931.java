package barkingdog2.ch11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1931 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static int[][] meetings;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        meetings = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int count = 0;
        int curTime = 0;
        for(int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            if(start >= curTime){
                count++;
                curTime = end;
            }
        }

        System.out.println(count);
    }
}
