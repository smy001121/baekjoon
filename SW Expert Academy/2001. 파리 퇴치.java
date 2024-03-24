import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		int N = sc.nextInt(); // 배열 크기
			int M = sc.nextInt(); // 파리채 크기
			
			int[][] arr = new int[N][N];
			int result = 0;
			int sum = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i <= N-M; i++) {
				for(int j = 0; j <= N-M; j++) {
					for(int k = 0; k < M; k++) {
						for(int l = 0; l < M; l++) {
							sum = sum + arr[i+k][j+l];
						}
					}
					result = Math.max(sum, result);
					sum = 0;
				}
			}
			
			System.out.println("#" + test_case + " " + result);
		}
	}
}
