package barkingdog2.ch16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P7662 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            solve();
        }

    }

    public static void solve() throws IOException {
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        Map<Integer, Integer> minMap = new HashMap<>();
        Map<Integer, Integer> maxMap = new HashMap<>();

        for(int i =0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            if(cmd.equals("I")){
                minHeap.add(x);
                maxHeap.add(x);
            }else if(x == -1){
                remove(minHeap, minMap, maxMap);
            }else {
                remove(maxHeap, maxMap, minMap);
            }
        }
        while(!minHeap.isEmpty()){
            int min = minHeap.peek();
            if(!minMap.containsKey(min)){
                break;
            }else{
                minHeap.poll();
                int val = minMap.get(min);
                val -= 1;
                if(val == 0){
                    minMap.remove(min);
                }else{
                    minMap.put(min, val);
                }
            }
        }

        while(!maxHeap.isEmpty()){
            int max = maxHeap.peek();
            if(!maxMap.containsKey(max)){
                break;
            }else{
                maxHeap.poll();
                int val = maxMap.get(max);
                val -= 1;
                if(val == 0){
                    maxMap.remove(max);
                }else{
                    maxMap.put(max, val);
                }
            }
        }

        if(minHeap.isEmpty()){
            System.out.println("EMPTY");
        }else{
            System.out.println(maxHeap.peek() + " " + minHeap.peek());
        }
    }

    public static void remove(PriorityQueue<Integer> heap, Map<Integer, Integer> myMap, Map<Integer, Integer> opMap) {
        while(!heap.isEmpty()){
            int item = heap.remove();
            if(myMap.containsKey(item)){
                int val = myMap.get(item);
                val -= 1;
                if(val == 0){
                    myMap.remove(item);
                }else{
                    myMap.put(item, val);
                }
            }else{
                opMap.put(item, 1);
                return;
            }
        }
    }
}
