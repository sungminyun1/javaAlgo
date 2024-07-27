package barkingdog2.ch0F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class P1431 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int N;
    public static String[] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }
                int o1Sum = 0, o2Sum = 0;
                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) < 'A'){
                        o1Sum += Integer.parseInt(o1.charAt(i)+"");
                    }

                    if (o2.charAt(i) < 'A'){
                        o2Sum += Integer.parseInt(o2.charAt(i)+"");
                    }
                }

                if(o1Sum != o2Sum){
                    return o1Sum - o2Sum;
                }

                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}
