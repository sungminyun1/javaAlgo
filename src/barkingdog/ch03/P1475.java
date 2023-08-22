package barkingdog.ch03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1475 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int[] nums = new int[9];
        int ans = 1;
        newNums(nums);
        while(input > 0){
            int now = input %10;
            if(now == 9) now = 6;
            if(nums[now] <= 0){
                ans++;
                newNums(nums);
            }
            nums[now]--;
            input /=10;
        }
        System.out.println(ans);
    }
    public static void newNums(int[] nums){
        for(int i =0; i<nums.length; i++){
            if(i == 6) nums[i]++;
            nums[i]++;
        }
    }
}
