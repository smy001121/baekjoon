import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] arr = new int[10];
		int[] arr2 = new int[10];
		int count = 0;
		
		for(int i=0; i<10; i++) {
			arr[i] = scan.nextInt();
			arr2[i] = arr[i] % 42;
		}
		
		for(int i=0; i<10; i++) {
			int tmp = 0;
			for(int j=i+1; j<10; j++) {
				if(arr2[j] == arr2[i]) {
					tmp++;
				}
			}
			if(tmp == 0) count++;
		}
		
		System.out.println(count);
		
		scan.close();
	}
}