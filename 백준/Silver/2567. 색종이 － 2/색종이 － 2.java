import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 색종이 개수
		int[][] arr = new int[101][101];
		
		for(int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for(int j = b; j < b+10; j++) {
				for(int k = a; k < a+10; k++) {
					arr[j][k] = 1;
				}
			}
		}
		
		int result = 0;
		
		for(int i = 0; i < arr.length; i++) {
			int pre = 0;
			for(int j = 0; j < arr.length; j++) {
				if(pre != arr[i][j]) {
					result++;
				}
				pre = arr[i][j];
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			int pre = 0;
			for(int j = 0; j < arr.length; j++) {
				if(pre != arr[j][i]) {
					result++;
				}
				pre = arr[j][i];
			}
		}
		
		System.out.println(result);

	}

}
