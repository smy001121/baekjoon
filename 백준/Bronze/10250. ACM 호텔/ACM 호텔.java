import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		String[] arr = new String[t];
		
		for(int i=0; i<t; i++) {
			int h = scan.nextInt(); // h층
			int w = scan.nextInt(); // w호
			int n = scan.nextInt(); // n번째 손님
			
			int Y = 0; // 층수
			int X = 0; // 호수
			
			if(n%h == 0) {
				Y = 100 * h;
				X = n / h;
			}
			else {
				Y = 100 * (n % h);
				X = (n / h) + 1;
			}
			
			System.out.println(X + Y);
		}
		
	
		scan.close();
	}
}