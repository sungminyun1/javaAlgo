package barkingdog.ch13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P18869 {
    public static int N, M;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        List<Integer>[] arrayLists = new ArrayList[M];
        int[][] arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                set.add(val);
                arr[i][j] = val;
            }

            arrayLists[i] = new ArrayList<>(set);
            Collections.sort(arrayLists[i]);
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = Collections.binarySearch(arrayLists[i], arr[i][j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {
            for (int j = i + 1; j < M; j++) {
                if (Arrays.equals(arr[i], arr[j])) {
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }
}
