package barkingdog2.ch0D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14891 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] gears = new int[5][8];
    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 5; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j<8; j++){
                gears[i][j] = Integer.parseInt(input[j]);
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            solve(g, d);
        }

        int result = calc();

        System.out.println(result);
    }

    public static void solve(int gear, int dir) {
        int[] dirs = new int[5];
        boolean[] visited = new boolean[5];
        Queue<Integer[]> nv = new LinkedList<>();
        nv.add(new Integer[]{gear, 0});
        while(!nv.isEmpty()){
            Integer[] poll = nv.poll();
            int now = poll[0];
            int before = poll[1];

            if(visited[now]) continue;
            visited[now] = true;
            if(before == 0){
                dirs[now] = dir;
            }else{
                int nowDir = calcDir(dirs, now, before);
                dirs[now] = nowDir;
            }
            if(dirs[now] != 0){
                int l = now - 1, r = now + 1;
                if(l > 0 && !visited[l]) nv.add(new Integer[]{l,now});
                if(r < 5 && !visited[r]) nv.add(new Integer[]{r,now});
            }
        }

        rotate(dirs);
    }


    public static int calcDir(int[] dirs, int now, int before){
        int R = 2, L = 6;

        // 왼쪽에서 오른쪽
        if(before < now){
            if(gears[before][R] == gears[now][L]) return 0;
        }else{ //오른쪽에서 왼쪽
            if(gears[before][L] == gears[now][R]) return 0;
        }
        return -dirs[before];
    }

    public static void rotate(int[] dirs){
        for(int i = 1; i<dirs.length; i++){
            if(dirs[i] == 1) rotateRight(i);
            else if(dirs[i] == -1) rotateLeft(i);
        }
    }

    public static void rotateRight(int gear){
        int[] now = gears[gear];
        int t = now[7];
        for(int i = 7; i>0; i--){
            now[i] = now[i-1];
        }
        now[0] = t;
    }

    public static void rotateLeft(int gear){
        int[] now = gears[gear];
        int t = now[0];
        for(int i = 0; i<7; i++){
            now[i] = now[i + 1];
        }
        now[7] = t;
    }

    public static int calc(){
        int res = 0;
        if(gears[1][0] == 1) res +=1;
        if(gears[2][0] == 1) res +=2;
        if(gears[3][0] == 1) res +=4;
        if(gears[4][0] == 1) res +=8;

        return res;
    }
}
