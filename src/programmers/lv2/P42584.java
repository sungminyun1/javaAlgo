package programmers.lv2;
import java.util.*;
public class P42584 {


    class Solution {
        public int[] solution(int[] prices) {
            Stack<Integer> st = new Stack<>();
            int[] answer = new int[prices.length];
            for(int i =0; i<prices.length; i++){
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    while(!st.isEmpty()){
                        int top = st.peek();
                        if(prices[top] <= prices[i]){
                            break;
                        }
                        st.pop();
                        answer[top] = i - top;
                    }
                    st.push(i);
                }
            }
            while(!st.isEmpty()){
                int v = st.pop();
                answer[v] = answer.length -1 - v;
            }

            return answer;
        }
    }
}
