import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] arr = new int[8];
		String sum = "";
		
		
		for(int i=0; i<8; i++) {
			arr[i] = scan.nextInt();
		}
		
		scan.close(); 
		
		for(int i=0; i<8; i++ ) {
			sum = sum.concat(Integer.toString(arr[i]));
		}
		
		if(sum.equals("12345678")) {
			System.out.println("ascending");
		}
		else if(sum.equals("87654321")) {
			System.out.println("descending");
		}
		else {
			System.out.println("mixed");
		}
		
			
	}
}