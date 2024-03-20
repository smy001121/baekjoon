import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken()); // 가로
		int b = Integer.parseInt(st.nextToken()); // 세로
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 자르는 점선의 개수
		
		int[][] arr = new int[b+1][a+1];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if(x == 0) {
				for(int j = 0; j < a; j++) {
					arr[y][j] = 1;
				}
			} else if(x == 1) {
				for(int j = 0; j < b; j++) {
					arr[j][y] = 1;
				}
			}
		}
		
		int max_wid = 0; // 최대 가로
		int max_hei = 0; // 최대 세로
		int count = 0;
		
		for(int i = 1; i <= a; i++) {
			count++;
			max_wid = Math.max(count, max_wid);
			if(arr[0][i] == 1) count = 0;
		}
		
		count = 0;
		
		for(int i = 1; i <= b; i++) {
			count++;
			max_hei = Math.max(count, max_hei);
			if(arr[i][0] == 1) count = 0;
		}
		
		System.out.println(max_wid * max_hei);
		
	}

}
