package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//answer[now-1] = (char)(64+student);
public class P16968 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int result = 0;
    public static String input;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(),"");
        input = st.nextToken();
        find(0,-1);
        System.out.println(result);
    }

    public static void find(int level, int prev){
        if(level == input.length()){
            result++;
            return;
        }

        if(input.charAt(level) == 'd'){
            for(int i =0; i<10; i++){
                if(i != prev){
                    find(level+1,i);
                }
            }
        }else{
            for(int i = 10; i<36; i++){
                if(i!=prev){
                    find(level+1,i);
                }
            }
        }
    }
}
