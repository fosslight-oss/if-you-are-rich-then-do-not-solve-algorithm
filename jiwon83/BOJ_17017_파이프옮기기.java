import java.util.*;
import java.io.*;

public class Main {

		
	static StringTokenizer st;
	static int dp [][][]; // 0 = 아래 방향, 1 = 대각선 우하 방향, 2 = 오른쪽 방향
	static int map[][];
	static int N, ans;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		ans = 0;
		map = new int [N+1][N+1];
		dp = new int [3][N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if(map[1][2] ==1 || map[N][N]==1) {
			System.out.println(0);
			return;
		}
		dp();
//		for(int j = 0; j<3; j++) {
//			System.out.println(" dir = "+ j);
//			for(int i=1; i<=N; i++) {
//				System.out.println(Arrays.toString(dp[j][i]));
//			}
//		}
		
		
		System.out.println(dp[0][N][N] + dp[1][N][N] + dp[2][N][N]);

	}
	static int [][] dir = { {1,0}, {1,1}, {0,1} }; 
	
	static void dp() {
		dp[2][1][2] = 1;
		
		for(int i = 1; i<= N; i++) {
			for(int j =1 ; j<= N; j++) {
				// 현재 값을 기준으로 다음 파이프를 놓는다.
				if(map[i][j] == 1) continue;
				
				int nx = i + dir[0][0];
				int ny = j + dir[0][1];
				if( inArea(nx, ny)) {
					dp[0][nx][ny] += dp[0][i][j] + dp[1][i][j];
				}
				nx = i + dir[1][0];
				ny = j + dir[1][1];
				if(inArea(nx, ny) && map[i+dir[0][0]][j+dir[0][1]]!= 1 &&  map[i+dir[2][0]][j+dir[2][1]]!= 1) {
					
					dp[1][nx][ny] += dp[0][i][j] + dp[1][i][j] + dp[2][i][j];
				}
				nx = i + dir[2][0];
				ny = j + dir[2][1];
				if(inArea(nx, ny)) {
					dp[2][nx][ny] += dp[1][i][j] + dp[2][i][j];
				}
				
			}
		}
	}
	static boolean inArea(int x, int y) {
		return x >=1 && y >=1 && x <=N && y <= N;
	}
	
	


}
