package barkingdog.ch08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10799 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String input = br.readLine();

        int bars = 0;
        int answer = 0;
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if (now == '(') {
                if(input.charAt(i+1) == ')'){
                    answer += bars;
                    i++;
                }else{
                    answer++;
                    bars++;
                }
            } else {
                bars--;
            }
        }
        System.out.println(answer);
    }
}
