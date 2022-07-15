import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());

		int[][] time = new int [num][2];
		
		
		for(int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		} //시작부터 종료 시간 저장
		
		Arrays.sort(time, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1]==o2[1] ? o1[0]-o2[0] : o1[1]-o2[1];
			}			
		}); //종료 시간 오름차순, 종료 시간이 같을 경우 시작 시간 오름차순
		
		int count = 0; //배정 개수
		int end = 0; //바로 전 종료 시간
		
		for (int i = 0; i < num; i++) {
			if (end <= time[i][0]) { //바로 전의 종료 시간 <= 회의 시작 시간이면 회의실 배정
				count++;
				end = time[i][1]; //종료 시간 업데이트
			}
		}
		
		System.out.println(count);
		
	}

}
