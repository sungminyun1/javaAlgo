package programmers.lv2;
import java.util.*;
public class P42746 {

    class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            boolean check = false;
            String[] nums = new String[numbers.length];
            for(int i =0; i<numbers.length; i++){
                nums[i] = ""+numbers[i];
                if(numbers[i] != 0) check = true;
            }
            Arrays.sort(nums, new Comparator<String>(){
                @Override
                public int compare(String a, String b){
                    return (b+a).compareTo(a+b);
                }
            });
            for(int i =0; i<nums.length; i++){
                answer += nums[i];
            }
            if(!check) answer = "0";

            return answer;
        }
    }
}
