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
		
			int N = sc.nextInt(); // 농장의 크기
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String s = sc.next();
				String[] sarr = s.split("");
				for(int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(sarr[j]);
				}
			}
		
			
			int result = 0;
			int start = N/2;
			int end = N/2;
			
			for(int i = 0; i < N; i++) {
				for(int j = start; j <= end; j++) {
					result += arr[i][j];
				}
				if(i < N/2) {
					start--;
					end++;
				} else {
					start++;
					end--;
				}
			}
			
			System.out.println("#" + test_case + " " + result);

		}
	}
}
