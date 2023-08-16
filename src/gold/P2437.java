package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P2437 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            arr.add(Integer.parseInt(st.nextToken()));
        }
        getCase(0,0);
        int val = 1;
        while(true){
            if(!hs.contains(val)){
                System.out.println(val);
                return;
            }
            val++;
        }
    }
    static void getCase(int start, int now){
        if (start >= arr.size()) {
            return;
        }
        for(int i = start; i< arr.size(); i++){
            int val = now + arr.get(i);
            hs.add(val);
            getCase(i+1,val);
        }
    }
}
