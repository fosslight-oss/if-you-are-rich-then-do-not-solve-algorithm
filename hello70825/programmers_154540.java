import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        boolean[][] visited = new boolean[n][m];
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int val = 0;
                    visited[i][j] = true;
                    val += Integer.parseInt(maps[i].substring(j, j+1));
                    xq.add(i);
                    yq.add(j);
                    while(!(xq.isEmpty() || yq.isEmpty())) {
                        int x = xq.poll();
                        int y = yq.poll();
                        for(int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < m && maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                                val += Integer.parseInt(String.valueOf(maps[nx].charAt(ny)));
                                visited[nx][ny] = true;
                                xq.add(nx);
                                yq.add(ny);
                            }
                        }
                    }
                    answer.add(val);
                }
            }
        }

        if (answer.size() == 0) {
            answer.add(-1);
        }
        Collections.sort(answer);
        int[] realAnswer = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            realAnswer[i] = answer.get(i);
        }
        return realAnswer;
    }
}
