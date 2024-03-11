import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			
			double[] arr = new double[3];
			
			for(int i=0; i<3; i++) {
				arr[i] = scan.nextDouble();
			}
			
			Arrays.sort(arr);
			
			if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
				break;
			}
			else {
				if(Math.pow(arr[2], 2) == Math.pow(arr[0], 2) + Math.pow(arr[1], 2)) {
					System.out.println("right");
				}
				else {
					System.out.println("wrong");
				}
			}
		}
		
		scan.close();
	}
}