package barkingdog.ch0C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9663 {
    public static int N;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int ans = 0;
    public static boolean[] v1 = new boolean[40];
    public static boolean[] v2 = new boolean[40];
    public static boolean[] v3 = new boolean[40];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        run(0);
        System.out.println(ans);
    }

    public static void run(int cur){
        if(cur >= N){
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            int c1 = i; // 같은 행 또는 열에 있는거 체크
            int c2 = cur + i; // 우측 대각선 확인, [0,0] 과 [1,-1], [-1,1] 처럼 우측 대각선에 있다면 두 합이 같음
            int c3 = cur - i + N - 1; // 좌측 대각선 확인, [0,0], [1,1], [-1,-1] 처럼 좌측 대각선에 있다면 두 차가 같음. 음수가 될수 있기에 N -1 을 더해주어 넉넉하게 계산
            if(v1[c1] || v2[c2] || v3[c3]) continue;
            v1[c1] = true;
            v2[c2] = true;
            v3[c3] = true;
            run(cur+1);
            v1[c1] = false;
            v2[c2] = false;
            v3[c3] = false;
        }
    }


}
