package ct;
import java.util.*;

public class P6 {
    public static int solution(int[][] fruit){
        int answer = 0;
        boolean[] avail = new boolean[fruit.length];
        Arrays.fill(avail,true);

        for(int std1 = 0; std1<fruit.length-1; std1++){
            if(!avail[std1]) continue;

            int std1Min = getMin(fruit[std1]);
            if(!uniqMin(fruit[std1],std1Min)){
                answer += std1Min;
                avail[std1] = false;
                continue;
            }
            for(int std2 = std1+1; std2 < fruit.length; std2++){
                if(!avail[std2]) continue;

                int std2Min = getMin(fruit[std2]);
                if(!uniqMin(fruit[std2],std2Min)){
                    answer += std2Min;
                    avail[std2] = false;
                    continue;
                }

                int std1Idx = getIndex(fruit[std1],std1Min);
                int std2Idx = getIndex(fruit[std2],std2Min);
                if(std1Idx == std2Idx) continue;

                if(fruit[std1][std1Idx] +1 < fruit[std1][std2Idx] -1 && fruit[std2][std2Idx] +1 < fruit[std2][std1Idx]){
                    answer += fruit[std1][std1Idx] +1;
                    answer += fruit[std2][std2Idx] +1;
                    avail[std1] = false;
                    avail[std2] = false;
                    break;
                }
            }
        }

        for(int i =0; i< avail.length; i++){
            if(avail[i]){
                answer += getMin(fruit[i]);
            }
        }

        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }

    public static int getMin(int[] arr){
        int result = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] < result) result = arr[i];
        }
        return result;
    }

    public static int getIndex(int[] arr, int val){
        for(int i =0; i<arr.length; i++){
            if(arr[i] == val) return i;
        }

        return -1;
    }
    public static boolean uniqMin(int[] arr, int min){
        int count = 0;
        for(int i =0; i<arr.length; i++){
            if(arr[i] == min){
                count++;
            }
            if(count > 1){
                return false;
            }
        }
        return true;
    }

}