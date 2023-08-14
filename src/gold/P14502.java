package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class P14502 {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[][] map;
    public static int answer = 0;
    public static int N,M;
    public static ArrayList<Integer[]> virus = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Integer[]> safeZone = new ArrayList<>();

        map = new int[N][M];
        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<M; j++){
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                if(val == 0){
                    safeZone.add(new Integer[]{i, j});
                }
                if(val == 2){
                    virus.add(new Integer[]{i, j});
                }
            }
        }
        getCase(0,0,safeZone,new int[3]);

        System.out.println(answer);
    }

    public static void getCase(int level, int start, ArrayList<Integer[]> sz, int[] choice){
        if(level >= 3){
            solve(copyMap(map), choice, sz);
            return;
        }
        for(int i = start; i<sz.size(); i++){
            choice[level] = i;
            getCase(level +1, i +1, sz, choice);
        }
    }

    public static void solve(int[][] map, int[] choice, ArrayList<Integer[]> sz){
        for(int i =0; i<choice.length; i++){
            Integer[] t = sz.get(choice[i]);
            map[t[0]][t[1]] = 1;
        }
        Stack<Integer[]> needVisit = new Stack<>();
        for (Integer[] t : virus) {
            needVisit.push(t);
        }

        int[][] dir = {
                {0,1},{1,0},{-1,0},{0,-1},
        };
        while (!needVisit.isEmpty()) {
            Integer[] now = needVisit.pop();
            for(int i =0; i<dir.length; i++){
                int nr = now[0] + dir[i][0];
                int nc = now[1] + dir[i][1];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0){
                    map[nr][nc] = 2;
                    needVisit.push(new Integer[]{nr, nc});
                }
            }
        }
        int count = 0;
        for(int i =0; i<N; i++){
            for(int j =0; j<M; j++){
                if(map[i][j] == 0){
                    count++;
                }
            }
        }

        answer = Math.max(answer, count);
    }

    public static int[][] copyMap(int[][] map){
        int[][] res = new int[map.length][map[0].length];
        for(int i =0; i<map.length; i++){
            for(int j =0; j<map[i].length ; j++){
                res[i][j] = map[i][j];
            }
        }
        return res;
    }
}
