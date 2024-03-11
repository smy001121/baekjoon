import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int paper_num = sc.nextInt();
		
		int[][] arr = new int[100][100];
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				arr[i][j] = 0; // 기본값 0
			}
		}
		
		int area = 0;
		
		for(int n = 1; n <= paper_num; n++) {
			
			int N = sc.nextInt(); // row 좌표
			int M = sc.nextInt(); // column 좌표
			
			for(int i = N; i < N+10; i++) {
				for(int j = M; j < M+10; j++) {
					arr[i][j] = n;
				}
			}
		}
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(arr[i][j] != 0) {
					area++;
				}
			}
		}
		
		System.out.println(area);

	}

}
