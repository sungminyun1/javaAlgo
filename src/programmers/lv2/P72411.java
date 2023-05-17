package programmers.lv2;
import java.util.*;
public class P72411 {


    class Solution {
        public HashMap<Integer,HashMap<String,Integer>> hm = new HashMap<>();
        public int maxTarget;
        public String[] solution(String[] orders, int[] course) {

            for(int j =0; j<orders.length; j++){
                String order = orders[j];
                char[] t = new char[order.length()];
                for(int i =0; i<order.length(); i++){
                    t[i] = order.charAt(i);
                }
                Arrays.sort(t);
                orders[j] = new String(t);
            }
            for(int i =0; i<course.length; i++){
                hm.put(course[i],new HashMap<String,Integer>());
            }
            maxTarget = course[course.length-1];
            for(int i =0; i<orders.length; i++){
                solve(orders[i],0,0,"");
            }
            ArrayList<String> ta = new ArrayList<>();
            for(int c : course){
                Iterator<Map.Entry<String,Integer>> entry = hm.get(c).entrySet().iterator();
                ArrayList<String> cmax = new ArrayList<>();
                int cm = 1;
                while(entry.hasNext()){
                    Map.Entry<String,Integer> el = entry.next();
                    // System.out.println("" +el.getKey() + " "+ el.getValue());

                    if(el.getValue() > 1){
                        if(el.getValue() == cm){
                            cmax.add(el.getKey());
                        }else if(el.getValue() > cm){
                            cmax.clear();
                            cmax.add(el.getKey());
                            cm = el.getValue();
                        }
                    }
                }
                for(int i =0; i<cmax.size(); i++){
                    ta.add(cmax.get(i));
                }
            }
            String[] answer = new String[ta.size()];
            for(int i =0; i<ta.size(); i++){
                answer[i] = ta.get(i);
            }
            Arrays.sort(answer);
            return answer;
        }
        public void solve(String st, int level,int start, String now){
            if(level > maxTarget){
                return;
            }
            if(hm.get(level) != null){
                if(hm.get(level).get(now) == null){
                    hm.get(level).put(now,1);
                }else{
                    hm.get(level).put(now, hm.get(level).get(now) +1);
                }
            }
            for(int i = start; i<st.length(); i++){
                solve(st,level+1,i+1,now+st.substring(i,i+1));
            }
        }
    }
}
