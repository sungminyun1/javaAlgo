package barkingdog2.ch0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1074 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N,R,C,SIZE, RESULT;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        SIZE = (int) Math.pow(2, N);

        RESULT = solve(SIZE, 0, 0);

        System.out.println(RESULT);
    }

    public static int solve(int size, int r, int c) {
        if(size == 1){
            return 0;
        }

        int mid = size / 2;
        int blockSize = mid * mid;
        int cr = mid + r, cc = mid + c;

        if(R <cr && C < cc) {
            return solve(mid, r, c);
        } else if (R < cr && C >= cc) {
            return blockSize + solve(mid, r, cc);
        } else if (R >= cr && C < cc) {
            return blockSize * 2 + solve(mid, cr, c);
        } else {
            return blockSize * 3 + solve(mid, cr, cc);
        }
    }
}
