import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());

		int[][] cost = new int [num][3];
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		} //비용 저장
		
		int count = 0; //최종 비용
		
		//현재 R, G, B를 선택할 경우의 최솟값을 각각 구하기 위해 이전 비용의 누적 최솟값을 사용한다.
		//누적 최솟값은 현재의 RGB 값을 제외한 나머지 중에서 최소 비용을 선택하여 현재의 비용에 더한다.
		
		for(int i = 1; i < num; i++) {
			cost[i][0] += Math.min(cost[i-1][1], cost[i-1][2]);
			cost[i][1] += Math.min(cost[i-1][0], cost[i-1][2]);
			cost[i][2] += Math.min(cost[i-1][0], cost[i-1][1]);
		}
		
		count = Math.min(Math.min(cost[num-1][0], cost[num-1][1]), cost[num-1][2]);
		
		System.out.println(count);
		
	}

}
