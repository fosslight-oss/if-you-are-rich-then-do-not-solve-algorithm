import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N, R;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		 x  y
		 남는 동아리 방의 수 
		 행동 횟수 M, 동방의 개수 N
		 1 _! 2 _! 3 _! 4 _! 5
		N = Integer.parseInt(br.readLine());
		boolean [] wall = new boolean [N];  1 ~ N-1
		R = Integer.parseInt(br.readLine());
		for(int i = 0; iR; i++) {
			String [] temp = br.readLine().split( );
			int x = Integer.parseInt(temp[0]);
			int y = Integer.parseInt(temp[1]);
			for(int j = x; j  y; j++) {
				wall[j] = true;
			}
		}
		int cnt = 0;
		for(int i = 0; i  N; i++) {
			if( !wall[i] ) cnt++;
		}
		System.out.println(cnt);
		
	}

}
