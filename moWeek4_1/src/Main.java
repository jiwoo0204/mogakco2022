import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int arr[][];
	static boolean visit[][];
	static int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static int n;
	static int m;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		//N * M 입력
		
		arr = new int[n][m];
		visit = new boolean[n][m];
		visit[0][0]	= true;
		
		String s;
		String num[] = new String[m];
		
		for(int i = 0; i < n; i++) {
			s = br.readLine();
			num = s.split("");
			
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(num[j]);
			}
		}
		
		BFS(0, 0);
		
		System.out.print(arr[n-1][m-1]);
		
	}
	
	static void BFS(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y});
		
		while(!queue.isEmpty()) {
			int present[] = queue.poll(); //현재의 위치
			int px = present[0];
			int py = present[1]; //현재 x, y 좌표
			
			for(int i = 0; i < 4; i++) {
				int nx = px + dir[i][0];
				int ny = py + dir[i][1]; //상하좌우 탐색
				
				if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue; //범위를 벗어난 경우
				if (visit[nx][ny] || arr[nx][ny] == 0) continue; //이미 방문했거나 다음 위치의 값이 0일 경우
				
				//조건에 부합하는 경우
				queue.add(new int[] {nx, ny}); //다음 위치 저장
				arr[nx][ny] = arr[px][py] + 1;
				visit[nx][ny] = true;
			}
		}
		
		
	}
}
