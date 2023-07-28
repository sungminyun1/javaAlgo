package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P10773 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        int count = Integer.parseInt(st.nextToken());
        for(int i =0; i<count; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st2.nextToken());
            if(now == 0 && !stack.empty()){
                stack.pop();
            }else {
                stack.push(now);
            }
        }
        System.out.println(stack);
        while(!stack.empty()){
            int val = stack.pop();
            result += val;
        }
        System.out.println(result);
    }
}
