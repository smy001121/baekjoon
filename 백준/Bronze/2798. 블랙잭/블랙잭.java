import java.util.Scanner;


public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = scan.nextInt();
		}
		
		int max = 0;
		
		for(int i=0; i<n; i++) {
			int n1 = arr[i];
			for(int j=i+1; j<n; j++) {
				int n2 = arr[j];
				for(int k=j+1; k<n; k++) {
					int n3 = arr[k];
					if(max < n1+n2+n3 && n1+n2+n3 <= m) {max = n1 + n2 + n3;}
				}
			}
		}
		
		System.out.println(max);

		scan.close();
	}
}