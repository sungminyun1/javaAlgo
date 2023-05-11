package programmers.lv2;

public class P60057 {
    class Solution {
        public int solution(String s) {
            int answer = s.length();
            int lenMax = s.length()/2;
            for(int len = 1; len <= lenMax; len++){
                String t = "";
                String sub = "";
                String sn = "";
                int count = 1;
                for(int i = 0; i< s.length(); i +=len){
                    int end = i+len > s.length()? s.length():i+len;
                    sn = s.substring(i,end);
                    // System.out.println(sn);
                    if(sub.equals(sn)){
                        count++;
                    }else{
                        if(count >1){
                            t += count;
                        }
                        t+=sub;
                        count = 1;
                        sub = sn;
                    }
                }
                if(count >1){
                    t += count;
                    t+=sub;
                }else{
                    t += sn;
                }

                // System.out.println(t);
                answer = Math.min(answer,t.length());
            }

            return answer;
        }
    }
}
