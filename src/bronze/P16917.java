package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16917 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int A,B,C,X,Y;

    public static int result = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        if(C*2 < A+B){
            int less = Math.min(X,Y);
            result = (C * 2 * less) + Math.min((A * (X-less)) + (B*(Y-less)),(C*2 * (X-less)) + (C*2*(Y-less)));
        }else {
            result = A*X + B*Y;
        }

        System.out.println(result);
    }

}
