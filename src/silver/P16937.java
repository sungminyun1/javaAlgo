package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16937 {
    public static int H,W,N;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] stickers;
    public static int result = 0;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());
        stickers = new int[N][2];

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            stickers[i][0] = Integer.parseInt(st.nextToken());
            stickers[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i =0; i<N-1; i++){
            for(int j = i+1; j<N; j++){
                if(check(i,j)){
                    result = Math.max(result,(stickers[i][0] * stickers[i][1]) + (stickers[j][0] * stickers[j][1]));
                }
            }
        }

        System.out.println(result);
    }

    public static boolean check(int idx1, int idx2){
        int[] sticker1 = stickers[idx1];
        int[] sticker2 = stickers[idx2];

        int tw,th;
        tw = sticker1[0] + sticker2[0];
        th = Math.max(sticker1[1],sticker2[1]);
        if((tw<=W && th<=H) || (th<=W && tw<=H)) return true;

        tw = sticker1[1] + sticker2[0];
        th = Math.max(sticker1[0],sticker2[1]);
        if((tw<=W && th<=H) || (th<=W && tw<=H)) return true;

        tw = sticker1[0] + sticker2[1];
        th = Math.max(sticker1[1],sticker2[0]);
        if((tw<=W && th<=H) || (th<=W && tw<=H)) return true;

        tw = sticker1[1] + sticker2[1];
        th = Math.max(sticker1[0],sticker2[0]);
        if((tw<=W && th<=H) || (th<=W && tw<=H)) return true;


        return false;
    }
}
