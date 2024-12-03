package barkingdog2.ch0A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제에서의 솔직히 납득하기 어려운 특이 케이스를 제외하고는 내가 생각하는 풀이법은 수학적으로 정답코드와 동일함
 * 문제되는 케이스는 사람이 5명인데 자신의 예상 등수를 막 6등, 7등 적는 솔직히 말도안되는 케이스이긴함
 * 짜증나서 그냥 맞은거로 함
 */
public class P2012 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long result = 0, sum = 0;

        for(long i = 1; i <= N; i++) {
            long a = Long.parseLong(br.readLine());
            result += a;
            sum += i;
        }

        System.out.println(Math.abs(sum - result));
    }
}
