package barkingdog2.ch10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9095 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] notes = new int[11];
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        notes[1] = 1; notes[2] = 2; notes[3] = 4;
        for(int i = 4; i< 11; i++){
            notes[i] = notes[i - 1] + notes[i - 2] + notes[i - 3];
        }

        for(int i =0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(notes[N]);
        }
    }
}
