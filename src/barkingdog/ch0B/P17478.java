package barkingdog.ch0B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17478 {
    public static int N;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        run(0);
        System.out.println(sb);
    }

    public static void run(int count){
        if(count > N) return;
        ask(count);
        ans(count);
        run(count + 1);
        end(count);
    }

    public static void ask(int count) {
        appendPrefix(count);
        sb.append("\"재귀함수가 뭔가요?\"\n");
    }

    public static void ans(int count){
        if(count == N){
            appendPrefix(count);
            sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
        }else {
            appendPrefix(count);
            sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            appendPrefix(count);
            sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            appendPrefix(count);
            sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        }
    }

    public static void end(int count) {
        appendPrefix(count);
        sb.append("라고 답변하였지.\n");
    }

    public static void appendPrefix(int count){
        for (int i = 0; i < count; i++) {
            sb.append("____");
        }
    }
}
