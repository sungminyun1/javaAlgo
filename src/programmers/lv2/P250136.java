package programmers.lv2;

import java.util.*;

//PCCP 기출문제 2번 / 석유 시추
public class P250136 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.solution(new int[][] {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}
        );

        System.out.println(res);
    }


    static class Solution {
        public Map<String, Integer> map = new HashMap<>();
        public int solution(int[][] land) {

            int token = -1;
            for (int i = 0; i < land.length; i++) {
                for (int j = 0; j < land[0].length; j++) {
                    if (land[i][j] == 1) {
                        int size = search(land, token, i, j);
                        map.put("" + token, size);
                        token--;
                    }
                }
            }
            int answer = 0;

            for (int j = 0; j < land[0].length; j++) {
                int tsize = 0;
                Set<String> visited = new HashSet<>();
                for(int i = 0; i < land.length; i++) {
                    if(land[i][j] < 0){
                        visited.add("" + land[i][j]);
                    }
                }

                for (String v : visited) {
                    tsize += map.get(v);
                }

                answer = Math.max(answer, tsize);
            }

            return answer;
        }

        public int search(int[][] land, int token, int row, int col) {
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{row, col});

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            int size = 0;

            while(!queue.isEmpty()) {
                int[] poll = queue.poll();
                if(land[poll[0]][poll[1]] == token) continue;

                land[poll[0]][poll[1]] = token;
                size++;

                for(int i = 0; i < dx.length; i++) {
                    int x = poll[0] + dx[i];
                    int y = poll[1] + dy[i];

                    if(x >= 0 && x < land.length && y >= 0 && y < land[0].length && land[x][y] == 1) {
                        queue.add(new int[]{x, y});
                    }
                }
            }
            return size;
        }
    }




}
