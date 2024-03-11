import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int[] arr = new int[n];
		int max = 0;
		int min = 0;
		
		for(int i=0; i<n; i++) {
			arr[i] = scan.nextInt();
			if(min == 0) min = arr[i];
			if(max == 0) max = arr[i];
			else if(max < arr[i]) max = arr[i];
			else if(min > arr[i]) min = arr[i];
		}
		
		System.out.printf("%d %d", min, max);
		
		scan.close();
	}
}