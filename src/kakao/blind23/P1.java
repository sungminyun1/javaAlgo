package kakao.blind23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P1
{
    public static void main(String[] args) {
        solution(
                "2022.05.19",
                new String[]{"A 6", "B 12", "C 3"},
        new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
    }
    public static int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> result = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(today,".");
        int tYear = Integer.parseInt(st.nextToken());
        int tMonth = Integer.parseInt(st.nextToken());
        int tDay = Integer.parseInt(st.nextToken());

        int elapseT = (tYear - 2000) * 12 * 28 + (tMonth - 1) * 28 + (tDay - 1);

        HashMap<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            st = new StringTokenizer(term);
            termMap.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        int idx = 1;
        for (String privacy : privacies) {
            st = new StringTokenizer(privacy, " ");
            String time = st.nextToken();
            String type = st.nextToken();

            st = new StringTokenizer(time, ".");
            int cYear = Integer.parseInt(st.nextToken());
            int cMonth = Integer.parseInt(st.nextToken());
            int cDay = Integer.parseInt(st.nextToken());

            int elapseC = (cYear - 2000) * 12 * 28 + (cMonth - 1) * 28 + (cDay - 1);;
            int elapse = (elapseT - elapseC) / 28;
            if(termMap.get(type) <= elapse){
                result.add(idx);
            }
            idx++;
        }

        int[] returnVal = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            returnVal[i] = result.get(i);
        }
        return returnVal;
    }
}
