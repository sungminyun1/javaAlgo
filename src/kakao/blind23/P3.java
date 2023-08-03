package kakao.blind23;
import java.util.*;
public class P3 {


    class Solution {
        public int[] answer = new int[2];
        public int[] DC = {10,20,30,40};
        public int[][] users;
        public int[] emoticons;
        public int[] solution(int[][] users, int[] emoticons) {
            this.users = users;
            this.emoticons = emoticons;
            getDC(0,new int[emoticons.length]);
            return answer;
        }

        public void getDC(int idx, int[] dc){
            if(idx >= dc.length){
                int service = 0;
                int totalCost = 0;
                for(int[] user : users){
                    int userCost = 0;
                    for(int i=0; i<emoticons.length; i++){
                        if(DC[dc[i]] < user[0]) continue;
                        userCost += emoticons[i] * (100 - DC[dc[i]]) / 100;
                    }
                    if(userCost >= user[1]){
                        service += 1;
                        // totalCost += userCost;
                    }else{
                        totalCost += userCost;
                    }
                }
                if(answer[0] < service){
                    answer[0] = service;
                    answer[1] = totalCost;
                }else if(answer[0] == service && answer[1] < totalCost){
                    answer[1] = totalCost;
                }
                return;
            }

            for(int i=0; i<4; i++){
                dc[idx] = i;
                getDC(idx +1, dc);
            }
        }
    }
}
