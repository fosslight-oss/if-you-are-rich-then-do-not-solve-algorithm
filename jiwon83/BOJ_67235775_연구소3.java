import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int [][] time;
	static int [][] map;
	static ArrayDeque<Point> virus;
	static ArrayList<Point> candidates;
	static int N,M;
	static int blankCount;
	static int [] dx = {0,0,-1,1}, dy= {-1,1,0,0};
	static int ans;
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int [] select;
	
	
	static void input() {
		try {
			ans = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			select = new int[M];
			time = new int[N][N];
			map = new int[N][N];
			virus = new ArrayDeque<>();
			candidates = new ArrayList<>();
			
			for(int i = 0; i< N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if( map[i][j] == 2) {
						candidates.add(new Point(i, j));
					}
					if( map[i][j] == 0) blankCount++;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		input();
		//3개를 선택한다.
		combie(0, -1);
		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);

	}
	static void combie(int k, int pre) {
		if( k == M) {
			int result = bfs();
			ans = Math.min(ans, (result != -1 ? result : ans )) ; 
			return;
		}
		for(int i = pre+1; i<candidates.size(); i++) {
			select[k] = i;
			combie(k+1, i);	
		}
		
	}
	public static int bfs() {
		
		virus = new ArrayDeque<>();
		for(int i = 0; i< N; i++) Arrays.fill(time[i], -1);
		int level = 0;
		int activated = 0;
		
		for(int j = 0; j < M; j++) {
			Point start = candidates.get(select[j]);
			
			virus.addLast(start);
			time[start.x][start.y] = level;
		}
		
		level++; //1
		
		while(!virus.isEmpty()) {
			
			int len = virus.size();
			for(int l = 0; l < len; l++) {
				
				Point now = virus.pollFirst();
				if (map[now.x][now.y]== 0 ) activated++;
				if(blankCount == activated) {
//					System.out.println("모두 바이러스를 퍼뜨렸음 ..");
//					for(int i = 0; i< N; i++) {
//						System.out.println(Arrays.toString(time[i]));
//					}
					return level - 1;
				}
				
				for(int d = 0; d < 4; d++) {
					int nx = now.x + dx[d];
					int ny = now.y + dy[d];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					if(time[nx][ny] != -1) continue;
					if(map[nx][ny] == 1) continue;
					time[nx][ny] = level;
					virus.addLast(new Point(nx, ny));
				}
				
			}
			level++;
		}
		return -1;
	}

}
