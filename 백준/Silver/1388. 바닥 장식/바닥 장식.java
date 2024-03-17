import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 세로
		int M = sc.nextInt(); // 가로

		int count = 0;
		char[][] arr = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String s = sc.next();
			arr[i] = s.toCharArray();
		}
	
		
		for(int i = 0; i < N; i++) {
			char pre = ' ';
			for(int j = 0; j < M; j++) {
				char now = arr[i][j];
				if(now != pre && now == '-') {
					count++;
				}
				pre = now;
			}
		}
		
		for(int i = 0; i < M; i++) {
			char pre = ' ';
			for(int j = 0; j < N; j++) {
				char now = arr[j][i];
				if(now != pre && now == '|') {
					count++;
				}
				pre = now;
			}
		}
		
		System.out.println(count);
		
	}

}
